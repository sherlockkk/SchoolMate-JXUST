package com.alpha.schoolmate.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.alpha.schoolmate.R;
import com.lody.welike.ui.WelikeToast;

public class MainActivity extends Activity {

    private Button btn_Query;
    private Spinner btn_Spinner;

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
        btn_Query = (Button) findViewById(R.id.submit);
        btn_Spinner = (Spinner) findViewById(R.id.spinner);
        btn_Query.setOnClickListener(onClickListener);
        btn_Spinner.setOnItemSelectedListener(onItemSelectedListener);
        String[] mItem = getResources().getStringArray(R.array.selector_years);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, mItem);
        btn_Spinner.setAdapter(spinnerAdapter);
    }

    OnClickListener onClickListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            System.out.println(">>>>>>>>>>>>>>>>>");
        }
    };

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
