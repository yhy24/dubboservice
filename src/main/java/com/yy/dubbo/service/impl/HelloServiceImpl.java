package com.yy.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yy.dubbo.cache.CacheFactoryUtils;
import com.yy.dubbo.dao.UserDao;
import com.yy.dubbo.pojo.User;
import com.yy.dubbo.server.SwfNoServer;
import com.yy.dubbo.service.HelloService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HelloServiceImpl implements HelloService {

    Logger logger = Logger.getLogger(HelloServiceImpl.class);

    @Autowired
    UserDao userDao;
    @Autowired
    SwfNoServer swfNoServer;


    @Override
    public String sayHello(String name) {
        return "hello "+name;
    }

    @Override
    public String findUser() {
        List<User> users = userDao.findUser();
        return users.toString();
    }

    @Override
    public String updateUser() {
        User user = new User();
        user.setUsername("James");
        user.setId(5);
        user.setAge(33);
        user.setPassword("23-6");
        user.setSexly("man");
        user.setCode("3");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        user.setModify_date(sdf.format(date));
        int n = userDao.updateUser(user);
        if (n == 1) {
            logger.info("更新成功!");
            return "1";
        }
        return "2";
    }
    @Transactional
    @Override
    public String createUser() {
        Map map = new HashMap();
        User user = new User();
        user.setUsername("nana");
        user.setAge(23);
        user.setMark("puyang");
        user.setPassword("321");
        user.setSexly("g");
        user.setCode("0");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user.setCreate_date(sdf.format(date));
        String indicSeq = swfNoServer.getIndicSeq();
        logger.info("------indicSeq-----"+indicSeq);
        user.setInDicSeq(indicSeq);
        map.put(indicSeq,user.toString());
        int b = userDao.insertUser(user);
        if (b == 1) {
            CacheFactoryUtils.setString(map);
            return "1";
        }
        return "2";
    }

    @Override
    public String userDelete(Integer id) {
        int m = userDao.deleteUser(id);
        if (m == 1) {
            return "1";
        }
        return null;
    }

    @Override
    public String selectById(Integer id) {
//        logger.info("---------id----------"+id);
        User user = userDao.selectById(id);
        if (user != null) {
            return user.toString();
        }
        return "not anybody";
    }


    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));
    }
}
