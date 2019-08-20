package com.scnu.hurry.controller;

import com.scnu.hurry.Enum.ResultEnum;
import com.scnu.hurry.Exception.HurryException;
import com.scnu.hurry.service.Impl.ReportServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
            @ApiImplicitParam(name = "body", value = "必须包含用户openid: openid", dataType = "json", paramType = "body", required = true)
    })
    public List<Integer> GetReportByDay(@RequestBody Map<String, String> body) throws HurryException {
        String openid = body.get("openid");
        if (openid.equals("")) {
            throw new HurryException(ResultEnum.USER_ID_ERROR);
        }
        return reportService.findToday(openid);
    }


    @RequestMapping(value = "/week", method = RequestMethod.POST)
    @ApiOperation(value = "返回这个周的报告")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "body", value = "必须包含用户openid: openid", dataType = "json", paramType = "body", required = true)
    })
    public List<Integer> GetReportByWeek(@RequestBody Map<String, String> body) {
        String openid = body.get("openid");
        if (openid.equals("")) {
            throw new HurryException(ResultEnum.USER_ID_ERROR);
        }
        return reportService.findThisWeek(openid);
    }

    @RequestMapping(value = "/month", method = RequestMethod.POST)
    @ApiOperation(value = "返回这个月的报告")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "body", value = "必须包含用户openid: openid", dataType = "json", paramType = "body", required = true)
    })
    public List<Integer> GetReportByMonth(@RequestBody Map<String, String> body) {
        String openid = body.get("openid");
        if (openid.equals("")) {
            throw new HurryException(ResultEnum.USER_ID_ERROR);
        }
        return reportService.findThisMonth(openid);
    }

    @RequestMapping(value = "/addone", method = RequestMethod.POST)
    @ApiOperation(value = "上传一个报告")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "body", value = "必须包含用户openid: openid, 日期: date(格式为yyyy-mm-dd-hh)", dataType = "json", paramType = "body", required = true)
    })
    public String addReport(@RequestBody Map<String, String> body) throws HurryException {
        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd-HH" );
        System.out.println(body);
        try {
            Date date = sdf.parse(body.get("date"));
            String openid = body.get("openid");
            System.out.println(openid);
            System.out.println(date);
            if (openid.equals("")) {
                throw new HurryException(ResultEnum.USER_ID_ERROR);
            }
            reportService.addReport(openid, date);
        } catch (ParseException p) {
            throw new HurryException(ResultEnum.DATE_PARSE_ERROR);
        }
        return "success";
    }

    @RequestMapping(value = "/addreports", method = RequestMethod.POST)
    @ApiOperation(value = "上传多个报告")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "body", value = "必须包含用户openid, 日期数组: dates(格式都为yyyy-mm-dd-HH)", dataType = "json", paramType = "body", required = true)
    })
    public String addReports(@RequestBody Map<String, Object> body) throws HurryException{
        try {
            String openid = (String)body.get("openid");
            String[] datesStr = (String[]) body.get("dates");
            SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd-HH" );
            List<Date> dates = new ArrayList<>();
            for (String d : datesStr)
                dates.add(sdf.parse(d));
            if (openid.equals("")) {
                throw new HurryException(ResultEnum.USER_ID_ERROR);
            }
            reportService.addReport(openid, dates);
        } catch(ParseException pe) {
            throw new HurryException(ResultEnum.DATE_PARSE_ERROR);
        }
        return "success";
    }
}
