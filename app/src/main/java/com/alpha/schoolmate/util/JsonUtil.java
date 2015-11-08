package com.alpha.schoolmate.util;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.Log;

import com.alpha.schoolmate.activity.MainActivity;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.lody.welike.WelikeHttp;
import com.lody.welike.http.HttpParams;
import com.lody.welike.http.callback.HttpResultCallback;
import com.lody.welike.ui.WelikeToast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by SongJian on 2015/11/5.
 * <p/>
 * 邮箱：1129574214@qq.com
 */
public class JsonUtil {
    //Json对象转换为集合
    public List<?> jsonToString(String jsonData) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<?>>() {
        }.getType();
        ArrayList<?> list = gson.fromJson(jsonData, listType);
        return list;
    }

    //写入Json数据,转换为String对象
    public String getJsonDataToString(List<?> list) {
        Gson gson = new Gson();
        String stringJson = gson.toJson(list);
        return stringJson;
    }

    //    private void changeArrayDateToJson(Map<String, String> params) {  //把一个集合转换成json格式的字符串
//        JSONArray jsonArray=null;
//        JSONObject object=null;
//        jsonArray = new JSONArray();
//        object=new JSONObject();
//        for (int i = 0; i <params.size(); i++) {  //遍历上面初始化的集合数据，把数据加入JSONObject里面
//            JSONObject object2 = new JSONObject();//一个user对象，使用一个JSONObject对象来装
//            try {
//                object2.put("userId", params.get(i).getUserId());  //从集合取出数据，放入JSONObject里面 JSONObject对象和map差不多用法,以键和值形式存储数据
//                object2.put("userName", userBeans.get(i).getUserName());
//                jsonArray.put(object2); //把JSONObject对象装入jsonArray数组里面
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//
//        try {
//            object.put("userDate", jsonArray); //再把JSONArray数据加入JSONObject对象里面(数组也是对象)
//            //object.put("time", "2013-11-14"); //这里还可以加入数据，这样json型字符串，就既有集合，又有普通数据
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        jsonString=null;
//        jsonString = object.toString(); //把JSONObject转换成json格式的字符串
//        textView.setText(jsonString);
//        Log.i("hck", "转换成json字符串: " + jsonString);
//
//    }
    public String changeNotArrayDateToJson(Map<String, String> params) {
        //JSONObject object=null;
        JSONObject object = new JSONObject();
        try {
            object.put("SpecialityName", params.get("SpecialityName"));
            object.put("RealName", params.get("RealName"));
            object.put("ClassName", params.get("ClassName"));
            object.put("Graduation", params.get("Graduation"));
            object.put("WorkPlace", params.get("WorkPlace"));
            object.put("Address", params.get("Address"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String jsonString2 = object.toString();//把JSONObject转换成json格式的字符串
        return jsonString2;
    }
    //解析json数组
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public String jsonArrayToString(JSONArray jsonData){
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0;i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String realName = jsonObject.getString("RealName");
                String className = jsonObject.getString("ClassName");
                String graduation = jsonObject.getString("Graduation");
                String specialityName = jsonObject.getString("SpecialityName");
                String workPlace = jsonObject.getString("WorkPlace");
                String birthday = jsonObject.getString("Birthday");
                String email = jsonObject.getString("Email");
                String sex = jsonObject.getString("Sex");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

}
