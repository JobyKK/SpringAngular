package demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import demo.config.WebConfig;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("demo/")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
