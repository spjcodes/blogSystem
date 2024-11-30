package com.jiayeli.blog.enums;

import lombok.Getter;

@Getter
public enum ArticleStatusEnum {
  Draft("Draft"),
  Published("Published"),
  Archived("Archived"),
  Deleted("Deleted");

  private final String value;

  ArticleStatusEnum(String value) {
    this.value = value;
  }

}