package org.apache.ibatis.test.entity;

import lombok.Data;

@Data
public class BlogDO {
  private Integer id;
  private Integer authorId;
  private String title;
  private String body;

  @Override
  public String toString() {
    return "BlogDO{" +
      "id=" + id +
      ", authorId=" + authorId +
      ", title='" + title + '\'' +
      ", body='" + body + '\'' +
      '}';
  }
}
