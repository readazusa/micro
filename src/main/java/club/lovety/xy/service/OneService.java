package club.lovety.xy.service;

import org.springframework.stereotype.Service;

/**
 * Created by 念梓  on 2016/10/30.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@Service
public class OneService {

    private String url;

    public void print(){

        System.out.println("service优质:  "+ url);
    }
}
