package com.test.api.untils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class TimeMap {

    public  static  HashMap getTimer(){
        Date date =new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        String today=sf.format(c.getTime());
        c.add(Calendar.DAY_OF_MONTH, 1);
        String nextDay=sf.format(c.getTime());
        HashMap<String,String> Time= new HashMap<String,String>();
        Time.put("today",today);
        Time.put("nextDay",nextDay);
        return  Time;
    }
}
