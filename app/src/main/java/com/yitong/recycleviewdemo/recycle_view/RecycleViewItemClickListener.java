package com.yitong.recycleviewdemo.recycle_view;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * date：2016/12/29
 * des：
 * Create by suqi
 * Copyright (c) 2016 Shanghai P&C Information Technology Co., Ltd.
 */

public class RecycleViewItemClickListener implements RecyclerView.OnItemTouchListener {

    private OnItemClickListener mOnItemClickListener;
    private GestureDetectorCompat mGestureDetector;

    public RecycleViewItemClickListener(Context context, final RecyclerView recyclerView, OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;

        mGestureDetector = new GestureDetectorCompat(context, new GestureDetector.SimpleOnGestureListener() {

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                View childView = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if (childView != null) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemLongClick(childView, recyclerView.getChildLayoutPosition(childView));
                    }
                }
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                View childView = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if (childView != null) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemLongClick(childView, recyclerView.getChildLayoutPosition(childView));
                    }
                }
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        mGestureDetector.onTouchEvent(e);
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }
}
