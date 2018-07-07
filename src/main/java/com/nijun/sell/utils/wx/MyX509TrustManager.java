package com.nijun.sell.utils.wx;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * User: nijun
 * Date: 2018/7/7
 * Time: 8:58 AM
 * Description: 信任管理器
 */
public class MyX509TrustManager implements X509TrustManager {

    // 检查客户端证书
    @Override
    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }

    // 检查服务器证书
    @Override
    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }

    // 返回受信任的X509证书数组
    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}
