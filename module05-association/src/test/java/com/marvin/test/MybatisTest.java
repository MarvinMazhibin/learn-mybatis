
/*
 * @author: marvin
 * @software: IntelliJ IDEA
 * @file: MybatisTest.java
 * @time: 2020-05-14 13:59
 */

package com.marvin.test;


import com.marvin.dao.AccountDao;
import com.marvin.domain.Account;
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
    private AccountDao accountDao;

    @Before
    public void init() throws IOException {
        stream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        sqlSession = sqlSessionFactory.openSession();
        accountDao = sqlSession.getMapper(AccountDao.class);

    }

    @After
    public void destory() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        stream.close();
    }

    @Test
    public void findAll() {

        List<Account> accounts = accountDao.findAccAll();
        //下面的代码如果注释 后台执行的是select * from user; 如果不注释则执行完上条sql后 一条一条的去AccountDao.findAccById
        //这就是延迟加载 不需要就不查询，需要才一条一条的去查。但是缺点是 造成用户等待时长变长
        for (Account account : accounts) {
            System.out.println(account);
        }


    }







}
