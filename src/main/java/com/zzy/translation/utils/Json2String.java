package com.zzy.translation.utils;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONString;

public class Json2String {
    private JSONObject jsonObject;
    private String str;

    public Json2String(JSONObject jsonObject, String str){
        this.jsonObject = jsonObject;
        this.str = str;
    }

    public static String jsonString2String(String str){
        if (str == null){
            return null;
        }
        if (str.indexOf("trans_result") == -1){
            return null;
        }
        JSONObject jsonObject = JSONObject.fromObject(str);
        String transResult = jsonObject.getString("trans_result");
        JSONArray jsonArray = JSONArray.fromObject(transResult);
        JSONObject jsonObject1 = JSONObject.fromObject(jsonArray.getString(0));
        String dst = jsonObject1.getString("dst");
        return dst;
    }

    public static JSONObject string2Json(String str){

        return null;
    }

}
