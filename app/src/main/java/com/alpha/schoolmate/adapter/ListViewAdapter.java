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
public class ListViewAdapter extends BaseAdapter {
    private LayoutInflater inflater;


    private List<Map<String, Object>> mData = new ListActivity().getData();

    public ListViewAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    public ListViewAdapter() {

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
        ViewHolder viewHolder = new ViewHolder();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.layout_listview, null);


            viewHolder.mTvName = (TextView) convertView.findViewById(R.id.name);
            viewHolder.mTvMajor = (TextView) convertView.findViewById(R.id.major);
            viewHolder.mTvSex = (TextView) convertView.findViewById(R.id.sex);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.mTvName.setText((String) mData.get(position).get("name"));
        viewHolder.mTvMajor.setText((String) mData.get(position).get("major"));
        viewHolder.mTvSex.setText((String) mData.get(position).get("sex"));

        return convertView;
    }
}
