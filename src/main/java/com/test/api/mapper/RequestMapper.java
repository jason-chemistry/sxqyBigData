package com.test.api.mapper;


import com.test.api.model.Request;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RequestMapper {

    List<Request> getRequest(@Param("today")String today,@Param("nextDay")String nextDay);
    //获取老病人预约
    int getTodayOldRequest(@Param("today")String today,@Param("nextDay")String nextDay);
    //获取新病人预约
    int getTodayNewRequest(@Param("today")String today,@Param("nextDay")String nextDay);



}
