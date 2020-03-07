package com.test.api.service;


import com.test.api.mapper.RequestMapper;

import com.test.api.model.Request;
import com.test.api.untils.TimeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


@Service
public class RequestService {


    @Autowired
    RequestMapper requestMapper;

    public List<Request> getRequest(){
        HashMap timer = TimeMap.getTimer();
        String today= (String) timer.get("today");
        String nextDay= (String) timer.get("nextDay");
        return requestMapper.getRequest(today,nextDay);
    }
    public String getTodayAllRequest(){
        HashMap timer = TimeMap.getTimer();
        String today= (String) timer.get("today");
        String nextDay= (String) timer.get("nextDay");
        int allRequest=requestMapper.getTodayOldRequest(today,nextDay)+requestMapper.getTodayNewRequest(today,nextDay);

        return  String.valueOf(allRequest);
    }



}
