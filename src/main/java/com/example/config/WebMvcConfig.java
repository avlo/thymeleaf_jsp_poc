package com.example.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.thymeleaf.spring6.ISpringTemplateEngine;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

  @Bean
  public ViewResolver htmlViewResolver(ApplicationContext applicationContext) {
    ThymeleafViewResolver resolver = new ThymeleafViewResolver();
    resolver.setTemplateEngine(templateEngine(htmlTemplateResolver(applicationContext)));
    resolver.setContentType("text/html");
    resolver.setCharacterEncoding("UTF-8");
    resolver.setViewNames(new String[] {"*.html"});
    return resolver;
  }

  private ISpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
    SpringTemplateEngine engine = new SpringTemplateEngine();
    engine.setTemplateResolver(templateResolver);
    return engine;
  }

  private ITemplateResolver htmlTemplateResolver(ApplicationContext applicationContext) {
    SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
    resolver.setApplicationContext(applicationContext);
    resolver.setPrefix("/WEB-INF/views/thymeleaf/");
    resolver.setSuffix(".html");
    resolver.setCacheable(false);
    resolver.setTemplateMode(TemplateMode.HTML);
    resolver.setOrder(0);
    return resolver;
  }

  @Bean
  public ViewResolver jspViewResolver() {
    InternalResourceViewResolver jspResolver = new InternalResourceViewResolver();
    jspResolver.setViewClass(JstlView.class);
    jspResolver.setPrefix("/WEB-INF/views/");
    jspResolver.setSuffix(".jsp");
    jspResolver.setViewNames("jsp/*");
    jspResolver.setOrder(99);
    return jspResolver;
  }
}
