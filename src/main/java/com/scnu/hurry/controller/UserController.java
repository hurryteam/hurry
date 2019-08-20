package com.scnu.hurry.controller;

import java.util.Map;
import com.scnu.hurry.Enum.ResultEnum;
import com.scnu.hurry.Exception.HurryException;
import com.scnu.hurry.service.Impl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
@Api(value = "用户")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/exist", method = RequestMethod.GET)
    @ApiOperation(value = "检查用户是否已经注册")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "openid", value = "用户的openid", dataType = "String", paramType = "query", required = true),
    })
    public boolean checkUser(@RequestParam("openid") String openid) {
        return userService.findUser(openid);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加用户")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "body", value = "必须包含用户openid: openid, 用户图像路径: url", dataType = "json", paramType = "body", required = true)
    })
    public String addUser(@RequestBody Map<String, String> body) throws HurryException {
        if (body.get("openid").equals("")) {
            throw new HurryException(ResultEnum.USER_ID_ERROR);
        }
        try {
            userService.addUser(body.get("openid"), body.get("url"));
        } catch (HurryException e) {
            throw e;
        }
        return "success";
    }

    @RequestMapping(value = "/avatar", method = RequestMethod.GET)
    @ApiOperation(value = "通过userid用户头像url")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "userid", value = "用户的userid", dataType = "int", paramType = "query", required = true),
    })
    public String getAvatarByOpenid(@RequestParam("openid") Integer userid) throws HurryException {
        if (userid < 0) {
            throw new HurryException(ResultEnum.USER_ID_ERROR);
        }
        return userService.findUserPictureByUserid(userid);
    }
}
