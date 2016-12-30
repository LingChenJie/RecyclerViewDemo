package com.yitong.recycleviewdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.yitong.recycleviewdemo.R;

import java.util.List;

/**
 * date：2016/12/29
 * des：
 * Create by suqi
 * Copyright (c) 2016 Shanghai P&C Information Technology Co., Ltd.
 */

public class MyRecycleViewAdapter extends  BaseRecycleViewAdapter{

    public MyRecycleViewAdapter(Context context, List<String> data){
        super(context, data);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_recycle_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        holder.tvTitle.setText(mData.get(position));
    }

}
