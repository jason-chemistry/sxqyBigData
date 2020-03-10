package com.test.api.service;


import com.test.api.mapper.RequestMapper;
import com.test.api.mapper.TodayDataMapper;
import com.test.api.model.Request;
import com.test.api.model.TodayData;
import com.test.api.untils.TimeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


@Service
public class TodayDataService {


    @Autowired
    TodayDataMapper todayDataMapper;
    public TodayData getAllData(){
        TodayData todayData=new TodayData();
        todayData.setInPeople(getInPeople());
        todayData.setZyPeople(getZyPeople());
        todayData.setMzPeople(getMzPeople());
        todayData.setCheckPeople(getOutPeople());
        return todayData;
    }
    public String getZyPeople(){
        return todayDataMapper.getZyPeople();
    }
    public String getOutPeople(){
        HashMap timer = TimeMap.getTimer();
        String today= (String) timer.get("today");
        String nextDay= (String) timer.get("nextDay");
        return todayDataMapper.getOutPeople(today,nextDay);
    }
    public String getInPeople(){
        HashMap timer = TimeMap.getTimer();
        String today= (String) timer.get("today");
        String nextDay= (String) timer.get("nextDay");
        return todayDataMapper.getInPeople(today,nextDay);
    }
    public String getMzPeople(){
        HashMap timer = TimeMap.getTimer();
        String today= (String) timer.get("today");
        String nextDay= (String) timer.get("nextDay");
        return todayDataMapper.getMzPeople(today,nextDay);
    }
    public String getZyCheckPeople(){
        Date date =new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        Calendar c = Calendar.getInstance();
        System.out.println("当前日期:"+sf.format(c.getTime()));
        String today=sf.format(c.getTime())+"000000";
        System.out.println("当前日期字符串为:"+today);
        return todayDataMapper.getZyCheckPeople(today);
    }

    public String getMzCheckPeople(){
        Date date =new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        Calendar c = Calendar.getInstance();
        System.out.println("当前日期:"+sf.format(c.getTime()));
        String today=sf.format(c.getTime())+"000000";
        System.out.println("当前日期字符串为:"+today);
        return todayDataMapper.getMzCheckPeople(today);
    }

    public String getAllCheckPeople(){
        String mzCheckPeople=getMzCheckPeople();
        String zyCheckPeople=getZyCheckPeople();
        int allCheck=Integer.parseInt(mzCheckPeople)+Integer.parseInt(zyCheckPeople);
        return  String.valueOf(allCheck);
    }
}
