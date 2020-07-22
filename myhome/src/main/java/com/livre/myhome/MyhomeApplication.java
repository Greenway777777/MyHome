package com.livre.myhome;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyhomeApplication {

    public static void main(String[] args) {
        //SpringApplication.run(MyhomeApplication.class, args);
        SpringApplication springApplication = new SpringApplication(MyhomeApplication.class);
        //Banner.Mode.OFF 关闭
        //springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }

}
