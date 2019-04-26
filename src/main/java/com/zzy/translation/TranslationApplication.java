package com.zzy.translation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class TranslationApplication {

    public static void main(String[] args) {
        SpringApplication.run(TranslationApplication.class, args);
    }

}
