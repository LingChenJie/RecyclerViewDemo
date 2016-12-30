package com.yitong.recycleviewdemo.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yitong.recycleviewdemo.R;
import com.yitong.recycleviewdemo.bean.DataModelTwo;

/**
 * date：2016/12/30
 * des：
 * Create by suqi
 * Copyright (c) 2016 Shanghai P&C Information Technology Co., Ltd.
 */

public class TypeTwoHolder extends TypeBaseViewHolder<DataModelTwo> {

    private ImageView avatar;
    private TextView name;
    private TextView content;

    public TypeTwoHolder(View itemView) {
        super(itemView);
        avatar = (ImageView) itemView.findViewById(R.id.avatar);
        name = (TextView) itemView.findViewById(R.id.name);
        content = (TextView) itemView.findViewById(R.id.content);
    }

    @Override
    public void bindHolder(DataModelTwo dataModel) {
        avatar.setBackgroundResource(dataModel.avatarColor);
        name.setText(dataModel.name);
        content.setText(dataModel.content);
    }

}
