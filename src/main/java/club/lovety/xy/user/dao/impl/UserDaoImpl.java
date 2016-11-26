package club.lovety.xy.user.dao.impl;

import club.lovety.xy.user.dao.IUserDao;
import club.lovety.xy.user.entity.UserInfo;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 念梓  on 2016/11/21.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@Repository
public class UserDaoImpl extends SqlSessionDaoSupport implements IUserDao {

    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public List<UserInfo> queryUserInfos() {
        return this.getSqlSession().selectList("UserInfo.queryUserInfos");
    }

    @Override
    public int save(UserInfo userInfo) {
        return this.getSqlSession().insert("UserInfo.save",userInfo);
    }
}
