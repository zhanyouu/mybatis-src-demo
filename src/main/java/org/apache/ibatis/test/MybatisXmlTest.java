package org.apache.ibatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.test.entity.UserInfo;

import java.io.IOException;
import java.io.InputStream;

public class MybatisXmlTest {
  public static void main(String[] args) throws IOException {
    String resource = "config/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    UserInfo userInfo = sqlSession.selectOne("org.apache.ibatis.test.mapper.UserInfoMapper.selectUserInfo", 1);
    System.out.println(userInfo);
  }
}
