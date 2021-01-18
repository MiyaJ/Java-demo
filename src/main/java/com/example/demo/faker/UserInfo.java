package com.example.demo.faker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Caixiaowei
 * @ClassName UserInfo
 * @Description
 * @createTime 2020/12/29 10:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 电话
     */
    private String phone;

    /**
     * 住址
     */
    private String address;

    public UserInfo(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
