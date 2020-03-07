package com.test.api.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();

        for(int i=0;i<7;i++){
            //今天
            String today = sf.format(c.getTime());
            System.out.println(today);
            c.add(Calendar.DAY_OF_MONTH, -1);
            //前一天
            System.out.println(sf.format(c.getTime()));

        }
    }

}
