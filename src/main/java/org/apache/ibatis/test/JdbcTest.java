package org.apache.ibatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

public class JdbcTest {

  private Connection connection;

  @Before
  public void init() throws Exception {
    Class.forName("com.mysql.cj.jdbc.Driver");
    //准备用户名、密码、数据库地址
    String name = "root";
    String password = "123456";
    String url = "jdbc:mysql://localhost:3306/mybatis-test";
    //创建数据库连接
    connection = DriverManager.getConnection(url, name, password);
  }

  @Test
  public void jdbcTest() throws SQLException {
    String sql = "select * from author where id > ?";
    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setInt(1,100);
    ResultSet resultSet = statement.executeQuery();
    while (resultSet.next()){
      System.out.println("id:"+resultSet.getString("id")+",username:"+
        resultSet.getString("username")+",password:"+resultSet.getString("password"));
    }
  }
}
