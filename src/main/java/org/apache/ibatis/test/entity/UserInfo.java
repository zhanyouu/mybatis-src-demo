package org.apache.ibatis.test.entity;

import lombok.Data;

@Data
public class UserInfo {

  private Integer id;

  private String name;

  private String age;

  @Override
  public String toString() {
    return "UserInfo{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", age='" + age + '\'' +
      '}';
  }
}
