package com.example.demo.faker;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author Caixiaowei
 * @ClassName JavaFaker
 * @Description 使用 javaFaker 造数据
 * @createTime 2020/12/29 10:50
 */
public class JavaFaker {

    public static void main(String[] args) {
        Faker faker = new Faker(Locale.CHINA);

        List<UserInfo> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setName(faker.name().name());
            userInfo.setAddress(faker.address().streetAddress());
            userInfo.setPhone(faker.phoneNumber().cellPhone());
            userInfo.setNickname(faker.funnyName().name());

            list.add(userInfo);
        }
        System.out.println(list);
    }
}
