package com.alpha.schoolmate.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.alpha.schoolmate.R;

import java.util.List;
import java.util.Map;

/**
 * Created by SongJian on 2015/11/6.
 * <p/>
 * 邮箱：1129574214@qq.com
 */
public class DetailListViewAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ViewHolder holder = null;
    private List<Map<String, String>> data;

    public DetailListViewAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null==convertView){
            convertView = inflater.inflate(R.layout.layout_listview_detail,null);
//            holder.mKey = (TextView) convertView.findViewById(R.id.tv_key);
//            holder.mValue = (TextView) convertView.findViewById(R.id.tv_value);
            convertView.setTag("holder");
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }
}
