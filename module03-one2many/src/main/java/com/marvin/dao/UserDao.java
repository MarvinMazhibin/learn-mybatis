
/*
 * @author: marvin
 * @software: IntelliJ IDEA
 * @file: UserDao.java
 * @time: 2020-05-17 15:11
 */

package com.marvin.dao;

import com.marvin.domain.User;

import java.util.List;

public interface UserDao {

    /**
     * select u.*,
     *        a.id as aid ,
     *        a.uid,
     *        a.money
     * from user u
     * left join account a
     * on u.id =a.uid    一对多 一个用户多个账户
     * @return
     */
    List<User> findAll();
}
