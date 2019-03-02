package com.example.zgq.controller.test;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @RequestMapping("/zgq")
    @ApiOperation(value = "zgq",httpMethod = "GET",response = String.class,notes = "index")
    public String index(){
        return "Hello zgq";
    }


    @RequestMapping("/exception")
    @ApiOperation(value = "zgq",httpMethod = "GET",response = String.class,notes = "index")
    public String Exception(){
        String test=null;
        test.split(",");
        return "Hello test Exception";
    }

}
