package org.apache.ibatis.test.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.test.entity.UserInfoDO;

public interface UserInfoMapper {
  @Select("SELECT * FROM user_info WHERE id = #{id}")
  UserInfoDO selectUserInfoById(int id);
}
