package com.ray.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.ray.dao","com.ray.service",  "com.ray.aspect", "com.ray.Entity"})
public class AOPConfig {


}
