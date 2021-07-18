package com.example.cartype;

import com.example.cartype.entity.User;
import com.example.cartype.util.TokenUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CartypeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CartypeApplication.class, args);
//        String token=TokenUtil.sign(new User(20181809));
//        TokenUtil.verify(token);
    }

}
