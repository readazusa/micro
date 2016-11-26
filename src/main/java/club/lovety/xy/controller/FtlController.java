package club.lovety.xy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 念梓  on 2016/11/21.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@Controller
@RequestMapping("ftl")
public class FtlController{

    @RequestMapping("index")
    public String index(){
        return "index";
    }
}
