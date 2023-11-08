package org.apache.ibatis.test.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.test.entity.UserInfo;

public interface UserInfoMapper {
  @Select("SELECT * FROM user_info WHERE id = #{id}")
  UserInfo selectUserInfoById(int id);
}
