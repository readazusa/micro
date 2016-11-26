package club.lovety.xy.user.controller;

import club.lovety.xy.user.entity.UserInfo;
import club.lovety.xy.user.service.IUserSerice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * Created by 念梓  on 2016/11/21.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@RestController
@RequestMapping("user")
public class UserController {

    private Logger logger = LogManager.getLogger(UserController.class);

    @Resource
    private IUserSerice userSerice;

    @RequestMapping("add")
    public Object add(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(UUID.randomUUID().toString());
        userInfo.setName("测试springboot");
        userSerice.save(userInfo);
        return "更新成功";
    }

    @RequestMapping("list")
    @ResponseBody
    public Object list(){
        List<UserInfo> userInfoList = userSerice.queryUserInfos();
        logger.debug("查询结果: {}",userInfoList);
        return userInfoList;
    }

    @RequestMapping("view")
    public Object view(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId("sasasd");
        userInfo.setName("阿萨德");
        return  userInfo;
    }

    @RequestMapping("receive")
    public Object receive(@RequestBody UserInfo userInfo){
        logger.debug("=======================");
        return userInfo;
    }

}
