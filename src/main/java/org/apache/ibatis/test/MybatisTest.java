package org.apache.ibatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.test.domain.Author;
import org.apache.ibatis.test.domain.Blog;
import org.apache.ibatis.test.entity.BlogDO;
import org.apache.ibatis.test.entity.UserInfoDO;
import org.apache.ibatis.test.mapper.UserInfoMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
  private static SqlSession sqlSession;

  private UserInfoMapper mapper;

  @Before
  public void init() throws IOException {
    String resource = "config/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    sqlSession = sqlSessionFactory.openSession();
  }

  @Test
  public void test() {
    mapper = sqlSession.getMapper(UserInfoMapper.class);
    UserInfoDO userInfoDO = mapper.selectUserInfoById(1);
    System.out.println(userInfoDO);
  }

  @Test
  public void blogTest(){
    Blog blog = sqlSession.selectOne("org.apache.ibatis.test.mapper.BlogMapper.selectBlogById",1);
    System.out.println(blog);
  }

  @Test
  public void authTest(){
    Author author = sqlSession.selectOne("org.apache.ibatis.test.mapper.BlogMapper.selectAuthById",101);
    System.out.println(author);
  }
  @Test
  public void commentTest(){
    List<Blog> blog = sqlSession.selectList("org.apache.ibatis.test.mapper.BlogMapper.selectCommentById",1);
    System.out.println(blog);
  }

}
