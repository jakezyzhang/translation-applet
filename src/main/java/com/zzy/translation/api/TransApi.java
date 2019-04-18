package com.zzy.translation.api;

import java.util.LinkedHashMap;
import java.util.Map;

public class TransApi {
    private static final String APPID = "20180806000191922";
    private static final String SECURITYKEY = "bzyGDCsiHqEtkvoxKRaG";
    // 随机数
    private static String salt = String.valueOf(System.currentTimeMillis());
    public TransApi() {}

    private static String getSign(String query){
        String sign = null;
        StringBuilder sb = new StringBuilder();
        sb.append(APPID);
        sb.append(query);

        sb.append(salt);
        sb.append(SECURITYKEY);
        sign = MD5.stringMD5(sb.toString());
        return sign;
    }

    public static Map<String, String> buildParams(String query, String from, String to){
        Map<String, String> params = new LinkedHashMap<>();
        params.put("q", query);
        params.put("from", from);
        params.put("to", to);
        params.put("appid", APPID);
        params.put("salt", salt);

        params.put("sign", getSign(query));
        return params;
    }
    public static String getTransResult(String query, String from, String to){
        Map<String, String> params = buildParams(query, from, to);
        return GetURL.buildURL(params);
    }
}
