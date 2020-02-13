package com.test.api.service;


import com.test.api.mapper.MZVisitMapper;
import com.test.api.mapper.RequestMapper;
import com.test.api.model.MZVisit;
import com.test.api.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Service
public class MZVisitService {


    @Autowired
    MZVisitMapper mzVisitMapper;

    public List<MZVisit> getMZVisit(){
        Date date =new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        System.out.println("当前日期:"+sf.format(c.getTime()));
        String today=sf.format(c.getTime());
        c.add(Calendar.DAY_OF_MONTH, 1);
        System.out.println("增加一天后日期:"+sf.format(c.getTime()));
        String nextDay=sf.format(c.getTime());
        return mzVisitMapper.getMZname(today,nextDay);
    }

}
