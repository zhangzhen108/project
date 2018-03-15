package com.dreamCommon.common.baiduVoice;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Class Name: ������
 * Description: �๦��˵��
 * Sample����ѡ��: ����ĵ���ʹ�÷���������
 * Author: zhangzhen
 * Date: 2017/7/7
 */
public class Sample {
    //����APPID/AK/SK
    public static final String APP_ID = "��� App ID";
    public static final String API_KEY = "��� Api ID";
    public static final String SECRET_KEY = "��� Secret Key";
    public static void main(String[] args) {
        // ��ʼ��һ��FaceClient
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
        // ��ѡ�������������Ӳ���
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        // ����API
        JSONObject res = client.asr("test.pcm", "pcm", 16000, null);
        System.out.println(res.toString(2));
    }
    public void synthesis(AipSpeech client)
    {
        TtsResponse res = client.synthesis("��ðٶ�", "zh", 1, null);
        System.out.println(res.getErrorCode());
        // ���ÿ�ѡ����
        HashMap<String, Object> options = new HashMap<String, Object>();
        options.put("spd", "5");
        options.put("pit", "5");
        options.put("per", "4");
        TtsResponse res1 = client.synthesis("��ðٶ�", "zh", 1, options);
        System.out.println(res.getErrorCode());
        byte[] data = res.getData();
    }
}
