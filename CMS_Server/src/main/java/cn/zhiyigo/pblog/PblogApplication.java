package cn.zhiyigo.pblog;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;


import java.io.File;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(PblogApplication.class, args);
    }


}
