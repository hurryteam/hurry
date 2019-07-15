package com.scnu.hurry.otherTest;


import org.junit.Test;

import javax.xml.crypto.Data;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

    @Test
    public void DateTest(){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        System.out.println(calendar);
    }
}
