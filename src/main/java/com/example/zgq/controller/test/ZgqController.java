package com.example.zgq.controller.test;

import com.example.zgq.model.test.User;
import com.example.zgq.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ Author     ：Zgq
 * @ Date       ：Created in 17:11 2019/2/27
 * @ Description：尝试写controller类
 * @ Modified By：
 * @Version: $
 */


@RestController
@RequestMapping("/hello")
public class ZgqController {

    @Resource
    private UserService userService;

    @RequestMapping("/zgq")
    @ApiOperation(value = "zgq",httpMethod = "GET",response = String.class,notes = "index")
    public String index(){

        String a=null;
        a.split("1");
        return "Hello zgq";
    }


    @RequestMapping("/exception")
    @ApiOperation(value = "zgq",httpMethod = "GET",response = String.class,notes = "index")
    public String Exception(){
        String test=null;
        test.split(",");
        return "Hello test Exception";
    }

    @RequestMapping("/jump")
    public ModelAndView jump(Model model){
        //查询所有用户
       List<User> list= userService.findAll();
       model.addAttribute("users",list);
        ModelAndView mav=new ModelAndView("user");
       return mav;
    }

}
