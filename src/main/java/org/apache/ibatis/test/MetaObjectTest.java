package org.apache.ibatis.test;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.test.domain.Blog;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MetaObjectTest {
  @Test
  public void Test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    Object object = new Blog();
    Configuration configuration = new Configuration();
    MetaObject metaObject = configuration.newMetaObject(object);
    metaObject.setValue("title","hello");
    System.out.println(metaObject.getValue("title"));
  }
}
