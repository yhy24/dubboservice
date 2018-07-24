package com.yy.dubbo.server;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Author: yhy
 * @Date: 2018/7/24 17:04
 * @Version 1.0
 */
@Component
public class SwfNoServer {
    static Logger logger = Logger.getLogger(SwfNoServer.class);
    /**
     * 流水号的生成
     * @return indicSeq
     */
    public String getIndicSeq() {
        StringBuilder indicSeq = new StringBuilder("10086");
        Random random = new Random();
        SimpleDateFormat simp = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = simp.format(new Date());
        indicSeq.append(format);
        int i=0;
        while (i < 6) {
            int num = random.nextInt(10);
            indicSeq.append(num);
            i ++;
        }
        logger.info("inseq:"+indicSeq.toString());
        return indicSeq.toString();
    }
}
