package com.yuwei.adsense.util;

import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Component
public class HttpUtil {
    private static final String default_charset = "UTF-8";

    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);


    /**
     * post方式提交表单
     */
    public String postForString(String url, Map<String, String> parameters) {

        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httppost
        HttpPost httppost = new HttpPost(url);
        // 创建参数队列
        List<NameValuePair> formParams = getParameters(parameters);
        UrlEncodedFormEntity uefEntity;
        try {
            uefEntity = new UrlEncodedFormEntity(formParams, default_charset);
            httppost.setEntity(uefEntity);
            logger.debug("executing request " + httppost.getURI());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity entity = response.getEntity();
                String content = EntityUtils.toString(entity, default_charset);
                if (entity != null) {
                    printResponseContent(content);
                }
                return content;
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public <T> T postForOject(String url, Map<String, String> parameters, Class<T> tClass) {
        String content = postForString(url, parameters);
        if (StringUtils.isEmpty(content)) {
            return null;
        }
        Gson gson = new Gson();
        return gson.fromJson(content, tClass);
    }

    /**
     * @param postUrl
     * @param parameters
     * @return
     */
    public String post(String postUrl, String[] parameters) {
        if (null == postUrl || null == parameters || parameters.length == 0) {
            return null;
        }
        String content = "";
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            //建立URL之间的连接
            URLConnection conn = new URL(postUrl).openConnection();
            //设置通用的请求属性
            conn.setRequestProperty("Host", SpringContextUtils.getCurrentSite().getSiteUrl());
            conn.setRequestProperty("User-Agent", "curl/7.12.1");
            conn.setRequestProperty("Content-Length", "83");
            conn.setRequestProperty("Content-Type", "text/plain");

            //发送POST请求必须设置如下两行
            conn.setDoInput(true);
            conn.setDoOutput(true);

            //获取conn对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            //发送请求参数
            String param = "";
            for (String s : parameters) {
                param += s + "\n";
            }
            out.print(param.trim());
            //进行输出流的缓冲
            out.flush();
            //通过BufferedReader输入流来读取Url的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                content += line;
            }

            printResponseContent(content);

        } catch (Exception e) {
            System.out.println("发送post请求出现异常！" + e);
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return content;
    }

    /**
     * 发送 get请求
     */
    public String getForString(String url) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            // 创建httpget.
            HttpGet httpget = new HttpGet(url);
            logger.debug("executing request " + httpget.getURI());
            // 执行get请求.
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                // 获取响应实体
                HttpEntity entity = response.getEntity();
                logger.debug("--------------------------------------");
                // 打印响应状态
                logger.debug(response.getStatusLine().toString());
                String content = "";
                if (entity != null) {
                    content = EntityUtils.toString(entity);
                    // 打印响应内容长度
                    logger.debug("Response content length: " + entity.getContentLength());
                    // 打印响应内容
                    logger.debug("Response content: " + content);
                }
                logger.debug("------------------------------------");
                return content;
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public <T> T getForOject(String url, Map<String, String> parameters, Class<T> tClass) {
        String content = getForString(url);
        if (StringUtils.isEmpty(content)) {
            return null;
        }
        Gson gson = new Gson();
        return gson.fromJson(content, tClass);
    }

    private List<NameValuePair> getParameters(Map<String, String> params) {
        List<NameValuePair> formParams = new ArrayList<NameValuePair>();
        if (params == null) {
            return formParams;
        }
        Iterator<Map.Entry<String, String>> it = params.entrySet().iterator();
        Map.Entry<String, String> next;
        while (it.hasNext()) {
            next = it.next();
            formParams.add(new BasicNameValuePair(next.getKey(), next.getValue()));
        }
        return formParams;
    }

    private void printResponseContent(String content) {
        logger.debug("--------------------------------------");
        logger.debug("Response content: " + content);
        logger.debug("--------------------------------------");
    }
}
