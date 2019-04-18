package com.zzy.translation.api;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public class GetURL {
    private static final String TRANS_API_HOST = "http://api.fanyi.baidu.com/api/trans/vip/translate";

    public static String buildURL(Map<String, String>params){
        if(params == null){
            return null;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(TRANS_API_HOST);
        if(TRANS_API_HOST.contains("?")){
            sb.append("&");
        }else{
            sb.append("?");
        }
        int i = 0;
        for (Map.Entry<String, String> entry : params.entrySet()){
            if (entry.getValue() == null){
                continue;
            }
            if (0 != i){
                sb.append("&");
            }
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(encode(entry.getValue()));
            i ++;

        }
        String URL = sb.toString();
        return URL;
    }

    /**
     * 对输入的字符串进行URL编码, 即转换为%20这种形式
     *
     * @param input 原文
     * @return URL编码. 如果编码失败, 则返回原文
     */
    public static String encode(String input) {
        if (input == null) {
            return "";
        }

        try {
            return URLEncoder.encode(input, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return input;
    }
}
