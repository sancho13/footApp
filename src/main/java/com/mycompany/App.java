package com.mycompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

/**
 * Created by Marseillais on 30/05/2016.
 */
@EnableAutoConfiguration
@ComponentScan("com.mycompany")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }




    }


