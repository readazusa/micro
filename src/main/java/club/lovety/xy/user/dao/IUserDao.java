package club.lovety.xy.user.dao;


import club.lovety.xy.user.entity.UserInfo;

import java.util.List;

/**
 * Created by 念梓  on 2016/11/21.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public interface IUserDao {

    public List<UserInfo>  queryUserInfos();

    public int save(UserInfo userInfo);
}
