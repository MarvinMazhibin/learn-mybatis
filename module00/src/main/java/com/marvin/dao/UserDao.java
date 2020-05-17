
/*
 * @author: marvin
 * @software: IntelliJ IDEA
 * @file: UserDao.java
 * @time: 2020-05-14 13:47
 */

package com.marvin.dao;

import com.marvin.domain.QueryVo;
import com.marvin.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {

    /**
     * 查询所有用户
     * @return
     */
    //@Select("select * from user")
    List<User> findAll();

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    User findById(Integer userId);

    /**
     * 插入一条数据
     * @param user
     * @return 影响的行数
     */
    int saveUser(User user);

    /**
     * 更新用户
     * @param user
     * @return 影响的行数
     */
    int updateUser(User user);

    /**
     * 根据id删除数据
     * @param userId
     * @return 影响的行数
     */
    int deleteUser(Integer userId);

    /**
     * 模糊查询用户名
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     * 查询一共多少条
     * @return
     */
    int findTotal();

    /**
     * 根据条件查询  动态sql where - if
     * @return
     */
    List<User> findByCondition(User user);

    /**
     * 根据QueryVo的条件查询用户 SELECT * FROM USERS WHERE id IN (10,89,16)
     * @return
     */
    List<User> findInIds(QueryVo vo);
}
