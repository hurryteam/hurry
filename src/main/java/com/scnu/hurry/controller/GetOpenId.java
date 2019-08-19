package com.scnu.hurry.controller;

import com.alibaba.fastjson.JSONObject;
import com.scnu.hurry.util.HttpRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "用户openid")
public class GetOpenId {

    //appid
    //secret
    //code
    @ApiOperation(value = "返回用户Openid")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "appid", value = "小程序appid", dataType = "string", paramType = "query", required = true),
            @ApiImplicitParam(name = "secret", value = "小程序密钥", dataType = "string", paramType = "query", required = true),
            @ApiImplicitParam(name = "code", value = "登录凭证", dataType = "string", paramType = "query", required = true),
    })
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
