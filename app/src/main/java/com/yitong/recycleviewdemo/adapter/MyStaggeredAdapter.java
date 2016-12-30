package com.yitong.recycleviewdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.yitong.recycleviewdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * date：2016/12/29
 * des：
 * Create by suqi
 * Copyright (c) 2016 Shanghai P&C Information Technology Co., Ltd.
 */

public class MyStaggeredAdapter extends BaseRecycleViewAdapter {

    private List<Integer> randomList;

    public MyStaggeredAdapter(Context context, List<String> data) {
        super(context, data);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_recycle_view, parent, false);

        // 生成随机数
        randomList = new ArrayList<>();
        for(int i = 0; i < mData.size(); i++) {
            randomList.add((int) (100 + Math.random() * 300));
        }

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        layoutParams.height = randomList.get(position);
        holder.itemView.setLayoutParams(layoutParams);

        holder.tvTitle.setText(mData.get(position));
    }
}
