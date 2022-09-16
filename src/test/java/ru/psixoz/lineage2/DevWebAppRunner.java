package ru.psixoz.lineage2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import static ru.psixoz.lineage2.Profiles.LOCAL;


public class DevWebAppRunner {

    public static void main(String[] args) {
        new SpringApplicationBuilder(CollectCalculatorApp.class)
                .profiles(LOCAL)
                .run(args);
    }

}
