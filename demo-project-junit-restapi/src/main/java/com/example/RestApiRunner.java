package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class RestApiRunner
{
    public static void main( String[] args )
    {
        SpringApplication.run(RestApiRunner.class,args);
        System.out.println( "Hello World!" );
    }
}
