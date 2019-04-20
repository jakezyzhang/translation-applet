package com.zzy.translation.api;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        String query = "hello";
        String from = "auto";
        String to = "zh";


        System.out.println(HttpGet.get(query, from, to));
        JSONObject json = JSONObject.fromObject(HttpGet.get(query, from, to));
        System.out.println(json);
        String id = json.getString("trans_result");
        JSONArray jsonArray = JSONArray.fromObject(id);
        System.out.println();
    }
}
