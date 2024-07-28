package org.lab.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("org.lab")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class AppConfig {

}
