package com.zzy.translation.api;



public class Main {
    public static void main(String[] args) {
        String query = "你好";
        String from = "auto";
        String to = "en";


        System.out.println(HttpGet.get(query, from, to));
    }
}
