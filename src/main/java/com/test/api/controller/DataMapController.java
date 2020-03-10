package com.test.api.controller;


import com.alibaba.fastjson.JSONObject;
import com.test.api.service.DataMapService;
import com.test.api.service.MZVisitService;
import com.test.api.service.TodayDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "获取折线图相关数据")
@RestController
@RequestMapping(value="/dataMap")
public class DataMapController {

    @Autowired
    DataMapService dataMapService;

    @Autowired
    TodayDataService todayDataService;

    @ResponseBody
    @RequestMapping(value = "/CheckAndLis",method = RequestMethod.GET)
    @ApiOperation(value = "获取检查检验人数", notes = "无需参数")
    public String getMZVisit (){

        List<String> lisAndCheck = dataMapService.getLisAndCheck();
        lisAndCheck.add(todayDataService.getAllCheckPeople());
        return JSONObject.toJSONString(lisAndCheck);
    }


    @ResponseBody
    @RequestMapping(value = "/MzCountHours",method = RequestMethod.GET)
    @ApiOperation(value = "获取每个小时门诊人数", notes = "无需参数")
    public String getMzCountHours (){
        return JSONObject.toJSONString(dataMapService.getMzCountHours());

    }

    @ResponseBody
    @RequestMapping(value = "/LisCountHours",method = RequestMethod.GET)
    @ApiOperation(value = "获取每个小时检验人数", notes = "无需参数")
    public String getLisCountHours (){
        return JSONObject.toJSONString(dataMapService.getLisCountHours());

    }

    @ResponseBody
    @RequestMapping(value = "/SfCountHours",method = RequestMethod.GET)
    @ApiOperation(value = "获取每个小时收费人数", notes = "无需参数")
    public String getSfCountHours (){
        return JSONObject.toJSONString(dataMapService.getSfCountHours());

    }

    @ResponseBody
    @RequestMapping(value = "/QYCountHours",method = RequestMethod.GET)
    @ApiOperation(value = "获取每个小时取药人数", notes = "无需参数")
    public String getQYCountHours (){
        return JSONObject.toJSONString(dataMapService.getQYCountHours());

    }

    @ResponseBody
    @RequestMapping(value = "",method = RequestMethod.GET)
    @ApiOperation(value = "获取全部", notes = "无需参数")
    public String getAll (){
        return JSONObject.toJSONString(dataMapService.getAll());
    }



}
