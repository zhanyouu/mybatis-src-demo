package org.apache.ibatis.test;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.test.entity.UserInfo;
import org.apache.ibatis.test.mapper.UserInfoMapper;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.io.IOException;

public class MybatisTest {
  public static void main(String[] args) throws IOException {
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/mybatis-test?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
    String username = "root";
    String password = "123456";
    DataSource dataSource = new PooledDataSource(driver,url,username,password);
    TransactionFactory transactionFactory = new JdbcTransactionFactory();
    Environment environment = new Environment("development", transactionFactory, dataSource);
    Configuration configuration = new Configuration(environment);
    configuration.addMapper(UserInfoMapper.class);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);
    UserInfo userInfo = mapper.selectUserInfoById(1);
    System.out.println(userInfo);
  }

}
