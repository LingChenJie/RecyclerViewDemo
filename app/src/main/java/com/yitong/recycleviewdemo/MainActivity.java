package com.yitong.recycleviewdemo;

import android.content.Intent;
import android.view.View;

import com.yitong.recycleviewdemo.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initAction() {

    }

    @Override
    public void initData() {

    }

    public void click(View view){
        Intent intent = null;
        switch (view.getId()) {

            case R.id.bt_loading:
                intent = new Intent(this, LoadingActivity.class);
                break;

            case R.id.bt_recycleview:
                intent = new Intent(this, RecycleViewActivity.class);
                break;

            case R.id.bt_complex_recycleview:
                intent = new Intent(this, ComplexRecycleViewActivity.class);
                break;
        }
        startActivity(intent);

    }
}
