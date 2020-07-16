package com.bit.mysite.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.bit.mysite.service", 
				"com.bit.mysite.repository",
				"com.bit.mysite.aspect", 
				"com.bit.mysite.exception"})
public class AppConfig {

}
