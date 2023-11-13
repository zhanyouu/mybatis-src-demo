package org.apache.ibatis.test.entity;

import lombok.Data;

@Data
public class UserInfoDO {

  private Integer id;

  private String name;

  private String age;

  @Override
  public String toString() {
    return "UserInfoDO{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", age='" + age + '\'' +
      '}';
  }
}
