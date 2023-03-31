package com.example.hello.hello.hellospring.service;
import com.example.hello.hello.hellospring.repository.*;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@org.springframework.context.annotation.Configuration
public class SpringConfig {
    private final DataSource dataSource;
    private final javax.persistence.EntityManager em;

    public SpringConfig(javax.sql.DataSource dataSource, javax.persistence.EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }

//    @org.springframework.context.annotation.Bean
//    public com.example.hello.hello.hellospring.aop.TimeTraceAop timeTraceAop() {
//        return new com.example.hello.hello.hellospring.aop.TimeTraceAop();
//    }
    @Bean
    public MemberRepository memberRepository(){
        return new JpaMemberRepository(em);
    }
}
