package club.lovety.xy.controller;

import club.lovety.xy.bean.UserInfo;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 念梓  on 2016/10/25.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@RequestMapping("one")
@RestController
public class OneController {

    private static final org.apache.logging.log4j.Logger log= LogManager.getLogger(OneController.class);


    @Resource
    private Environment environment;

    @Resource(name = "user")
    private UserInfo userInfo;

    @Value("${redis.password}")
    private String redis;

//    @Value("${userinfo.name}")
//    private String newName;

    @RequestMapping("index")
    public  Object index(){
        ApplicationContext applicationContext = null;
        log.debug("=======================");
        Map<String,String> map = new HashMap<>();
        map.put("redis",redis);
        map.put("oneIndex","你好啊啊啊啊啊啊啊啊啊啊啊啊zcasdas啊啊啊 ");
        return map;
    }

    @RequestMapping("name")
    public Object name(@RequestParam("name") String name){
        log.error("asdasd: {}","log4j_2222222222");
        System.out.println("你输出的名称: "+ name);
        String passwd = environment.getProperty("redis.password");
        System.out.println("password: "+ passwd);
//        System.out.println("newName:  "+ newName);
        System.out.println(userInfo);
        return userInfo.printYourName(name);
    }

    @RequestMapping("redirect")
    public void redirectUrl(HttpServletResponse response){
        try {
            response.sendRedirect("http://crj.gafw.jl.gov.cn/jit_crj_wx/jsp/proscenium/wxlv/html/kind_business.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        return  "redirect: http://crj.gafw.jl.gov.cn/jit_crj_wx/jsp/proscenium/wxlv/html/kind_business.jsp";
    }

    @RequestMapping("receive")
    public Object receive(@RequestBody  UserInfo userInfo){
            return userInfo;
    }

}
