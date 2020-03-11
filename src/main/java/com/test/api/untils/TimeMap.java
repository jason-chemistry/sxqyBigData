package com.test.api.untils;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TimeMap {

    public static List<String> getHours() {
        Date date =new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        String today=sf.format(c.getTime());
        System.out.println(today);
        //时间数组
        ArrayList<String> a=new ArrayList<>();
        SimpleDateFormat sfd = new SimpleDateFormat("HH:MM");
        a.add(today+" 8:00:00");
//        a.add(sfd.parse("8:30"));
        a.add(today+" 9:00:00");
//        a.add(sfd.parse("9:30"));
        a.add(today+" 10:00:00");
//        a.add(sfd.parse("10:30"));
        a.add(today+" 11:00:00");
//        a.add(sfd.parse("11:30"));
        a.add(today+" 12:00:00");
//        a.add(sfd.parse("12:30"));
        a.add(today+" 13:00:00");
//        a.add(sfd.parse("13:30"));
        a.add(today+" 14:00:00");
//        a.add(sfd.parse("14:30"));
        a.add(today+" 15:00:00");
//        a.add(sfd.parse("15:30"));
        a.add(today+" 16:00:00");

        a.add(today+" 17:00:00");

//        a.add(sfd.parse("16:30"));






        return a;
    }
    public static List<String> getHours1() {
        Date date =new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        String today=sf.format(c.getTime());
        System.out.println(today);
        //时间数组
        ArrayList<String> a=new ArrayList<>();
        SimpleDateFormat sfd = new SimpleDateFormat("HH:MM");

//        a.add(sfd.parse("8:30"));
        a.add(today+" 9:00:00");
//        a.add(sfd.parse("9:30"));
        a.add(today+" 10:00:00");
//        a.add(sfd.parse("10:30"));
        a.add(today+" 11:00:00");
//        a.add(sfd.parse("11:30"));
        a.add(today+" 12:00:00");
//        a.add(sfd.parse("12:30"));
        a.add(today+" 13:00:00");
//        a.add(sfd.parse("13:30"));
        a.add(today+" 14:00:00");
//        a.add(sfd.parse("14:30"));
        a.add(today+" 15:00:00");
//        a.add(sfd.parse("15:30"));
        a.add(today+" 16:00:00");

        a.add(today+" 17:00:00");
        a.add(today+" 18:00:00");
//        a.add(sfd.parse("16:30"));






        return a;
    }

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
