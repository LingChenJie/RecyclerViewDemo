package com.yitong.recycleviewdemo.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yitong.recycleviewdemo.R;
import com.yitong.recycleviewdemo.bean.DataModelOne;

/**
 * date：2016/12/30
 * des：
 * Create by suqi
 * Copyright (c) 2016 Shanghai P&C Information Technology Co., Ltd.
 */

public class TypeOneHolder extends TypeBaseViewHolder<DataModelOne> {

    private ImageView avatar;
    private TextView name;

    public TypeOneHolder(View itemView) {
        super(itemView);
        avatar = (ImageView) itemView.findViewById(R.id.avatar);
        name = (TextView) itemView.findViewById(R.id.name);
    }

    @Override
    public void bindHolder(DataModelOne dataModel) {
        avatar.setBackgroundResource(dataModel.avatarColor);
        name.setText(dataModel.name);
    }

}
