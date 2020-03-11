package com.test.api.service;


import com.test.api.mapper.DataMapper;

import com.test.api.mapper.MZVisitMapper;
import com.test.api.mapper.TodayDataMapper;
import com.test.api.model.MZVisit;
import com.test.api.untils.TimeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class DataMapService {
    @Autowired
    DataMapper dataMapper;

    @Autowired
    MZVisitMapper mzVisitMapper;


    public List<String> getLisAndCheck(){

        ArrayList<String> lisAndCheck=new ArrayList<>();
        String lisPeople = dataMapper.getLisCount((String) TimeMap.getTimer().get("today"),(String)TimeMap.getTimer().get("nextDay"));
        lisAndCheck.add(lisPeople);
        return lisAndCheck;
    }

    //获取每一个小时的就诊人数
    public List<String> getMzCountHours(){
        ArrayList<String> mzCount=new ArrayList<>();
        List<String> hours = TimeMap.getHours();
        List<String> hours1 = TimeMap.getHours1();
        for (int i=0;i<hours.size();i++){
            int count=dataMapper.getMzCount(hours.get(i),hours1.get(i));
            if(count<=0){
                break;
            }else{
                mzCount.add(String.valueOf(count));
            }
        }

        return mzCount;

    }
    //获取每一个小时的检验人数
    public List<String> getLisCountHours(){
        ArrayList<String> lisCount=new ArrayList<>();
        List<String> hours = TimeMap.getHours();
        List<String> hours1 = TimeMap.getHours1();
        for (int i=0;i<hours.size();i++){
            int count= Integer.parseInt(dataMapper.getLisCount(hours.get(i),hours1.get(i)));
            if(count<=0){
                break;
            }else{
                lisCount.add(String.valueOf(count));
            }
        }

        return lisCount;

    }

    public List<String> getQYCountHours(){
        ArrayList<String> QyCount =new ArrayList<>();
        List<String> hours = TimeMap.getHours();
        List<String> hours1 = TimeMap.getHours1();
        for (int i=0;i<hours.size();i++){
            int count= dataMapper.getQYCount(hours.get(i),hours1.get(i));
            if(count<=0){
                break;
            }else{
                QyCount.add(String.valueOf(count));
            }
        }
        return QyCount;
    }


    public List<String> getSfCountHours(){
        ArrayList<String> SfCount =new ArrayList<>();
        List<String> hours = TimeMap.getHours();
        List<String> hours1 = TimeMap.getHours1();
        for (int i=0;i<hours.size();i++){
            int count= dataMapper.getSfCount(hours.get(i),hours1.get(i));
            if(count<=0){

                break;
            }else{

                SfCount.add(String.valueOf(count));
            }
        }
        return SfCount;
    }

    public HashMap<String,ArrayList<String>> getAll(){
       HashMap<String,ArrayList<String>> map=new HashMap<>();

        map.put("SFCOUNT", (ArrayList<String>) getSfCountHours());
        map.put("QYCOUNT", (ArrayList<String>) getQYCountHours());
        map.put("LISCOUNT", (ArrayList<String>) getLisCountHours());
        map.put("MZCOUNT", (ArrayList<String>) getMzCountHours());
        return map;
    }
}
