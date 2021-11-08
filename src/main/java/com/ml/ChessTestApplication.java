package com.ml;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Administrator
 * @date 2021/11/03 16:55
 */
@SpringBootApplication
@MapperScan("com.ml.mapper")
public class ChessTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChessTestApplication.class, args);
    }

}
