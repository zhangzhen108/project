package com.project.web.service;

import com.project.sdk.common.page.ExecuteResult;

/**搜索框自动补全地址功能
 * Created by zhangzhen on 2017/7/26.
 */
public interface SplaceSearchService {
    /*
    地址补全查询
    type:json/xml
    cityLimit:是否启用region
     */
    public ExecuteResult<String> querySplaceAll(String keyWords,String region,String type,boolean cityLimit);
    /*
    location: 经度,纬度
    根据经纬度返回真实地点
     */
    public ExecuteResult<String> queryRealSplaceByLocation(String location) ;
}
