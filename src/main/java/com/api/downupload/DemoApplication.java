package com.api.downupload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import com.api.downupload.properties.FileUploadProperties;

@SpringBootApplication
        @EnableConfigurationProperties({
            FileUploadProperties.class
        })
        public class DemoApplication {
            public static void main(String[] args) {
                SpringApplication.run(DemoApplication.class, args);
            }
        }
    