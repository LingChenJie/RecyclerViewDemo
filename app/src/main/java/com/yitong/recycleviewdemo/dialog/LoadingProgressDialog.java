package com.yitong.recycleviewdemo.dialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.yitong.recycleviewdemo.R;

/**
 * date：2016/12/28
 * des：
 * Create by suqi
 * Copyright (c) 2016 Shanghai P&C Information Technology Co., Ltd.
 */

public class LoadingProgressDialog extends ProgressDialog {

    private AnimationDrawable mAnimation;
    private Context mContext;
    private ImageView mImageView;
    private String mLoadingTip;
    private TextView mLoadingTv;

    public LoadingProgressDialog(Context context, String content) {
        super(context);
        this.mContext = context;
        this.mLoadingTip = content;
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public LoadingProgressDialog(Context context, int theme, String content) {
        super(context, theme);
        this.mContext = context;
        this.mLoadingTip = content;
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        mAnimation = (AnimationDrawable) mImageView.getDrawable();
        mImageView.post(new Runnable() {
            @Override
            public void run() {
                mAnimation.start();

            }
        });
        if (mLoadingTip.equals("")) {
            mLoadingTv.setText("加载中...");
        } else {
            mLoadingTv.setText(mLoadingTip);
        }

    }

    public void setContent(String str) {
        mLoadingTv.setText(str);
    }

    private void initView() {
        setContentView(R.layout.progress_dialog);
        mLoadingTv = (TextView) findViewById(R.id.loadingTv);
        mImageView = (ImageView) findViewById(R.id.loadingIv);
    }

}
