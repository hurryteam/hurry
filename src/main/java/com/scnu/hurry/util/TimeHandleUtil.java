package com.scnu.hurry.util;

import com.scnu.hurry.entity.Report;
import io.swagger.models.auth.In;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 时间处理类
 */
public class TimeHandleUtil {

    //得到每一个小时的吸烟数
    public static List<Integer> splitDayTo24Hours(List<Report> reports){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH");
        //存储24小时的吸烟数
        int[] hours = new int[24];
        for(Report report : reports){
            Date date = report.getTime();
            Integer hour = Integer.parseInt(simpleDateFormat.format(date));
            hours[hour]++;
        }

        ArrayList<Integer> res =  new ArrayList<>(24);
        for (int i = 0; i < hours.length; i++) {
            res.add(hours[i]);
        }
        return res;
    }

    //一周每一天
    public static List<Integer> splitWeekToDay(List<Report> reports){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E");
        int[] days = new int[7];
        String[] daysString = {"周一", "周二" , "周三", "周四", "周五", "周六", "周日"};
        for (Report report : reports){
            Date date = report.getTime();
            String day = simpleDateFormat.format(date);
            for (int i = 0; i < daysString.length; i++){
                if (day.equals(daysString[i]))
                    days[i]++;
            }
        }
        ArrayList<Integer> res =  new ArrayList<>(24);
        for (int i = 0; i < days.length; i++) {
            res.add(days[i]);
        }
        return res;
    }

    //一个月每一周的吸烟数
    public static List<Integer> splitMonthTo4Week(List<Report> reports) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("WW");
        //一个月中的每一周
        int[] weeks = new int[4];
        for (Report report : reports) {
            Date date = report.getTime();
            Integer week = Integer.parseInt(simpleDateFormat.format(date));
            if (week >= 5)
                weeks[3]++;
            else
                weeks[week-1]++;
        }
        ArrayList<Integer> res =  new ArrayList<>(24);
        for (int i = 0; i < weeks.length; i++) {
            res.add(weeks[i]);
        }
        return res;
    }



}
