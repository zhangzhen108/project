package com.project.web.controller;

import com.project.sdk.common.page.ExecuteResult;
import com.project.web.service.SplaceSearchService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**https://api.map.baidu.com/geocoder/v2/?location=36.162324,120.420096&ak=RK7RVpMoUcjvCfSMGE46vULUc8HZkgGD
 * Created by zhangzhen on 2017/7/26.
 */
@Controller
@RequestMapping("splaceSearch")
public class SplaceSearchController {
    @Resource
    SplaceSearchService splaceSearchService;
    @RequestMapping("querySplaceAll")
    @ResponseBody
    public String querySplaceAll(String keyWords,String region,String type,boolean cityLimit){
        ExecuteResult<String> result= splaceSearchService.querySplaceAll(keyWords, region, type, cityLimit);
        return JSONObject.fromObject(result).toString();
    }
    @RequestMapping("queryRealSplaceByLocation")
    @ResponseBody
    public String queryRealSplaceByLocation(String location){

        ExecuteResult<String> result= splaceSearchService.queryRealSplaceByLocation(location);
        return JSONObject.fromObject(result).toString();
    }

}
