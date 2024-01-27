package com.consubanco.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.consubanco.usecase.spend")
public class UseCaseConf {
}
