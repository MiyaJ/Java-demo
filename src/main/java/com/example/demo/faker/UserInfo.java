package com.example.demo.faker;

import lombok.Data;

/**
 * @author Caixiaowei
 * @ClassName UserInfo
 * @Description
 * @createTime 2020/12/29 10:50
 */
@Data
public class UserInfo {

    /**
     * 姓名
     */
    private String name;

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

}
