package com.example.cartype;

import com.example.cartype.util.ChineseCharacterUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CartypeApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("宝马:"+ChineseCharacterUtil.getFirstCharPinyinUpCase("宝马"));
        System.out.println("奔驰:"+ChineseCharacterUtil.getFirstCharPinyinUpCase("奔驰"));
        System.out.println("BAC:"+ChineseCharacterUtil.getFirstCharPinyinUpCase("BAC"));
    }

}
