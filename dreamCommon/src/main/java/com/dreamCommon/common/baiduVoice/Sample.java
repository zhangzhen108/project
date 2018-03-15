package com.dreamCommon.common.baiduVoice;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Class Name: 类名称
 * Description: 类功能说明
 * Sample（可选）: 该类的典型使用方法和用例
 * Author: zhangzhen
 * Date: 2017/7/7
 */
public class Sample {
    //设置APPID/AK/SK
    public static final String APP_ID = "你的 App ID";
    public static final String API_KEY = "你的 Api ID";
    public static final String SECRET_KEY = "你的 Secret Key";
    public static void main(String[] args) {
        // 初始化一个FaceClient
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        // 调用API
        JSONObject res = client.asr("test.pcm", "pcm", 16000, null);
        System.out.println(res.toString(2));
    }
    public void synthesis(AipSpeech client)
    {
        TtsResponse res = client.synthesis("你好百度", "zh", 1, null);
        System.out.println(res.getErrorCode());
        // 设置可选参数
        HashMap<String, Object> options = new HashMap<String, Object>();
        options.put("spd", "5");
        options.put("pit", "5");
        options.put("per", "4");
        TtsResponse res1 = client.synthesis("你好百度", "zh", 1, options);
        System.out.println(res.getErrorCode());
        byte[] data = res.getData();
    }
}
