package com.example.isgpspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @ClassName: swagger2配置
 * @Description: TODO
 * @author Pengjun
 * @date 2021年3月4日
 */

@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        // 构造函数传入初始化规范，这是swagger2规范
        return new Docket(DocumentationType.SWAGGER_2)
                //apiInfo： 添加api详情信息，参数为ApiInfo类型的参数，这个参数包含了第二部分的所有信息比如标题、描述、版本之类的，开发中一般都会自定义这些信息
                .apiInfo(apiInfo("信息系统通用平台  APIs","说明RESTful APIs","0.1.1"))
                .groupName("个人组织")
                //配置是否启用Swagger，如果是false，在浏览器将无法访问，默认是true
                .enable(true)
                .select()
                //apis： 添加过滤条件,
                .apis(RequestHandlerSelectors.basePackage("com.example.isgpspring.controller"))
                //paths： 这里是控制哪些路径的api会被显示出来，这里是所有
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(String name,String description,String version) {
        Contact contact = new Contact("名字：PengJun", "个人链接：https://github.com/pengjun2191/ISGP", "邮箱：pengjun358057437@163.com");
        return new ApiInfoBuilder()
                .title(name)
                .description(description)
                .termsOfServiceUrl("https://github.com/pengjun2191/ISGP")
                .version(version)
                .contact(contact)
                .license("***")
                .licenseUrl("***")
                .extensions(new ArrayList<>())
                .build();
    }
}
