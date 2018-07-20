package com.yy.dubbo.quartz;

import com.yy.dubbo.dao.UserDao;
import com.yy.dubbo.pojo.User;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
/**
 * @Author: yhy
 * @Date: 2018/7/20 11:29
 * @Version 1.0
 */

public class HandleTaskQuartz {
    Logger logger = Logger.getLogger(HandleTaskQuartz.class);

    @Autowired
    UserDao userDao;

    public void hadleCode() {
        List<User> users = userDao.findUser();
        if (users != null) {
            for (User user:users) {
                handlCode(user);
            }
        } else {
            logger.info("对象存在");
        }
    }
/*对code进行定时更新*/
    private void handlCode(User user) {
        String code = user.getCode();
        Integer id = user.getId();
        if ("0".equals(code)) {
            int i = userDao.updateCodeById(id);
            if (i == 1) {
                logger.info("code更新成功");
            }
        } else {
            logger.info("code不为0");
        }
    }
}
