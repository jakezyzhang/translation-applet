package com.zzy.translation.service.impl;

import com.zzy.translation.entity.WxInfo;
import com.zzy.translation.service.WxInfoService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
@Service
public class WxInfoServiceImpl implements WxInfoService {
    private static final String APPID = "wx11b17040118611a9";
    private static final String SECRET = "26a9537756d7f125244e021b312afb19";
    @Override
    public String getOpenIdByWxInfo(WxInfo wxInfo) {
        InputStream is = null;
        BufferedReader bf = null;
        try {
            URL url = new URL("https://api.weixin.qq.com/sns/jscode2session?appid=" + APPID + "&secret=" + SECRET + "&js_code=" + wxInfo.getCode() + "&grant_type=authorization_code");
            is = url.openStream();
            bf = new BufferedReader(new InputStreamReader(is));
            String info = null;
            StringBuilder sb = new StringBuilder();
            while ((info = bf.readLine()) != null) {
                sb.append(info);
            }
            JSONObject jsonObject = JSONObject.fromObject(sb.toString());
            String openId = jsonObject.getString("openid");
            return openId;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (is != null){
                    is.close();
                }
                if (bf != null){
                    bf.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        return null;
    }
}
