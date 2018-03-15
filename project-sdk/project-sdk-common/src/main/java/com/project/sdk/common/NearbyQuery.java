package com.project.sdk.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/16.
 */
public class NearbyQuery {
    public static Map<String,Object> findNeighPosition(double longitude,double latitude,double dis){
        //先计算查询点的经纬度范围
        double r = 6371;//地球半径千米
       // double dis = 0.5;//0.5千米距离
        double dlng =  2*Math.asin(Math.sin(dis/(2*r))/Math.cos(latitude*Math.PI/180));
        dlng = dlng*180/Math.PI;//角度转为弧度
        double dlat = dis/r;
        dlat = dlat*180/Math.PI;
        double minlat =latitude-dlat;
        double maxlat = latitude+dlat;
        double minlng = longitude -dlng;
        double maxlng = longitude + dlng;

        String hql = "from Property where longitude>=? and longitude =<? and latitude>=? latitude=<? and state=0";
        Object[] values = {minlng,maxlng,minlat,maxlat};
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("minlat",minlat);
        map.put("maxlat",maxlat);
        map.put("minlng",minlng);
        map.put("maxlng",maxlng);
        return map;
    }
}
