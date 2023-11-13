package org.apache.ibatis.test.domain;

import lombok.Data;

@Data
public class Comment {
  private Integer blogId;
  private String name;
  private String comment;

  @Override
  public String toString() {
    return "Comment{" +
      "name='" + name + '\'' +
      ", comment='" + comment + '\'' +
      '}';
  }
}
