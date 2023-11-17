package org.apache.ibatis.test.interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.test.page.Page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

@Intercepts(@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class}))
public class MyInterceptor implements Interceptor {
  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    //1、查询总数
    //2、修改原生sql
    StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
    BoundSql boundSql = statementHandler.getBoundSql();
    //获取原生sql
    String sql = boundSql.getSql();
    //解析参数
    Object parameterObject = boundSql.getParameterObject();
    Page page = null;
    if (parameterObject instanceof Page) {
      page = (Page) parameterObject;
    } else if (parameterObject instanceof Map) {
      page = (Page) ((Map<?, ?>) parameterObject).values().stream().filter(v -> v instanceof Page).findFirst().orElse(null);
    }
    if (page == null) {
      return invocation.proceed();
    }
    page.setTotal(getTotal(invocation));
    String newSql = String.format("%s limit %s offset %s", sql, page.getPageSize(), page.getPageNo());
    SystemMetaObject.forObject(boundSql).setValue("sql", newSql);
    return invocation.proceed();
  }

  private int getTotal(Invocation invocation) throws SQLException {
    int total = 0;
    StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
    BoundSql boundSql = statementHandler.getBoundSql();
    String sql = boundSql.getSql();
    String newSql = String.format("select count(1) from (%s) as _page", sql);
    //jdbc
    Connection connection = (Connection) invocation.getArgs()[0];
    PreparedStatement preparedStatement = connection.prepareStatement(newSql);
    statementHandler.getParameterHandler().setParameters(preparedStatement);
    ResultSet resultSet = preparedStatement.executeQuery();
    if (resultSet.next()) {
      total = resultSet.getInt(1);
    }
    System.out.println("total = " + total);
    preparedStatement.close();
    return total;
  }

  @Override
  public Object plugin(Object target) {
    return Interceptor.super.plugin(target);
  }

  @Override
  public void setProperties(Properties properties) {
    Interceptor.super.setProperties(properties);
  }
}
