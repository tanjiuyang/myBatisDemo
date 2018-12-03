package com.jyhwd.mybatis.Main;

import com.jyhwd.mybatis.Tools.DBTools;
import com.jyhwd.mybatis.beans.UserBean;
import com.jyhwd.mybatis.mapper.UserBeanMapper;
import org.apache.ibatis.session.SqlSession;

/**
 * @创建者：tanjiuyang
 * @时间：16:43 2018/12/3
 */
public class TestMain {


    public static void main(String[] args) {
    insertUser();

    }


    private static void insertUser(){
        SqlSession session = DBTools.getSqlSession();
        UserBeanMapper mapper = session.getMapper(UserBeanMapper.class);
        UserBean userBean = new UserBean("zhangzihao","123456");
        try {
            mapper.insertUser(userBean);
            System.out.println(userBean.toString());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }

}
