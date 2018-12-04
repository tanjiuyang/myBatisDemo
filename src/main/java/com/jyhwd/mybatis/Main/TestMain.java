package com.jyhwd.mybatis.Main;

import com.jyhwd.mybatis.Tools.DBTools;
import com.jyhwd.mybatis.beans.UserBean;
import com.jyhwd.mybatis.mapper.UserBeanMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;


/**
 * @创建者：tanjiuyang
 * @时间：16:43 2018/12/3
 */
public class TestMain {

    private static Logger logger = Logger.getLogger(TestMain.class);

    public static void main(String[] args) {
        //insertUser();
          selectUser(5);

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

    private  static void selectUser(int id){
        SqlSession session = DBTools.getSqlSession();
        UserBeanMapper mapper =session.getMapper(UserBeanMapper.class);
        try {
            UserBean user = mapper.selectUserByid(id);
            logger.debug("根据用户Id:"+id+",查询用户信息:"+user.toString());

            //System.out.println(user.toString());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }

    }

}
