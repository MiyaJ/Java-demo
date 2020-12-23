package com.example.demo.iplat;

import com.baosight.common.utils.IplatGUID;

/**
 * @author Caixiaowei
 * @ClassName IplatTest
 * @Description
 * @createTime 2020/12/23 14:08
 */
public class IplatTest {

    public static void main(String[] args) {
        IplatGUID iplatGUID = new IplatGUID();
        String guid = iplatGUID.newGuid();
        System.out.println("guid: " + guid);
    }
}
