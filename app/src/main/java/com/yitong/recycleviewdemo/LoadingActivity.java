package com.yitong.recycleviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.yitong.recycleviewdemo.dialog.LoadingProgressDialog;

public class LoadingActivity extends AppCompatActivity {

    private LoadingProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        init();
    }

    private void init() {
        dialog = new LoadingProgressDialog(this, R.style.CustomProgressDialog, "加载中");
    }

    public void start(View view) {
        if(dialog != null) {
            dialog.show();
        }
    }

    public void stop(View view) {
        if(dialog != null) {
            dialog.dismiss();
        }
    }

}
