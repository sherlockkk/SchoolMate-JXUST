package com.alpha.schoolmate.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.alpha.schoolmate.R;
import com.alpha.schoolmate.adapter.MyAdapter;
import com.alpha.schoolmate.adapter.ViewHolder;
import com.lody.welike.ui.WelikeActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by SongJian on 2015/11/4 0004.
 */
public class ListActivity extends Activity {
    public static String title[] = new String[]{"菜名0", "菜名1", "菜名2", "菜名3", "菜名4", "菜名5", "菜名6", "菜名7", "菜名8", "菜名9"};
    public static String info[] = new String[]{"￥：28", "￥：28", "￥：28", "￥：28", "￥：28", "￥：28", "￥：28", "￥：28", "￥：28", "￥：28",};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initWidget();
    }

    public void initWidget() {
        ListView listView = (ListView) findViewById(R.id.listview);
        MyAdapter myAdapter = new MyAdapter(this);
        listView.setAdapter(myAdapter);
    }


    //动态获取数据源，可以是数组，json等
    public List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < title.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("name", title[i]);
            map.put("major", info[i]);
            list.add(map);
        }
        return list;
    }

    public void showInfo(int position) {

    }
}
