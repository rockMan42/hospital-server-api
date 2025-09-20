package com.hospital.hospitalserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hospital.hospitalserver.mapper")
public class HospitalServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalServerApplication.class, args);
    }

}
