/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.blazartech.springdatarestdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author scott
 */
@SpringBootApplication
@ComponentScan("com.blazartech")
public class SpringDataRestDemo {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataRestDemo.class, args);
    }
}
