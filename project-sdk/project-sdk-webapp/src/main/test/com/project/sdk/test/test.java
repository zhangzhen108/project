package com.project.sdk.test;

import com.alibaba.fastjson.JSON;
import com.project.sdk.common.NearbyQuery;
import com.project.sdk.dto.merchant.Merchant;
import com.project.sdk.service.MerchantService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangzhen on 2017/7/11.
 */
public class test extends BaseTest{



    @Resource
    MerchantService merchantService;
    @Test
    public void aa(){
       /* Merchant merchantDto=new Merchant();
        Map<String,Object> map=NearbyQuery.findNeighPosition(120.420096,36.162324,0.5);
        merchantDto.setMinLatitude(Double.parseDouble(map.get("minlat").toString()));
        merchantDto.setMaxLatitude(Double.parseDouble(map.get("maxlat").toString()));
        merchantDto.setMaxLongitude(Double.parseDouble(map.get("maxlng").toString()));
        merchantDto.setMinLongitude(Double.parseDouble(map.get("minlng").toString()));
        List<Merchant> list= merchantService.queryList(merchantDto);
        System.out.print(JSON.toJSON(list));*/
    }
}
