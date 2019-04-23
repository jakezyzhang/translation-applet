package com.zzy.translation.api;

import com.zzy.translation.utils.Json2String;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        String query = "hello";
        String from = "auto";
        String to = "zh";


        System.out.println(HttpGet.get(query, from, to));
        System.out.println(Json2String.jsonString2String(HttpGet.get(query, from, to)));
    }
}
