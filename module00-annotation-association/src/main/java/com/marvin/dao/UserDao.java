
/*
 * @author: marvin
 * @software: IntelliJ IDEA
 * @file: UserDao.java
 * @time: 2020-05-17 17:58
 */

package com.marvin.dao;

import com.marvin.domain.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {

    @Select("select * from user where id = #{userId}")
    @Results(id="userMap",
            value= {
                    @Result(id=true,column="id",property="userId"),
                    @Result(column="username",property="userName"),
                    @Result(column="sex",property="userSex"),
                    @Result(column="address",property="userAddress"),
                    @Result(column="birthday",property="userBirthday")
                    })
    User findUserById(Integer userId);
}
