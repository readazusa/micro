package net.smc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.Date;

/**
 * Created by 念梓  on 2016/11/23.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public class TestLog {

    private static final Logger log = LogManager.getLogger(TestLog.class);

    public static void main(String[] args) {
        log.info("你好啊========sasdasdsad======main");
        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                log.info("你好啊,压缩到日志");
                if (i % 5000 == 0) {
                    log.info("执行5000条时间: {}", new Date());
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                log.info("你好啊,压缩到日志");
                if (i % 5000 == 0) {
                    log.info("执行5000条时间: {}", new Date());
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                log.info("你好啊,压缩到日志");
                if (i % 5000 == 0) {
                    log.info("执行5000条时间: {}", new Date());
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                log.info("你好啊,压缩到日志");
                if (i % 5000 == 0) {
                    log.info("执行5000条时间: {}", new Date());
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                log.info("你好啊,压缩到日志");
                if (i % 5000 == 0) {
                    log.info("执行5000条时间: {}", new Date());
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                log.info("你好啊,压缩到日志");
                if (i % 5000 == 0) {
                    log.info("执行5000条时间: {}", new Date());
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                log.info("你好啊,压缩到日志");
                if (i % 5000 == 0) {
                    log.info("执行5000条时间: {}", new Date());
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                log.info("你好啊,压缩到日志");
                if (i % 5000 == 0) {
                    log.info("执行5000条时间: {}", new Date());
                }
            }
        }).start();


    }

    @Test
    public void testOne() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            log.info("你好啊,压缩到日志");
            if (i % 5000 == 0) {
                log.info("执行5000条时间: {}", new Date());
            }
        }


        long end = System.currentTimeMillis();
        System.out.println((end - start) + "  :毫秒");
    }


}
