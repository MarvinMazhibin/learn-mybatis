
/*
 * @author: marvin
 * @software: IntelliJ IDEA
 * @file: UserDao.java
 * @time: 2020-05-17 17:58
 */

package com.marvin.dao;

import com.marvin.domain.Account;
import com.marvin.domain.User;

import java.util.List;

public interface UserDao {

    /**
     * 查询所有user
     * @return
     */
    List<User> findUserAll();



}
