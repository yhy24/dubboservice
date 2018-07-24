package com.yy.dubbo.cache;

import com.yy.dubbo.exception.ExceptionDubbo;
import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * @Author: yhy
 * @Date: 2018/7/24 15:38
 * @Version 1.0
 * 简单的使用redis
 */
public class CacheFactoryUtils {

    static Logger logger = Logger.getLogger(CacheFactoryUtils.class);

    static Jedis jedis;

    static {
        jedis = new Jedis("192.168.182.135",6379);
    }

    public static void setString(Map<String,Object> map){
        if (map != null && map.size() > 0) {
            for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext(); ) {
                Map.Entry entry = (Map.Entry) iterator.next();
                String key = (String) entry.getKey();
                logger.info("---key---" + key);
                String value = (String) entry.getValue();
                logger.info("---value----" + value);
                jedis.set(key, value);
                logger.info("保存redis成功");
            }
        } else {
            logger.info("参数为空,请确认");
        }
    }

    public static String getString(String key) throws ExceptionDubbo {
        String value;
        if (key == null) {
            throw new ExceptionDubbo("2999","传入的key为空");
        }
        value = jedis.get(key);
        return value;
    }

    public static void main(String[] args) {

      /*  try {
            String name = getString("name");
            logger.info("--name--"+name);
        } catch (ExceptionDubbo e) {
            System.out.println(e.getErrorCode()+"---------"+e.getErrorMessage());
        }*/
    }
}
