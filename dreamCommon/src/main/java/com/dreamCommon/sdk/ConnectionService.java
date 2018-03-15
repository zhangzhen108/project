package com.dreamCommon.sdk;

import com.dreamCommon.common.http.HttpRequest;
import net.sf.json.JSONObject;

/**
 * Class Name: ������
 * Description: �๦��˵��
 * Sample����ѡ��: ����ĵ���ʹ�÷���������
 * Author: zhangzhen
 * Date: 2017/7/7
 */
public class ConnectionService {

    String path="https://openapi.baidu.com/oauth/2.0/token";
    /*
    ��ȡAccess Token
     */
    public String getAccessToken(String path,String param){
        String json= HttpRequest.sendPost(path, null);
        JSONObject jsonObject = JSONObject.fromObject(json);
        String accessToken=(String)jsonObject.get("access_token");
        return accessToken;
    }

    public static void main(String[] args) {
        ConnectionService connectionService=new ConnectionService();
        String param="grant_type=client_credentials&client_id=cpNF6FWg46Bh0CB7S4gw22vI3NOlwjmd&client_secret=anee0wjidnHtKCshFC7BBoA8HyQX1AG3";
        String str=connectionService.getAccessToken(connectionService.path,param);
        System.out.print(str);
    }
}
