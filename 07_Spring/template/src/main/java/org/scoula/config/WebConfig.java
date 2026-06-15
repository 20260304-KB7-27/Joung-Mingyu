package org.scoula.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    // 어플리케이션 전반적인 설정
    // Service, Repository, Data, 트랜잭션 웹이랑 무관한 설정
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { RootConfig.class };
    }

    // 웹/MVC 관련 설정
    // Controller, ViewResolver 등 웹 관련 설정
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { ServletConfig.class };
    }

    // DispatcherServlet이 처리할 url 패턴
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" }; // 모든 요청에 대해 매핑
    }

    // POST body 문자(한글) 인코딩 필터 설정 - UTF-8 설정
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[] {characterEncodingFilter};
    }
}
