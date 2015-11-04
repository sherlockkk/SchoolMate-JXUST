package com.alpha.schoolmate.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.alpha.schoolmate.R;
import com.alpha.schoolmate.util.Config;
import com.alpha.schoolmate.util.HttpUtils;
import com.lody.welike.WelikeHttp;
import com.lody.welike.http.HttpParams;
import com.lody.welike.http.HttpRequest;
import com.lody.welike.http.callback.HttpCallback;
import com.lody.welike.ui.WelikeToast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity {

    private Button mButton_Query;
    private Spinner mSpinner;
    private EditText mEditText_name;
    private EditText mEditText_major;
    private EditText mEditText_clazz;
    private EditText mEditText_company;
    private EditText mEditText_address;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        init();
    }

	/*
     * 初始化
	 */

    private void init() {
        mButton_Query = (Button) findViewById(R.id.submit);
        mSpinner = (Spinner) findViewById(R.id.spinner);
        mEditText_name = (EditText) findViewById(R.id.name);
        mEditText_major = (EditText) findViewById(R.id.major);
        mEditText_clazz = (EditText) findViewById(R.id.clazz);
        mEditText_company = (EditText) findViewById(R.id.company);
        mEditText_address = (EditText) findViewById(R.id.address);

        mButton_Query.setOnClickListener(onClickListener);
        mSpinner.setOnItemSelectedListener(onItemSelectedListener);
        String[] mItem = getResources().getStringArray(R.array.selector_years);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, mItem);
        mSpinner.setAdapter(spinnerAdapter);
    }

    OnClickListener onClickListener;

    {
        onClickListener = new OnClickListener() {

            @Override
            public void onClick(View v) {
                String name = null;
                String major = null;
                String clazz = null;
                String company = null;
                String address = null;
                String years = null;
                switch (v.getId()) {
                    case R.id.submit:
                        name = mEditText_name.getText().toString();
                        major = mEditText_major.getText().toString();
                        clazz = mEditText_clazz.getText().toString();
                        company = mEditText_company.getText().toString();
                        address = mEditText_address.getText().toString();
                        years = mSpinner.getSelectedItem().toString();
                        toActivity();
                        break;
                }
                Map<String, String> params = new HashMap<String, String>();
                params.put("", name);
                params.put("", major);
                params.put("", clazz);
                params.put("", years);
                params.put("", company);
                params.put("", address);
                sendPost(params);
                System.out.println(name + " " + major + " " + clazz + " " + company + " " + address + " " + years);

            }
        };
    }

    private void toActivity() {
        Intent intent = new Intent(MainActivity.this, ListActivity.class);
        startActivity(intent);
    }

    private void sendPost(Map<String, String> params) {
        // Map<String ,String>params = new HashMap<String,String>();
        String urlPath = Config.URLPATH;
        HttpUtils.submitPostData(urlPath, params, "utf-8");
    }

    OnItemSelectedListener onItemSelectedListener = new OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view,
                                   int position, long id) {
            String str = parent.getItemAtPosition(position).toString();
            WelikeToast.toast("您选择了" + str + "年");
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            // TODO Auto-generated method stub

        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
