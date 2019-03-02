package com.example.zgq.filter.test;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @ Author     ：Zgq
 * @ Date       ：Created in 23:26 2019/3/1
 * @ Description：过滤器
 * @ Modified By：
 * @Version: $
 */

@WebFilter(filterName = "myfilter",urlPatterns = "/abc")
public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.printf("过滤器执行");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.printf("过滤器初始化");
    }

    @Override
    public void destroy() {
        System.out.printf("过滤器销毁");
    }
}
