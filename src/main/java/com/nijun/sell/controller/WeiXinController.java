package com.nijun.sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

/**
 * User: nijun
 * Date: 2018/7/7
 * Time: 8:06 AM
 * Description:
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeiXinController {

    private final static String token = "e10adc3949ba59abbe56e057f20f883e";

    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code) {
        log.info("进入auth方法... ");
        log.info("code={}", code);
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx5d2168dc5070bd2f&secret=54f4b8d6904727a53f886773a3671cdd&code=" + code + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        log.info("response={}", response);

    }


    @GetMapping("/token")
    public String token(@RequestParam("signature") String signature,
                        @RequestParam("timestamp") String timestamp,
                        @RequestParam("nonce") String nonce,
                        @RequestParam("echostr") String echostr) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        // 1）将token、timestamp、nonce三个参数进行字典序排序
        String[] ary = new String[]{timestamp, nonce, token};
        Arrays.sort(ary);
        // 2）将三个参数字符串拼接成一个字符串进行sha1加密
        String s = ary[0] + ary[1] + ary[2];
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] digest = md.digest(s.getBytes("utf-8"));
        // 3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
        String s1 = bytesToHexString(digest);
        if (!signature.equals(s1)) {
            return null;
        }
        return echostr;
    }

    @GetMapping("/accessToken")
    public String accessToken() {
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx5d2168dc5070bd2f&secret=54f4b8d6904727a53f886773a3671cdd";
        StringBuffer stringBuffer = new StringBuffer();
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);
            connection.setRequestMethod("GET");
            connection.connect();

            InputStream inputStream = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(isr);
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                stringBuffer.append(str);
            }

            bufferedReader.close();
            isr.close();
            inputStream.close();
            inputStream = null;
            connection.disconnect();
            System.out.println(stringBuffer.toString());
            return stringBuffer.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
}
