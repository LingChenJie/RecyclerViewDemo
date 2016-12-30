package com.yitong.recycleviewdemo;

import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.yitong.recycleviewdemo.adapter.MyRecycleViewAdapter;
import com.yitong.recycleviewdemo.base.BaseActivity;
import com.yitong.recycleviewdemo.recycle_view.RecycleViewItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private List<String> mDatas;
    private MyRecycleViewAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_recycle_view;
    }

    @Override
    public void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDatas = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.rcv_content);
    }

    @Override
    public void initAction() {
        adapter = new MyRecycleViewAdapter(this, mDatas);
        recyclerView.setAdapter(adapter);

        // 设置布局管理器
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        // 设置添加删除动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // 设置分割线
        //        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

        // 点击事件测试
        //        adapter.setOnItemClickListener(new BaseRecycleViewAdapter.OnItemClickListener() {
        //            @Override
        //            public void onItemClick(View view, int position) {
        //                Toast.makeText(RecycleViewActivity.this, "onItemClick position ==> " + position, Toast.LENGTH_SHORT).show();
        //            }
        //
        //            @Override
        //            public void onItemLongClick(View view, int position) {
        //                Toast.makeText(RecycleViewActivity.this, "onItemLongClick position ==> " + position, Toast.LENGTH_SHORT).show();
        //            }
        //        });
        recyclerView.addOnItemTouchListener(new RecycleViewItemClickListener(this, recyclerView, new RecycleViewItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(RecycleViewActivity.this, "onItemClick position ==> " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(RecycleViewActivity.this, "onItemLongClick position ==> " + position, Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public void initData() {
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add((char) i + "");
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.recycle_view_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                adapter.add(1);
                break;

            case R.id.action_delete:
                adapter.remove(1);
                break;

            case R.id.action_listview:
                recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                break;

            case R.id.action_hor_listview:
                recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
                break;

            case R.id.action_gridview:
                recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
                break;

            case R.id.action_hor_gridview:
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.HORIZONTAL));
                break;

            case R.id.action_staggered_gridView:
                Intent intent = new Intent(this, StaggeredActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
