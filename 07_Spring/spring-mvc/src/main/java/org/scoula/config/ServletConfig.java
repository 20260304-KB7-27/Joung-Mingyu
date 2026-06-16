package org.scoula.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
// Spring MVC 기능 활성화 -> 모든 요청이 Dispatcher Servlet을 거치게 됨
// @Controller 인식 / @RequestMapping, @GetMapping
// ViewResolver 설정
@ComponentScan(basePackages = {
        "org.scoula.controller",
        "org.scoula.exception"})
@Configuration
public class ServletConfig implements WebMvcConfigurer {
    // 정적 리소스(이미지, css, js 등)는 컨트롤러에서 처리하지 않기 위함
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }

    // JSP 쓰기 위한 view Resolver 설정
    // -> 컨트롤러가 return한 view 이름을 실제 JSP 파일 경로로 변환해주는 역할
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");
        registry.viewResolver(bean);
    }

    // MultipartResolver -> 이미지, 영상 multipart/form-data 오는 데이터를 처리하는 resolver
    // 빈으로 등록하기
    @Bean
    public MultipartResolver multipartResolver() {
        StandardServletMultipartResolver resolver = new StandardServletMultipartResolver();

        return resolver;
    }
}
