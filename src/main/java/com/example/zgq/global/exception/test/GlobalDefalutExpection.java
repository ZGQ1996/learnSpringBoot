package com.example.zgq.global.exception.test;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ Author     ：Zgq
 * @ Date       ：Created in 17:38 2019/3/2
 * @ Description：全局异常的检测类
 * @ Modified By：
 * @Version: $
 */

//如果返回的数据格式是json，就需要添加这个注解
//@ResponseBody
@ControllerAdvice/*(basePackages = {"com.example.zgq.controller.test"})*/
public class GlobalDefalutExpection {


    public static final String DEFAULT_ERROR_VIEW="error";


    @ExceptionHandler({NullPointerException.class,NumberFormatException.class})
    public ModelAndView NullException()throws Exception{

        //这里是异常捕获到需要处理的异常
        System.out.printf("catcah the Exception");
        System.out.printf(DEFAULT_ERROR_VIEW);

        ModelAndView mav=new ModelAndView("404");
        return mav;
    }

}
