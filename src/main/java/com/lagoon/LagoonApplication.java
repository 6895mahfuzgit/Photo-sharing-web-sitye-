package com.lagoon;

import com.lagoon.backend.config.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;

@SpringBootApplication
public class LagoonApplication {

    @Bean
    public FilterRegistrationBean jawtFilter() {

        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        registrationBean.setFilter( new JwtFilter());
        registrationBean.addUrlPatterns("/rest/**");

        return registrationBean;
    }


    public static void main(String[] args) {
        SpringApplication.run(LagoonApplication.class, args);
    }
}
