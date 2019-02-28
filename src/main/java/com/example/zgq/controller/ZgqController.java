package com.example.zgq.controller;

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
    public String index(){
        return "Hello zgq";
    }

}
