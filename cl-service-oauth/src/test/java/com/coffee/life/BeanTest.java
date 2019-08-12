package com.coffee.life;

import com.coffee.life.service.UserDetailsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)

public class BeanTest {


    @Autowired
    private UserDetailsServiceImpl userDetailsService;


    @Test
    public void testBean(){
    }
}
