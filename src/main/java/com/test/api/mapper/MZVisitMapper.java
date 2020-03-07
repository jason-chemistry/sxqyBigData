package com.test.api.mapper;


import com.test.api.model.MZVisit;
import com.test.api.model.Request;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MZVisitMapper {

    List<MZVisit> getMZname(@Param("today") String today, @Param("nextDay") String nextDay);


    String getDaiShoufei(@Param("today")String today,@Param("nextDay")String nextDay);

    String getYiQuYao(@Param("today")String today,@Param("nextDay")String nextDay);

    String getWeiQuYao(@Param("today")String today,@Param("nextDay")String nextDay);

    String getYyCount(@Param("today")String today,@Param("nextDay")String nextDay);

    String getMzVisitCount(@Param("today")String today,@Param("nextDay")String nextDay);

}
