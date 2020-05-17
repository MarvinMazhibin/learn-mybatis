
/*
 * @author: marvin
 * @software: IntelliJ IDEA
 * @file: RoleDao.java
 * @time: 2020-05-17 15:40
 */

package com.marvin.dao;

import com.marvin.domain.Role;

import java.util.List;

public interface RoleDao {

    /**
     * SELECT r.*,
     *         u.id uid,
     *         u.username username,
     *         u.birthday birthday,
     *         u.sex sex,
     *         u.address address
     * FROM ROLE r
     * INNER JOIN USER_ROLE ur
     * ON r.id = ur.rid
     * INNER JOIN USER u
     * ON ur.uid = u.id;    一个角色有多个user
     * @return
     */
    List<Role> findAll();

    /**
     * 查询出一个role对应的所有user
     * @return
     */
    Role findById(Integer roleId);
}
