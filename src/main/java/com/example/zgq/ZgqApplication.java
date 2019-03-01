package com.example.zgq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ImportResource(locations = {"classpath:spring-mvc.xml"})
//加上这个注解，swagger在浏览器就可以访问了，不然就404
@EnableSwagger2
//加上这个注解，为了filter过滤器
@ServletComponentScan
public class ZgqApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZgqApplication.class, args);
	}

}
