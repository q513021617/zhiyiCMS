package cn.zhiyigo.pblog.config;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Error {
    @ExceptionHandler(BadCredentialsException.class)
    public void badCredentialsException(BadCredentialsException e){
        System.out.println(e.getMessage());//用户名或密码错误
    }
}
