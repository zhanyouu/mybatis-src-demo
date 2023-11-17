package org.apache.ibatis.test.domain;

import lombok.Data;

@Data
public class Author {
  private String username;
  private String password;
  private String email;

  @Override
  public String toString() {
    return "Author{" +
      "username='" + username + '\'' +
      ", password='" + password + '\'' +
      ", email='" + email + '\'' +
      '}';
  }
}
