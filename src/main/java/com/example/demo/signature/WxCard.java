package com.example.demo.signature;

import java.util.*;

/**
 * @author Caixiaowei
 * @ClassName WxCard
 * @Description
 * @createTime 2020/12/31 18:13
 */
public class WxCard {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        String str = "12314048966881434008071ojZ8YtyVyr30HheH3CM73y7h4jJEpjZ8Yt1XGILfi-FUsewpnnolGgZk";
        Map<String, String> map = new HashMap<>(16);
        map.put("code", "1434008071");
        map.put("timestamp", "1404896688");
        map.put("card_id", "pjZ8Yt1XGILfi-FUsewpnnolGgZk");
        map.put("api_ticket", "ojZ8YtyVyr30HheH3CM73y7h4jJE");
        map.put("nonce_str", "123");

        for (String key : map.keySet()) {
            list.add(map.get(key));
        }
        Collections.sort(list);

        String result = "";
        for (String s : list) {
            result += s;
        }
        System.out.println(str.equals(result));
    }
}
