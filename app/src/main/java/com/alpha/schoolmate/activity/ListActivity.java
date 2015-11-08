package com.alpha.schoolmate.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alpha.schoolmate.R;
import com.alpha.schoolmate.adapter.ListViewAdapter;
import com.alpha.schoolmate.entity.SchoolMate;
import com.alpha.schoolmate.util.JsonUtil;
import com.lody.welike.ui.WelikeToast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SongJian on 2015/11/4 0004.
 */
public class ListActivity extends Activity {
//    public static String name[] = new String[]{"腾腾", "钟波"};
//    public static String major[] = new String[]{"通信工程", "材料科学与技术"};
//    public static String sex[] = new String[]{"女","男"};

    public static SchoolMate schoolMate = new SchoolMate();

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

    public static List<Map<String, Object>> mapList;

    //动态获取数据源，可以是数组，json等
    public List<Map<String, Object>> getData() {
        List<Map<String, Object>> datamaps = new ArrayList<>();
        if (mapList != null) {

            for (int i = 0; i < mapList.size(); i++) {

                Map<String, Object> map = mapList.get(i);
                Map<String, Object> dataMap = new HashMap<>();
                dataMap.put("name", map.get("RealName"));
                dataMap.put("major", map.get("SpecialityName"));
                dataMap.put("sex", map.get("Sex"));
                datamaps.add(dataMap);
            }
            //return datamaps;
        }
        return datamaps;
    }


    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            WelikeToast.toast("您点击了第" + (position + 1) + "条信息");
        }
    };

}
