# nextTask
> add article manager fature

```roomsql
CREATE TABLE article (
id VARCHAR(64) PRIMARY KEY,
title VARCHAR(128),
author VARCHAR(32),
category VARCHAR(40),
description TEXT,
image VARCHAR(255),
publish_date DATE,
content TEXT,
tags VARCHAR(255),
comments VARCHAR(255),
likes VARCHAR(255),
dislikes VARCHAR(255),
share_count INT,
view_count INT,
status ENUM('draft', 'published', 'archived', 'deleted'),
created_at DATETIME,
updated_at DATETIME,
deleted_at DATETIME,
is_draft BOOLEAN,
is_deleted BOOLEAN,
is_published BOOLEAN,
is_archived BOOLEAN,
is_public BOOLEAN
);

CREATE TABLE articles (
  id INT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  author VARCHAR(255) NOT NULL,
  category VARCHAR(255) NOT NULL,
  description TEXT,
  image VARCHAR(255),
  publishDate DATE,
  content TEXT,
  shareCount INT,
  viewCount INT,
  status VARCHAR(50) NOT NULL,
  createdAt DATETIME,
  updatedAt DATETIME,
  deletedAt DATETIME,
  isDraft TINYINT(1) DEFAULT 0,
  isDeleted TINYINT(1) DEFAULT 0,
  isPublished TINYINT(1) DEFAULT 0,
  isArchived TINYINT(1) DEFAULT 0,
  isPublic TINYINT(1) DEFAULT 0
  );

CREATE TABLE article_tags (
id INT PRIMARY KEY AUTO_INCREMENT,
articleId INT,
tag VARCHAR(255),
FOREIGN KEY (articleId) REFERENCES articles(id)
);

CREATE TABLE article_comments (
id INT PRIMARY KEY AUTO_INCREMENT,
articleId INT,
comment TEXT,
FOREIGN KEY (articleId) REFERENCES articles(id)
);

CREATE TABLE article_likes (
id INT PRIMARY KEY AUTO_INCREMENT,
articleId INT,
userId INT,
FOREIGN KEY (articleId) REFERENCES articles(id),
FOREIGN KEY (userId) REFERENCES users(id)
);

CREATE TABLE article_dislikes (
id INT PRIMARY KEY AUTO_INCREMENT,
articleId INT,
userId INT,
FOREIGN KEY (articleId) REFERENCES articles(id),
FOREIGN KEY (userId) REFERENCES users(id)
);


CREATE INDEX idx_tags ON article_tags(tag);
CREATE INDEX idx_likes ON article_likes(articleId);
CREATE INDEX idx_dislikes ON article_dislikes(articleId);

-- 查询所有文章的基本信息：
SELECT id, title, author, category, publishDate
FROM articles;

-- 查询特定文章的详细信息（包括标签、评论、点赞和踩的数量）：
SELECT a.id, a.title, a.author, a.category, a.publishDate,
GROUP_CONCAT(t.tag) AS tags,
COUNT(c.id) AS commentCount,
COUNT(l.id) AS likeCount,
COUNT(d.id) AS dislikeCount
FROM articles AS a
LEFT JOIN article_tags AS t ON a.id = t.articleId
LEFT JOIN article_comments AS c ON a.id = c.articleId
LEFT JOIN article_likes AS l ON a.id = l.articleId
LEFT JOIN article_dislikes AS d ON a.id = d.articleId
WHERE a.id = <article_id>
GROUP BY a.id;


--  根据标签筛选文章：
SELECT a.id, a.title, a.author, a.category, a.publishDate
FROM articles AS a
JOIN article_tags AS t ON a.id = t.articleId
WHERE t.tag = '标签名称';

-- 根据评论数和点赞数进行排序查询：
SELECT a.id, a.title, a.author, a.category, a.publishDate,
COUNT(c.id) AS commentCount,
COUNT(l.id) AS likeCount
FROM articles AS a
LEFT JOIN article_comments AS c ON a.id = c.articleId
LEFT JOIN article_likes AS l ON a.id = l.articleId
GROUP BY a.id
ORDER BY commentCount DESC, likeCount DESC;
```