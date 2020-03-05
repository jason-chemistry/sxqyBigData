package com.test.api.service;


import com.test.api.mapper.RequestMapper;
import com.test.api.mapper.TodayDataMapper;
import com.test.api.model.Request;
import com.test.api.model.TodayData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
        todayData.setCheckPeople(getAllCheckPeople());
        return todayData;
    }
    public String getZyPeople(){
        return todayDataMapper.getZyPeople();
    }
    public String getInPeople(){
        Date date =new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        System.out.println("当前日期:"+sf.format(c.getTime()));
        String today=sf.format(c.getTime());
        c.add(Calendar.DAY_OF_MONTH, 1);
        System.out.println("增加一天后日期:"+sf.format(c.getTime()));
        String nextDay=sf.format(c.getTime());
        return todayDataMapper.getInPeople(today,nextDay);
    }
    public String getMzPeople(){
        Date date =new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        System.out.println("当前日期:"+sf.format(c.getTime()));
        String today=sf.format(c.getTime());
        c.add(Calendar.DAY_OF_MONTH, 1);
        System.out.println("增加一天后日期:"+sf.format(c.getTime()));
        String nextDay=sf.format(c.getTime());
        return todayDataMapper.getMzPeople(today);
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
