package com.coffee.life;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = "com.coffee.life")
public class UcenterAuthApplication  extends SpringBootServletInitializer implements CommandLineRunner {
    @Autowired
    private ApplicationContext appContext;


    public static void main(String[] args) {
        SpringApplication.run(UcenterAuthApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }


    @Override
    public void run(String... args) throws Exception
    {
        String[] beans = appContext.getBeanDefinitionNames();
        Arrays.sort(beans);
        for (String bean : beans)
        {
            System.out.println(bean + " of Type :: " + appContext.getBean(bean).getClass());
        }
    }

}
