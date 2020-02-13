package com.test.api.controller;


import com.alibaba.fastjson.JSONObject;
import com.test.api.service.MZVisitService;
import com.test.api.service.RequestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "获取门诊类型接口")
@RestController
@RequestMapping(value="/MZVisits")
public class MZVisitController {


    @Autowired
    MZVisitService mzVisitService;

    @ResponseBody
    @RequestMapping(value = "",method = RequestMethod.GET)
    @ApiOperation(value = "获取门诊人数", notes = "无需参数")
    public String getMZVisit (){
        return JSONObject.toJSONString(mzVisitService.getMZVisit());

    }









}