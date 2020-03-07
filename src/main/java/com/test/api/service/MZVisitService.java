package com.test.api.service;


import com.test.api.mapper.MZVisitMapper;
import com.test.api.mapper.RequestMapper;
import com.test.api.model.DrugMessage;
import com.test.api.model.MZVisit;
import com.test.api.model.Request;
import com.test.api.model.VisitWeek;
import com.test.api.untils.TimeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class MZVisitService {


    @Autowired
    MZVisitMapper mzVisitMapper;

    public List<MZVisit> getMZVisit(){

        HashMap timer = TimeMap.getTimer();
        String today= (String) timer.get("today");
        String nextDay= (String) timer.get("nextDay");
        return mzVisitMapper.getMZname(today,nextDay);
    }

    public DrugMessage getDrugMessage(){
        DrugMessage drugMessage=new DrugMessage();
        drugMessage.setDaiShoufei(getDaiShoufei());
        drugMessage.setWeiQuYao(getWeiQuYao());
        drugMessage.setYyCount(getYyCount());
        drugMessage.setYiQuYao(getYiQuYao());
        return drugMessage;
    }

    public String getDaiShoufei(){
        HashMap timer = TimeMap.getTimer();
        String today= (String) timer.get("today");
        String nextDay= (String) timer.get("nextDay");
        return mzVisitMapper.getDaiShoufei(today,nextDay);
    }
    public String getYiQuYao(){
        HashMap timer = TimeMap.getTimer();
        String today= (String) timer.get("today");
        String nextDay= (String) timer.get("nextDay");
        return mzVisitMapper.getYiQuYao(today,nextDay);
    }
    public String getWeiQuYao(){
        HashMap timer = TimeMap.getTimer();
        String today= (String) timer.get("today");
        String nextDay= (String) timer.get("nextDay");
        return mzVisitMapper.getWeiQuYao(today,nextDay);
    }
    public String getYyCount(){
        HashMap timer = TimeMap.getTimer();
        String today= (String) timer.get("today");
        String nextDay= (String) timer.get("nextDay");
        return mzVisitMapper.getYyCount(today,nextDay);
    }


    public  List<VisitWeek> getMzVisitWeek(){
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        List<VisitWeek> list=new ArrayList<>();
        for(int i=0;i<6;i++){
            //今天
            String today = sf.format(c.getTime());
            System.out.println(today);
            c.add(Calendar.DAY_OF_MONTH, -1);
            //前一天
           String lastDay=sf.format(c.getTime());
           String count=mzVisitMapper.getMzVisitCount(lastDay,today);
            VisitWeek visitWeek=new VisitWeek();
            visitWeek.setDay(today);
            visitWeek.setCount(count);
            list.add(visitWeek);

        }

        return list;
    }



}
