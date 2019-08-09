package com.coffee.life.oauth;

import com.coffee.life.oauth.service.UserDetailsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.PrivateKey;

@SpringBootTest
@RunWith(SpringRunner.class)

public class BeanTest {


    @Autowired
    private UserDetailsServiceImpl userDetailsService;


    @Test
    public void testBean(){
    }
}
