
/*
 * @author: marvin
 * @software: IntelliJ IDEA
 * @file: AccountDao.java
 * @time: 2020-05-17 10:41
 */

package com.marvin.dao;


import com.marvin.domain.Account;

import java.util.List;

public interface AccountDao {
    /**
     * SELECT account.*,
     *        user.username,
     *        user.address
     * FROM account
     * inner join user
     * on account.uid = user.id;一对一或者多对一
     * @return
     */
    List<Account> findAll();
}
