package com.coffee.life.config;

import com.coffee.life.common.constants.PermitAllUrl;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableWebSecurity(debug = true)
@Order(-1)
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/userlogout", "/userjwt", "/auth/userlogin");
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        AuthenticationManager manager = super.authenticationManagerBean();
        return manager;
    }

    //采用bcrypt对密码进行编码
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        //解决不允许显示在iframe的问题
        http.headers().frameOptions().disable().xssProtection().disable();

        http.csrf().disable()
                .httpBasic().and()
                .formLogin()
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .antMatchers(PermitAllUrl.permitAllUrl("oauth/token")).permitAll();

    }
}
