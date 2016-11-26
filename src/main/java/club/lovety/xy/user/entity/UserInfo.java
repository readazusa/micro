package club.lovety.xy.user.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by 念梓  on 2016/11/19.
 * Email:sunmch@163.com
 * author: 念梓
 */
@XmlRootElement
public class UserInfo {

    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

