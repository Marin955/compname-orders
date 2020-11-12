package com.compname.orders.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Main application class.
 *
 * @author Marin Bilic
 * @since 1.0
 */
@SpringBootApplication(scanBasePackages = "com.compname.orders")
@EntityScan(basePackages = "com.compname.orders")
@EnableJpaRepositories(basePackages = "com.compname.orders")
public class OrdersApplication {
    /**
     * Entry point of application.
     *
     * @param args  [{@link String[]}] :: args
     */
    public static void main(String[] args) { SpringApplication.run(OrdersApplication.class, args); }
}