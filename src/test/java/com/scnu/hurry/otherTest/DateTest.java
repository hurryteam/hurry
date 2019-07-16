package com.scnu.hurry.otherTest;


import org.junit.Test;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

    @Test
    public void DateTest(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E");
        String d =simpleDateFormat.format(date);
        System.out.println(d);
    }
}
