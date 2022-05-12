package com.qdc.demoeurekaconsumer1.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class HttpClientWithBasicAuth {


    private String getHeader(String UserName, String Password) {
        //auth有两部分组成：UserName和Password组成
        String auth = UserName + ":" + Password;
        //使用base64将auth进行加密
        byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String(encodeAuth);
        return authHeader;

    }

    //组织请求参数，在获取token是参数为grant——type scope
    public String send(String url, String UserName, String Password, Map<String, String> params) throws IOException {
        HttpPost post = new HttpPost(url);
        CloseableHttpClient client = HttpClients.createDefault();
        List<NameValuePair> paramList = new ArrayList<>();
        if (params != null && params.size() > 0) {
            Set<String> keySet = params.keySet();
            for (String key : keySet) {
                paramList.add(new BasicNameValuePair(key, params.get(key)));
            }
        }
        try {
            //设置要提交的额数据
            post.setEntity(new UrlEncodedFormEntity(paramList, "utf-8"));

        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        post.addHeader("Authorization", getHeader(UserName, Password));
        //执行提及哎请求，execute执行post请求，并对返回的结果进行判断
        String responseContent = null;//响应内容
        CloseableHttpResponse response = null;
        try {
            response = client.execute(post);
            int status_code = response.getStatusLine().getStatusCode();
            System.out.println("status_code:" + status_code);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                responseContent = EntityUtils.toString(entity, "UTF-8");
            }
            System.out.println("responseContent:" + responseContent);

        } catch (ClientProtocolException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseContent;
    }
}
