
/*
 * @author: marvin
 * @software: IntelliJ IDEA
 * @file: AccountDao.java
 * @time: 2020-05-17 17:52
 */

package com.marvin.dao;

import com.marvin.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountDao {

    @Select("select * from account")
    @Results(id="accountMap",
            value= {
                    @Result(id=true,column="id",property="id"),
                    @Result(column="uid",property="uid"),
                    @Result(column="money",property="money"),
                    @Result(column="uid", property="user",
                            one=@One(select="com.marvin.dao.UserDao.findUserById",
                                    fetchType= FetchType.LAZY))
                    })
    //fetchType 会覆盖全局的配置参数 lazyLoadingEnabled。代表加载方式，一般如果要延迟加载都设置为 LAZY 的值
    List<Account> findAccAll();
}
