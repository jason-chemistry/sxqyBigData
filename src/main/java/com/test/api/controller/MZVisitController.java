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

@Api(description = "获取门诊数据接口")
@RestController
@RequestMapping(value="/MZVisits")
public class MZVisitController {


    @Autowired
    MZVisitService mzVisitService;

    @ResponseBody
    @RequestMapping(value = "",method = RequestMethod.GET)
    @ApiOperation(value = "获取门诊各科室预约详情", notes = "无需参数")
    public String getMZVisit (){
        return JSONObject.toJSONString(mzVisitService.getMZVisit());

    }
    @ResponseBody
    @RequestMapping(value = "/MzUnit",method = RequestMethod.GET)
    @ApiOperation(value = "获取门诊各科室就诊详情", notes = "无需参数")
    public String getMzUnit (){
        return JSONObject.toJSONString(mzVisitService.getMZVisitUnit());

    }


    @ResponseBody
    @RequestMapping(value = "DaiShoufei",method = RequestMethod.GET)
    @ApiOperation(value = "获取门诊待收费", notes = "无需参数")
    public String getDaiShoufei (){
        return JSONObject.toJSONString(mzVisitService.getDaiShoufei());

    }
    @ResponseBody
    @RequestMapping(value = "WeiQuYao",method = RequestMethod.GET)
    @ApiOperation(value = "获取门诊未取药", notes = "无需参数")
    public String getWeiQuYao (){
        return JSONObject.toJSONString(mzVisitService.getWeiQuYao());

    }
    @ResponseBody
    @RequestMapping(value = "YiQuYao",method = RequestMethod.GET)
    @ApiOperation(value = "获取门诊已取药", notes = "无需参数")
    public String getYiQuYao (){
        return JSONObject.toJSONString(mzVisitService.getYiQuYao());

    }
    @ResponseBody
    @RequestMapping(value = "YSFCount",method = RequestMethod.GET)
    @ApiOperation(value = "获取门诊已收费", notes = "无需参数")
    public String getYyCount (){
        return JSONObject.toJSONString(mzVisitService.getYShouFeiCount());

    }
    @ResponseBody
    @RequestMapping(value = "DrugMessage",method = RequestMethod.GET)
    @ApiOperation(value = "获取门诊相关数据", notes = "无需参数")
    public String getDrugMessage (){
        return JSONObject.toJSONString(mzVisitService.getDrugMessage());

    }
    @ResponseBody
    @RequestMapping(value = "WeekCount",method = RequestMethod.GET)
    @ApiOperation(value = "获取一周门诊", notes = "无需参数")
    public String getWeekCount (){
        return JSONObject.toJSONString(mzVisitService.getMzVisitWeek());

    }


}