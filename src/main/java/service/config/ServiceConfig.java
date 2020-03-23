package service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"service.model"})
@Configuration
public class ServiceConfig {
}
