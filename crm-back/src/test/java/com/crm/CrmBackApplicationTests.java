package com.crm;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ObjectUtils;

import java.util.Date;

@SpringBootTest
class CrmBackApplicationTests {

    @Test
    void contextLoads() {
        Date date = new Date();
        date=null;
        if(date==null){
            System.out.println("为空");
        }else{
            System.out.println("不为空");
        }
    }
}
