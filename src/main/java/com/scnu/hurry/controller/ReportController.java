package com.scnu.hurry.controller;

import com.scnu.hurry.Enum.ResultEnum;
import com.scnu.hurry.Exception.HurryException;
import com.scnu.hurry.entity.Report;
import com.scnu.hurry.service.Impl.ReportServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/report")
@Api(value = "报告")
public class ReportController {

    @Autowired
    ReportServiceImpl reportService;


    @RequestMapping(value = "/day", method = RequestMethod.POST)
    @ApiOperation(value = "返回今天的报告")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "openid", value = "用户的openid", dataType = "String", paramType = "query", required = true),
    })
    public List<Integer> GetReportByDay(@RequestParam("openid") String openid) throws HurryException {
        if (openid.equals("")) {
            throw new HurryException(ResultEnum.USER_ID_ERROR);
        }
        return reportService.findToday(openid);
    }


    @RequestMapping(value = "/week", method = RequestMethod.POST)
    @ApiOperation(value = "返回这周的报告")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "openid", value = "用户的openid", dataType = "String", paramType = "query", required = true)
    })
    public List<Integer> GetReportByWeek(@RequestParam("openid") String openid) {
        if (openid.equals("")) {
            throw new HurryException(ResultEnum.USER_ID_ERROR);
        }
        return reportService.findThisWeek(openid);
    }

    @RequestMapping(value = "/month", method = RequestMethod.POST)
    @ApiOperation(value = "返回这个月的报告")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "openid", value = "用户的openid", dataType = "String", paramType = "query", required = true)
    })
    public List<Integer> GetReportByMonth(@RequestParam("openid") String openid) {
        if (openid.equals("")) {
            throw new HurryException(ResultEnum.USER_ID_ERROR);
        }
        return reportService.findThisMonth(openid);
    }
}
