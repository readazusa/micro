package club.lovety.xy.config;

import club.lovety.xy.bean.UserInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 念梓  on 2016/11/17.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@Configuration
public class InitConfig {

    @Bean(value = "user")
    public UserInfo userInfo(){
        return new UserInfo();
    }
}
