package com.yitong.recycleviewdemo.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * date：2016/12/30
 * des：
 * Create by suqi
 * Copyright (c) 2016 Shanghai P&C Information Technology Co., Ltd.
 */

public abstract class TypeBaseViewHolder<T> extends RecyclerView.ViewHolder {

    public TypeBaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindHolder(T dataModel);
}
