package com.project.web.service.impl;

import com.dreamCommon.common.http.HttpRequest;
import com.project.sdk.common.page.ExecuteResult;
import com.project.web.service.SplaceSearchService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;

/**百度地图相关
 * Created by zhangzhen on 2017/7/26.
 */
@Service
public class SplaceSearchServiceImpl implements SplaceSearchService {

    @Value("${project.baiduSplace.querySplaceAllUrl}")
    private String querySplaceAllUrl;
    @Value("${project.baiduSplace.queryRealSplaceByLocation}")
    private String queryRealSplaceByLocation;
    @Value("${project.baiduSplace.ak}")
    private String ak;

    @Override
    public ExecuteResult<String> querySplaceAll(String keyWords, String region, String type, boolean cityLimit) {
        ExecuteResult<String> result = new ExecuteResult<String>();
        String json;
        try {
            String param = "query=" + URLEncoder.encode(keyWords, "UTF-8") + "&region=" + URLEncoder.encode(region, "UTF-8") + "&output=" + type + "&city_limit=" + cityLimit + "&ak=" + this.ak;
            json = HttpRequest.sendGet(querySplaceAllUrl, param);
            result.setResult(json);
        } catch (Exception e) {
            result.setErrorMessage(JSONObject.fromObject(e).toString());
        }
        return result;
    }
        @Override
        public ExecuteResult<String> queryRealSplaceByLocation(String location) {
            ExecuteResult<String> result = new ExecuteResult<String>();
            String json;
            try {
                String param = "location="+location + "&ak=" + this.ak;
                json = HttpRequest.sendGet(queryRealSplaceByLocation, param);
                result.setResult(json);
            } catch (Exception e) {
                result.setErrorMessage(JSONObject.fromObject(e).toString());
            }
            return result;
        }
}
