package com.project.web.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Class Name: 类名称
 * Description: 计算范围内经纬度
 * Sample（可选）: 该类的典型使用方法和用例
 * Author: zhangzhen
 * Date: 2017/7/10
 */
public class NeighPosition {
    /*
    dis:范围 单位：千米
    longitude：
    latitude：
     */
    public Map<String,Object> findNeighPosition(double longitude,double latitude,double dis){
        Map<String,Object> map=new HashMap<String, Object>();
        //先计算查询点的经纬度范围
        double r = 6371;//地球半径千米
        //double dis = 0.5;//0.5千米距离
        double dlng =  2*Math.asin(Math.sin(dis/(2*r))/Math.cos(latitude*Math.PI/180));
        dlng = dlng*180/Math.PI;//角度转为弧度
        double dlat = dis/r;
        dlat = dlat*180/Math.PI;
        double minlat =latitude-dlat;
        double maxlat = latitude+dlat;
        double minlng = longitude -dlng;
        double maxlng = longitude + dlng;
        map.put("minlat",minlat);
        map.put("maxlat",maxlat);
        map.put("minlng",maxlat);
        map.put("maxlng",maxlat);
        //String hql = "from Property where longitude>=? and longitude =<? and latitude>=? latitude=<? and state=0";
        //Object[] values = {minlng,maxlng,minlat,maxlat};

       // List<XMLSecurityPropertyManager.Property> list = find(hql, values);
        return map;
    }
}
