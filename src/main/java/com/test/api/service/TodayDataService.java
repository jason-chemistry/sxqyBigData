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
        return todayData;
    }
    public String getZyPeople(){
        return todayDataMapper.getZyPeople();
    }
    public String getInPeople(){
        return todayDataMapper.getInPeople();
    }


}
