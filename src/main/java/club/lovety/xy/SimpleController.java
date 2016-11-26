package club.lovety.xy;


import club.lovety.xy.bean.OneBean;
import club.lovety.xy.bean.UserInfo;
import club.lovety.xy.config.MainConfiguration;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 念梓  on 2016/10/26.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@RestController
@PropertySource("classpath:config/prop.properties")
@SpringBootApplication()   // @Configuration, @EnableAutoConfiguration and @ComponentScan
public class SimpleController {

    @Resource
    private OneBean oneBean;

    @Resource
    private UserInfo userInfo;

    @Resource
    private MainConfiguration mainConfiguration;

    @Value("${redis.password}")
    private String redis;

    @Value("${http.url}")
    private String url;

    @Resource
    private SqlSessionFactoryBean sqlSessionFactoryBean;


    @RequestMapping("hello")
    public String home(){
        System.out.println("=============");
        return "hello world";
    }

    @RequestMapping("obj")
    public Object obj(){
        System.out.println("redis: "+ redis);
        System.out.println("url: "+ url);
        Map<String,String> map = new HashMap<>();
        map.put("name","年号0=00========");
        oneBean.print();
        System.out.println(mainConfiguration.getUrl());
        return map;
    }

    @RequestMapping("name")
    public Object name(@RequestParam("name") String name){
        System.out.println(userInfo);
        return userInfo.printYourName(name);
    }

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SimpleController.class);
        springApplication.run(args);
    }
}
