package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
//@EnableWebMvc
//public class WebMvcConfig implements WebMvcConfigurer {
public class WebMvcConfig {

//  @Bean
//  public ViewResolver templateResolver() {
//    ServletContextTemplateResolver bean = new ServletContextTemplateResolver();
//    bean.setPrefix("/WEB-INF/views/");
//    bean.setSuffix(".html");
//    bean.setViewNames("thymeleaf/*");
//    return bean;
//  }

  @Bean
  public ViewResolver jspViewResolver() {
    InternalResourceViewResolver bean = new InternalResourceViewResolver();
    bean.setViewClass(JstlView.class);
    bean.setPrefix("/WEB-INF/views/");
    bean.setSuffix(".jsp");
    bean.setViewNames("jsp/*");
    return bean;
  }
//  @Bean
//  public ViewResolver viewResolver() {
//    final InternalResourceViewResolver bean = new InternalResourceViewResolver();
//    bean.setViewClass(JstlView.class);
//    bean.setPrefix("/WEB-INF/jsp/");
//    bean.setSuffix(".jsp");
//    return bean;
//  }
//
//  @Override
//  public void configureViewResolvers(ViewResolverRegistry registry) {
//    registry.viewResolver(viewResolver());
//  }
}
