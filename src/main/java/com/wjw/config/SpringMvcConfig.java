package com.wjw.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.wjw.controller")
@EnableWebMvc
@Import(SpringWebSupport.class)
public class SpringMvcConfig {
}
