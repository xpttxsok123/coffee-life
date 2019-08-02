package com.coffee.life.auth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

//@SpringBootTest
//@RunWith(SpringRunner.class)
public class PasswordTest {


    @Test
    public void testPassword() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode("super");
        // $2a$10$rOnWDKMr5HRRGvzb2AoeNemu1/oidZXkISnxlb8i2Afv.43j9q0OS
        // $2a$10$Yvx6lSSkYtcWF4eGrHawcuLNKYkf6FO.Y97dpmES3EZe9YdMxxIOq
        // $2a$10$3OhU1M0RPNrk8.jV0wW1eeX2NIQdoVYubh6rbetmUpzR10Kkidivq
        System.out.println(password);

    }


}
