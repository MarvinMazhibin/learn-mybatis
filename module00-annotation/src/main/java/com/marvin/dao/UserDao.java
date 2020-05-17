
/*
 * @author: marvin
 * @software: IntelliJ IDEA
 * @file: UserDao.java
 * @time: 2020-05-14 13:47
 */

package com.marvin.dao;

import com.marvin.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {

    /**
     * 查询所有用户
     * @return
     */

    @Results(id="userMap",
            value= {
                    @Result(id=true,column="id",property="userId"),
                    @Result(column="username",property="userName"),
                    @Result(column="sex",property="userSex"),
                    @Result(column="address",property="userAddress"),
                    @Result(column="birthday",property="userBirthday")
            })
    @Select("select * from user")
    List<User> findAll();

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    @Select("select * from user where id = #{userId} ")
    @ResultMap("userMap")
    User findById(Integer userId);

    /**
     * 插入一条数据
     * @param user
     * @return 影响的行数
     */
    @Insert("insert into user(username,sex,birthday,address)values(#{userName},#{userSex},#{userBirthday},#{userAddress})")
    @SelectKey(keyColumn="id",keyProperty="userId",
            resultType=Integer.class,before = false,
            statement = { "select last_insert_id()" })
    int saveUser(User user);

    /**
     * 更新用户
     * @param user
     * @return 影响的行数
     */

    @Update("update user set username=#{userName},address=#{userAddress},sex=#{userSex},birthday=#{userBirthday} where id =#{userId} ")
    int updateUser(User user);

    /**
     * 根据id删除数据
     * @param userId
     * @return 影响的行数
     */
    @Delete("delete from user where id = #{userId} ")
    int deleteUser(Integer userId);

    /**
     * 模糊查询用户名
     * @param username
     * @return
     */
    @Select("select * from user where username like #{username} ")
    @ResultMap("userMap")
    List<User> findByName(String username);

    /**
     * 查询一共多少条
     * @return
     */
    @Select("select count(*) from user ")
    int findTotal();


}
