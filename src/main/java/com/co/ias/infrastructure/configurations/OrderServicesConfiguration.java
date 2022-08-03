package com.co.ias.infrastructure.configurations;

import com.co.ias.infrastructure.adapters.output.JPARepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OrderServicesConfiguration {
   private  final JPAOrderService jpaOrderService;

    public OrderServicesConfiguration(JPAOrderService jpaOrderService) {
        this.jpaOrderService = jpaOrderService;
    }

    @Bean
    public JPARepository jpaRepository(){
        return new JPARepository(jpaOrderService);
    }
}
