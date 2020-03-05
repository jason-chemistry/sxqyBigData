package com.test.api.mapper;


import com.test.api.model.MZVisit;
import com.test.api.model.TodayData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TodayDataMapper {

    String  getZyPeople();

    String getInPeople(@Param("today")String today,@Param("nextDay")String nextDay);

    String getMzPeople(@Param("today")String today);

    String getMzCheckPeople(@Param("today")String today);

    String getZyCheckPeople(@Param("today")String today);
}
