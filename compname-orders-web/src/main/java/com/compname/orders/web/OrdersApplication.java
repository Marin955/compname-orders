package com.compname.orders.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class.
 *
 * @author Marin Bilic
 * @since 1.0
 */
@SpringBootApplication(scanBasePackages = "com.compname.orders")
public class OrdersApplication {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * Entry point of application.
     *
     * @param args  [{@link String[]}] :: args
     */
    public static void main(String[] args) {
        SpringApplication.run(OrdersApplication.class, args);
    }
}