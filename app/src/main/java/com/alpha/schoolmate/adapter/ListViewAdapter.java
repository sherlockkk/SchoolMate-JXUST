package com.alpha.schoolmate.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.alpha.schoolmate.R;
import com.alpha.schoolmate.activity.DetailActivity;
import com.alpha.schoolmate.activity.ListActivity;
import com.alpha.schoolmate.util.Config;
import com.alpha.schoolmate.util.JsonUtil;
import com.lody.welike.WelikeHttp;
import com.lody.welike.http.HttpParams;
import com.lody.welike.http.HttpResponse;
import com.lody.welike.http.callback.HttpResultCallback;
import com.lody.welike.ui.WelikeToast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;

/**
 * Created by SongJian on 2015/11/5 0005.
 */
public class ListViewAdapter extends BaseAdapter {
    private LayoutInflater inflater;


    private List<Map<String, Object>> mData = new ListActivity().getData();

    ListActivity listActivity;

    public ListViewAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
        listActivity = (ListActivity) context;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    //返回的ID即为列表项的ID
    @Override
    public long getItemId(int position) {
        listActivity.toActivity(DetailActivity.class);
        String id = mData.get(position).get("UserID").toString();
        Map<String, String> userIdParams = new HashMap<>();
        HttpParams params = new HttpParams();
        userIdParams.put("id", id);
        HttpParams params1 = params.putAllParams(userIdParams);
        Log.i("cccc", userIdParams + "");
        WelikeHttp.getDefault().get(Config.GET_URL, params1, new HttpResultCallback() {

            @Override
            public void onSuccess(String content) {
                super.onSuccess(content);
                //Log.i("sj", content);
                try {
                    JSONObject jsonObject = new JSONObject(content);
                    JsonUtil jsonUtil = new JsonUtil();
                    Map<String, String> map = jsonUtil.jsonObjectToString(jsonObject);
                    System.out.println(map);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(HttpResponse response) {
                super.onFailure(response);
                WelikeToast.toast("哎呀！网络好像有点问题0.0");
            }
        });

        return position;

    }

    //返回的View即为列表框的View
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();


        //if (convertView == null) {
            convertView = inflater.inflate(R.layout.layout_listview, null);


            viewHolder.mTvName = (TextView) convertView.findViewById(R.id.name);
            viewHolder.mTvMajor = (TextView) convertView.findViewById(R.id.major);
            viewHolder.mTvSex = (TextView) convertView.findViewById(R.id.sex);
            //convertView.setTag(viewHolder);
        //} else {
          //  viewHolder = (ViewHolder) convertView.getTag();
        //}

        viewHolder.mTvName.setText((String) mData.get(position).get("name"));
        viewHolder.mTvMajor.setText((String) mData.get(position).get("major"));
        viewHolder.mTvSex.setText((String) mData.get(position).get("sex"));


        return convertView;
    }
}
