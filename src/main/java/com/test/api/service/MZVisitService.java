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
        List<MZVisit> mZname = mzVisitMapper.getMZname(today, nextDay);
        Collections.sort(mZname, new Comparator<MZVisit>() {

            public int compare(MZVisit u1, MZVisit u2) {

                // 按照学生的年龄进行降序排列
                if (u1.getCount() < u2.getCount()) {
                    return -1;
                }
                if (u1.getCount() == u2.getCount()) {
                    return 0;
                }
                return 1;
            }
        });
        return  mZname;

    }

    public DrugMessage getDrugMessage(){
        DrugMessage drugMessage=new DrugMessage();
        String daiShoufei = getDaiShoufei();
        String weiQuYao = getWeiQuYao();
        String yShouFeiCount = getYShouFeiCount();
        String yiQuyao= getYiQuYao();
        String Fcount= String.valueOf((Integer.parseInt(daiShoufei)+Integer.parseInt(yShouFeiCount)));
        String Ycount= String.valueOf((Integer.parseInt(weiQuYao)+Integer.parseInt(yiQuyao)));
        drugMessage.setDaiShoufei(daiShoufei);
        drugMessage.setWeiQuYao(weiQuYao);

         // 是收费人数
        drugMessage.setYyCount(yShouFeiCount);
        drugMessage.setYiQuYao(yiQuyao);
        drugMessage.setFcount(Fcount);
        drugMessage.setYcount(Ycount);
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
    public String getYShouFeiCount(){
        HashMap timer = TimeMap.getTimer();
        String today= (String) timer.get("today");
        String nextDay= (String) timer.get("nextDay");
        return mzVisitMapper.getYShoueiCount(today,nextDay);
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
            lastDay=lastDay.substring(5);
            visitWeek.setDay(lastDay);
            visitWeek.setCount(count);
            list.add(visitWeek);

        }

        return list;
    }



}
