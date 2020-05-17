
/*
 * @author: marvin
 * @software: IntelliJ IDEA
 * @file: AccountDao.java
 * @time: 2020-05-17 17:52
 */

package com.marvin.dao;

import com.marvin.domain.Account;

import java.util.List;

public interface AccountDao {

    List<Account> findAccAll();
}
