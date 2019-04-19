package com.zzy.translation.api;



public class Main {
    public static void main(String[] args) {
        String query = "hello";
        String from = "auto";
        String to = "zh";


        System.out.println(HttpGet.get(query, from, to));
    }
}
