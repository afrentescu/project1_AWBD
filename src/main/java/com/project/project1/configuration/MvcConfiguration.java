package com.project.project1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

@Configuration
public class MvcConfiguration {

    @Bean(name="simpleMappingExceptionResolver")
    public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver r = new SimpleMappingExceptionResolver();
        r.setDefaultErrorView("errorpage");
        r.setExceptionAttribute("ex");
        return r;
    }//default "exception"return r;}
}
