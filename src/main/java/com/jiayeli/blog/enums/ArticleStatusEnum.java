package com.jiayeli.blog.enums;

import lombok.Getter;

@Getter
public enum ArticleStatusEnum {
  draft("draft"),
  published("published"),
  archived("archived"),
  deleted("deleted");

  private final String value;

  ArticleStatusEnum(String value) {
    this.value = value;
  }

}

