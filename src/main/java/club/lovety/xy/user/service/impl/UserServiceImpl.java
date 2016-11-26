package club.lovety.xy.user.service.impl;

import club.lovety.xy.user.dao.IUserDao;
import club.lovety.xy.user.entity.UserInfo;
import club.lovety.xy.user.service.IUserSerice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 念梓  on 2016/11/21.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@Service
public class UserServiceImpl implements IUserSerice {

    @Resource
    private IUserDao userDao;

    @Override
    public List<UserInfo> queryUserInfos() {
        return userDao.queryUserInfos();
    }

//    @Transactional
    @Override
    public int save(UserInfo userInfo) {
        int count = userDao.save(userInfo);
        int a = 1/0;
        return count;
    }
}
