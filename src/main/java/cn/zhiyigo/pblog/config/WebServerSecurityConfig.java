package cn.zhiyigo.pblog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true,jsr250Enabled = true)
public class WebServerSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private jwtAccessDeniedHandler jwtAccessDeniedHandler;

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private UserDetailsService userServiceImpl;

    /**
     * 用户认证配置
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /**
         * 指定用户认证时，默认从哪里获取认证用户信息
         */
        auth.userDetailsService(userServiceImpl);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS,"/api/**")
                .permitAll()
                .antMatchers("/").permitAll()
                //login 不拦截
                .antMatchers("/adminlogin","/webLogin","/register","/login","/getUserNum/*","/api/aricle/*","/api/book/*","/api/user/*"
                        ,"/path","/favicon.ico","/img/*","/vue.js","/element.css","/element.js","/fonts/*","/axios.min.js","/cookies.js","/req/*"
                ,"/httpVueLoader.js","/components/*","/components/*/*","/vue-echarts.min.js").permitAll()
                .anyRequest().authenticated()
                .and().headers().frameOptions().disable()
                //授权
                .and()
                // 禁用session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

            // 使用自己定义的拦截机制，拦截jwt
            http.addFilterBefore(new JwtAuthenticationFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                //授权错误信息处理
                .exceptionHandling()
                //用户访问资源没有携带正确的token
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                //用户访问没有授权资源
                .accessDeniedHandler(jwtAccessDeniedHandler);
    }

}
