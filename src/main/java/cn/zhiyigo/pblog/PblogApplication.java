package cn.zhiyigo.pblog;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;


import java.io.File;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@SpringBootApplication
public class PblogApplication {

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public PblogApplication(AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    public static void main(String[] args) {

        SpringApplication.run(PblogApplication.class, args);
    }


}
