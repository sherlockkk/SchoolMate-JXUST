package com.alpha.schoolmate.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alpha.schoolmate.R;
import com.alpha.schoolmate.adapter.ListViewAdapter;
import com.lody.welike.ui.WelikeToast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SongJian on 2015/11/4 0004.
 */
public class ListActivity extends Activity {
    public static String title[] = new String[]{"腾腾", "钟波"};
    public static String info[] = new String[]{"通信工程", "材料科学与技术"};
    public static String sex[] = new String[]{"女","男"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initWidget();
    }

    public void initWidget() {
        ListView listView = (ListView) findViewById(R.id.listview);
        ListViewAdapter myAdapter = new ListViewAdapter(this);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(onItemClickListener);
    }


    //动态获取数据源，可以是数组，json等
    public List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < title.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("name", title[i]);
            map.put("major", info[i]);
            map.put("sex",sex[i]);
            list.add(map);
        }
        return list;
    }


    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            WelikeToast.toast("您点击了第" + (position + 1) + "条信息");
        }
    };

}
