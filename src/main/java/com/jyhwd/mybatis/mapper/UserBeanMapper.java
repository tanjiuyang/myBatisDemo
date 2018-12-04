package com.jyhwd.mybatis.mapper;

import com.jyhwd.mybatis.beans.UserBean;

/**
 * @创建者：tanjiuyang
 * @时间：16:17 2018/12/3
 */
public interface UserBeanMapper {
    /**
     * 新增用户
     * @author tanjiuyang
     * @date 2018/12/3 16:18
     * @param user
     * @return int
     */
    public int insertUser(UserBean user);

    public UserBean selectUserByid(int id);
}
