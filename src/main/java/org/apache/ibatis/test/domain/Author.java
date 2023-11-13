package org.apache.ibatis.test.domain;

import lombok.Data;

@Data
public class Author {
  private String userName;
  private String password;
  private String email;

  @Override
  public String toString() {
    return "Author{" +
      "userName='" + userName + '\'' +
      ", password='" + password + '\'' +
      ", email='" + email + '\'' +
      '}';
  }
}
