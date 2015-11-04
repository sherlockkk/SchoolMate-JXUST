package com.alpha.schoolmate.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.alpha.schoolmate.R;
import com.lody.welike.ui.WelikeActivity;

/**
 * Created by SongJian on 2015/11/4 0004.
 */
public class ListActivity extends Activity {
    private TableLayout mTableLayout;
    private Button mButton;
    private int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initWidget();
    }

    public void initWidget() {
        mTableLayout = (TableLayout) findViewById(R.id.tableLayout);
        mButton = (Button) findViewById(R.id.btnAdd);
        mButton.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            addRow();
            num++;
        }
    };

    private void addRow() {
        TableRow tableRow = new TableRow(this);
        TextView textView = new TextView(this);
        Button button = new Button(this);

        textView.setText(String.valueOf(num));
        button.setText("删除");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TableRow tableRow = (TableRow) v.getParent();
                mTableLayout.removeView(tableRow);
            }
        });
        tableRow.addView(textView);
        tableRow.addView(button);
        mTableLayout.addView(tableRow);
    }
}
