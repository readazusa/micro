package club.lovety.xy.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by 念梓  on 2016/11/17.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@Component
@ConfigurationProperties(prefix = "http",locations = "classpath:config/prop.properties")
public class MainConfiguration {

    private String url;

    private String passwd;

    public String getUrl() {

        return url+"              sssaaas";
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPasswd() {
        return passwd+" passwd";
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
