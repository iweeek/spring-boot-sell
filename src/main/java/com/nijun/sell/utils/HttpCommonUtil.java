package com.nijun.sell.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nijun.sell.dataobject.Token;
import com.nijun.sell.utils.wx.MyX509TrustManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

/**
 * User: nijun
 * Date: 2018/7/7
 * Time: 8:52 AM
 * Description: Http请求工具类
 */
@Slf4j
public class HttpCommonUtil {

    /** 凭证获取（GET）—— access_token. */
    public final static String TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    public static JsonNode httpsRequest(String requestUrl, String requestMethod, String outputStr) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = null;
        StringBuffer buffer = new StringBuffer();

        try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = {new MyX509TrustManager()};
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");

            sslContext.init(null, tm, new SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setSSLSocketFactory(ssf);

            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);
            connection.setRequestMethod("GET");

            if("GET".equalsIgnoreCase(requestMethod)) connection.connect();

            // 当outputStr不为null时向输出流写数据
            if (null != outputStr) {
                OutputStream outputStream = connection.getOutputStream();
                // 注意编码格式
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            // 从输入流读取返回内容
            InputStream inputStream = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(isr);
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }

            // 释放资源
            bufferedReader.close();
            isr.close();
            inputStream.close();
            inputStream = null;
            connection.disconnect();
            System.out.println(buffer.toString());
            jsonNode = mapper.readTree(buffer.toString());

        } catch (ConnectException e) {
            log.error("连接超时：{}", e);
        } catch (Exception e) {
            log.error("https请求异常");
        }
        return jsonNode;
    }

    /**
     * 获取接口访问凭证
     * @param appid
     * @param appsecret
     * @return
     */
    public static Token getToken(String appid, String appsecret) {
        Token token = null;
        String requestUrl = TOKEN_URL.replace("APPID", appid).replace("APPSECRET", appsecret);
        // 发起GET请求获取凭证
        JsonNode rootNode = httpsRequest(requestUrl, "GET", null);

        if (null != rootNode) {
            token = new Token();
            token.setAccessToken(rootNode.get("access_token").textValue());
            token.setExpiresIn(rootNode.get("expires_in").intValue());
        }
        return token;
    }

    /**
     * URL编码（utf-8）
     * @param source
     * @return
     */
    public static String urlEncodeUTF8(String source) {
        String result = source;
        try {
            result = URLEncoder.encode(source, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
