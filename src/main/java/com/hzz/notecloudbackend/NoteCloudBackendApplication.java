package com.hzz.notecloudbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com/hzz/notecloudbackend/mapper")
public class NoteCloudBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoteCloudBackendApplication.class, args);
    }

}
