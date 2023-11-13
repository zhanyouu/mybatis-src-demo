package org.apache.ibatis.test.domain;

import lombok.Data;
import java.util.List;

@Data
public class Blog {
  private Integer id;
  private String title;
  private String body;
  private Author author;
  private List<Comment> comments;

  @Override
  public String toString() {
    return "Blog{" +
      "id=" + id +
      ", title='" + title + '\'' +
      ", body='" + body + '\'' +
      ", author=" + author +
      ", comments=" + comments +
      '}';
  }
}
