package org.apache.ibatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.test.entity.UserInfo;
import org.apache.ibatis.test.mapper.UserInfoMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {
  private static SqlSession sqlSession;

  @Before
  public void init() throws IOException {
    String resource = "config/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    sqlSession = sqlSessionFactory.openSession();
  }

  @Test
  public void Test() {
    UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);
    UserInfo userInfo = mapper.selectUserInfoById(1);
    UserInfo userInfo2 = sqlSession.selectOne("org.apache.ibatis.test.mapper.UserInfoMapper.selectUserInfoById", 1);
    System.out.println(userInfo==userInfo2);
  }

}
