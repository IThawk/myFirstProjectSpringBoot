package com.itHawk.springBoot.utils;

import com.baidu.aip.ocr.AipOcr;
import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.util.Util;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public class BaiduUtils {

    /***
     * 图片识别
     * @param client
     */
    public void sample(AipOcr client) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
        options.put("detect_language", "true");
        options.put("probability", "true");

        // 参数为本地图片路径
        String image = "test.jpg";
        JSONObject res = client.basicGeneral(image, options);
        System.out.println(res.toString(2));

        // 参数为本地图片二进制数组
        byte[] file = ImageChangeUtils.image2byte(image);
        res = client.basicGeneral(file, options);
        System.out.println(res.toString(2));


        // 通用文字识别, 图片参数为远程url图片
       // JSONObject res = client.basicGeneralUrl(url, options);

    }

    /***
     * 语音识别接口
     * @param client
     */
    public void asr(AipSpeech client)
    {
        // 对本地语音文件进行识别（）
        String path = "D:\\code\\java-sdk\\speech_sdk\\src\\test\\resources\\16k_test.pcm";
        JSONObject asrRes = client.asr(path, "pcm", 16000, null);
        System.out.println(asrRes);

        // 对语音二进制数据进行识别
        byte[] data = new byte[0];     //readFileByBytes仅为获取二进制数据示例
        try {
            data = Util.readFileByBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject asrRes2 = client.asr(data, "pcm", 16000, null);
        System.out.println(asrRes2);

    }
}
