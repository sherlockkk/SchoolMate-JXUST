package com.alpha.schoolmate.util;


import android.util.Log;

import com.alpha.schoolmate.entity.SchoolMate;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * Created by SongJian on 2015/11/3 0003.
 */
public class HttpUtils {

    /**
     * 发送post请求到服务器
     */
    public static String submitPostData(String urlPath, Map<String, String> params, String encode) {
        //获得请求体
        byte[] data = getRequestData(params, encode).toString().getBytes();
        URL url = null;
        HttpURLConnection httpURLConnection;
        try {
            url = new URL(urlPath);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);//使用POST方式不能使用缓存

            //设置请求体的类型是文本类型
            //httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            //设置请求体的长度
            //httpURLConnection.setRequestProperty("Content-Length", String.valueOf(data.length));

            //获得输出流，向服务器写入数据
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(data);

            //获得服务器响应码
            int response = httpURLConnection.getResponseCode();
            if (response == httpURLConnection.HTTP_OK) {
                InputStream inputStream = httpURLConnection.getInputStream();
                return dealResponseResult(inputStream);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            return "erro:" + e.getMessage().toString();
        }
        return "-1";
    }

    /**
     * 封装请求体信息
     */
    public static StringBuffer getRequestData(Map<String, String> params, String encode) {
        StringBuffer stringBuffer = new StringBuffer();//存储封装好的请求体信息
        for (Map.Entry<String, String> entry :
                params.entrySet()) {
            try {
                stringBuffer.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue(), encode)).append("&");
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);//删除最后的一个&
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return stringBuffer;
    }

    /**
     * 处理服务器响应结果，将输入流转化成字符串
     */
    public static String dealResponseResult(InputStream inputStream) {
        String resultData = null;//存储处理结果
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int len = 0;
        try {
            while ((len = inputStream.read(data)) != -1) {
                byteArrayOutputStream.write(data, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        resultData = new String(byteArrayOutputStream.toByteArray());
        return resultData;
    }

    /**
     * 发送post请求给服务器
     */

    public static List<Map<String, Object>> SendRequest(String adress_Http, String strJson) {

        String returnLine = null;
        try {

            System.out.println("**************开始http通讯**************");
            System.out.println("**************调用的接口地址为**************" + adress_Http);
            System.out.println("**************请求发送的数据为**************" + strJson);
            URL my_url = new URL(adress_Http);
            HttpURLConnection connection = (HttpURLConnection) my_url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            //connection.setRequestProperty("Content-Type", "application/json");
            connection.connect();
            DataOutputStream out = new DataOutputStream(connection
                    .getOutputStream());
            byte[] content = strJson.getBytes("utf-8");
            out.write(content, 0, content.length);
            out.flush();
            out.close(); // flush and close
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            //StringBuilder builder = new StringBuilder();
            String line;
            System.out.println("Contents of post request start");
            while ((line = reader.readLine()) != null) {
                line = new String(line.getBytes(), "utf-8");
                returnLine += line;
                System.out.println(line);
            }

            System.out.println("Contents of post request ends");

            reader.close();
            connection.disconnect();
            System.out.println("========返回的结果的为========" + returnLine);


            try {
                JsonUtil jsonUtil = new JsonUtil();
                JSONArray jsonArray = new JSONArray(returnLine.substring(4));
                Log.i("cc", returnLine.substring(4));
                Log.i("cc", jsonArray.toString());

                List<Map<String,Object>> schoolMateList = jsonUtil.jsonArrayToString(jsonArray);
                return schoolMateList;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;


    }


}
