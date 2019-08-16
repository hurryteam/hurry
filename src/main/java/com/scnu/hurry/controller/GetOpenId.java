package com.scnu.hurry.controller;

import com.alibaba.fastjson.JSONObject;
import com.scnu.hurry.util.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetOpenId {

    //appid
    //secret
    //code
    @GetMapping("getOpenid")
    public String getOpenid(@RequestParam("appid") String appid,
                         @RequestParam("secret") String secret,
                         @RequestParam("code") String code){
        String grantType = "authorization_code";
        // using login code to get sessionId and openId
        String params = "appid=" + appid + "&secret=" + secret + "&js_code=" + code + "&grant_type=" + grantType;

        // sending request
        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);

        // analysis request content
        JSONObject json = JSONObject.parseObject(sr);

        System.out.println(json.toJSONString());
        return json.toJSONString();
    }
}
