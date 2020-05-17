
/*
 * @author: marvin
 * @software: IntelliJ IDEA
 * @file: UserDao.java
 * @time: 2020-05-17 17:58
 */

package com.marvin.dao;

import com.marvin.domain.Account;
import com.marvin.domain.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserDao {

    /**
     * 查询所有user
     * @return
     */
    @Select("select * from user")
    @Results(id="userMap",
            value= {
                    @Result(id=true,column="id",property="userId"),
                    @Result(column="username",property="userName"),
                    @Result(column="sex",property="userSex"),
                    @Result(column="address",property="userAddress"),
                    @Result(column="birthday",property="userBirthday"),
                    @Result(column="id",property="accounts",
                            many=@Many(select="com.marvin.dao.AccountDao.findAccById",
                                    fetchType= FetchType.LAZY))
                    })
    //fetchType 会覆盖全局的配置参数 lazyLoadingEnabled。代表加载方式，一般如果要延迟加载都设置为 LAZY 的值
    List<User> findUserAll();



}
