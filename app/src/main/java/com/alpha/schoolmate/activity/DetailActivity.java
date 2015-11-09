package com.alpha.schoolmate.activity;

import android.os.Bundle;
import android.view.View;

import com.alpha.schoolmate.R;
import com.lody.welike.ui.WelikeActivity;

/**
 * Created by SongJian on 2015/11/9.
 * <p/>
 * 邮箱：1129574214@qq.com
 */
public class DetailActivity extends WelikeActivity {
    public DetailActivity() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }

    @Override
    public void onDataLoaded() {
        super.onDataLoaded();
    }

    @Override
    public void initGlobalView(Bundle savedInstanceState) {
        super.initGlobalView(savedInstanceState);
    }

    @Override
    public void initWidget() {
        super.initWidget();
    }

    @Override
    public void onWidgetClick(View widget) {
        super.onWidgetClick(widget);
    }
}
