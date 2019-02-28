package com.example.zgq.swagger.test;

/**
 * @ Author     ：Zgq
 * @ Date       ：Created in 18:47 2019/2/28
 * @ Description：swagger配置类
 * @ Modified By：
 * @Version: $
 */

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
@Profile({ "dev", "test" })
public class SwaggerConfig extends WebMvcConfigurerAdapter {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xuanyuan"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     19      * 发现如果继承了WebMvcConfigurationSupport，则在yml中配置的相关内容会失效。
     20      * 需要重新指定静态资源
     21      * @param registry
     22      */
     @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
                registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
                registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
                super.addResourceHandlers(registry);
             }

    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("更多Spring Boot相关文章请关注：http://blog.didispace.com/")
                .termsOfServiceUrl("http://blog.didispace.com/")
                .contact("程序猿DD")
                .version("1.0")
                .build();
    }
}
