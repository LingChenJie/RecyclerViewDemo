package com.yitong.recycleviewdemo;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.yitong.recycleviewdemo.adapter.BaseRecycleViewAdapter;
import com.yitong.recycleviewdemo.adapter.MyStaggeredAdapter;
import com.yitong.recycleviewdemo.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class StaggeredActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private MyStaggeredAdapter adapter;
    private List<String> mData;

    @Override
    public int getLayoutId() {
        return R.layout.activity_straggered_actvity;
    }

    @Override
    public void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.rcv_content);
    }

    @Override
    public void initAction() {
        mData = new ArrayList<>();
        adapter = new MyStaggeredAdapter(this, mData);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));

        // 点击事件测试
        adapter.setOnItemClickListener(new BaseRecycleViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(StaggeredActivity.this, "onItemClick position ==> " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(StaggeredActivity.this, "onItemLongClick position ==> " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void initData() {
        for (int i = 'A'; i < 'z'; i++) {
            mData.add("" + (char) i);
        }
        adapter.notifyDataSetChanged();
    }

}
