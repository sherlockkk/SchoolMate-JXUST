package com.alpha.schoolmate.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.alpha.schoolmate.R;
import com.alpha.schoolmate.activity.ListActivity;

import java.util.List;
import java.util.Map;

/**
 * Created by SongJian on 2015/11/5 0005.
 */
public class MyAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ViewHolder viewHolder = null;

    private List<Map<String, Object>> mData = new ListActivity().getData();

    public MyAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
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
        return position;
    }

    //返回的View即为列表框的View
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.layout_listview, null);
            viewHolder.mTvName = (TextView) convertView.findViewById(R.id.name);
            viewHolder.mTvMajor = (TextView) convertView.findViewById(R.id.major);
            viewHolder.mIbDetail = (ImageButton) convertView.findViewById(R.id.detail);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }
}
