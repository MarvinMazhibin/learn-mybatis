
/*
 * @author: marvin
 * @software: IntelliJ IDEA
 * @file: MybatisTest.java
 * @time: 2020-05-14 13:59
 */

package com.marvin.test;

import com.marvin.dao.UserDao;
import com.marvin.domain.QueryVo;
import com.marvin.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    private InputStream stream;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private UserDao userDao;

    @Before
    public void init() throws IOException {
        stream = Resources.getResourceAsStream("SqlMapConfig1.xml");
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
        }
    }

    @Test
    public void findById() {
        User user = userDao.findById(45);
        System.out.println(user);
    }

    @Test
    public void saveUser() {
        User user = new User();
        user.setUserName("老马");
        user.setUserBirthday(new Date());
        user.setUserSex("男");
        user.setUserAddress("北京市朝阳区");

        int i = userDao.saveUser(user);
        System.out.println(i);
        System.out.println(user);
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setUserId(45);
        user.setUserName("老马");
        user.setUserBirthday(new Date());
        user.setUserSex("男");
        user.setUserAddress("北京市朝阳区");

        int i = userDao.updateUser(user);
        System.out.println(i);
        System.out.println(user);
    }

    @Test
    public void deleteUser() {
        int i = userDao.deleteUser(58);
        System.out.println(i);
    }

    @Test
    public void findByName() {
        List<User> users = userDao.findByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void findTotal() {
        int total = userDao.findTotal();
        System.out.println(total);
    }

    @Test
    public void findByCondition() {
        User u = new User();
        u.setUserName("老王");
        u.setUserSex("男");

        List<User> users = userDao.findByCondition(u);
        for(User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void findByVo() {
        List<Integer> list = new ArrayList<>();
        list.add(41);
        list.add(42);
        list.add(45);

        QueryVo queryVo = new QueryVo();
        queryVo.setIds(list);

        List<User> users = userDao.findInIds(queryVo);
        for (User user : users) {
            System.out.println(user);
        }
    }




}
