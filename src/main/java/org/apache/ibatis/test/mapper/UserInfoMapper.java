package org.apache.ibatis.test.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.test.entity.UserInfo;

public interface UserInfoMapper {
  @Select("SELECT * FROM user_info WHERE id = #{id}")
  UserInfo selectUserInfoById(int id);

  @Select("SELECT * FROM ${user_info} WHERE id = #{id}")
  UserInfo selectUserInfoById2(@Param("user_info") String userInfo, int id);
}
