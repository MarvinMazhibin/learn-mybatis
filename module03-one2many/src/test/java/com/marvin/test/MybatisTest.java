
/*
 * @author: marvin
 * @software: IntelliJ IDEA
 * @file: MybatisTest.java
 * @time: 2020-05-14 13:59
 */

package com.marvin.test;

import com.marvin.dao.UserDao;
import com.marvin.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    private InputStream stream;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private UserDao userDao;

    @Before
    public void init() throws IOException {
        stream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        sqlSession = sqlSessionFactory.openSession();
        userDao = sqlSession.getMapper(UserDao.class);

    }

    @After
    public void destory() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        stream.close();
    }

    @Test
    public void findAll() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
            System.out.println(user.getAccounts());
            System.out.println("--------------------");
        }
    }





}
