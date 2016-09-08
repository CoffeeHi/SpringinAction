package com.five;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 陈祥 on 2016/8/23.
 */
@Controller //声明为一个控制器
@RequestMapping({"/"})
public class HomeController {

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET) //处理对"/"的GET请求
    public String home(){
        return "home"; //视图名为home
    }
}
