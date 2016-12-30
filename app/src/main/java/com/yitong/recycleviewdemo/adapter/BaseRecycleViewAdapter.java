package com.yitong.recycleviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.yitong.recycleviewdemo.R;

import java.util.List;

/**
 * date：2016/12/29
 * des：
 * Create by suqi
 * Copyright (c) 2016 Shanghai P&C Information Technology Co., Ltd.
 */

public abstract class BaseRecycleViewAdapter extends RecyclerView.Adapter<BaseRecycleViewAdapter.ViewHolder>  {

    protected Context mContext;
    protected LayoutInflater layoutInflater;
    protected List<String> mData;

    public BaseRecycleViewAdapter(Context context, List<String> data){
        mContext = context;
        layoutInflater = LayoutInflater.from(context);
        mData = data;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.item_title);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        setOnItemClick(holder, position);
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    // 设置点击事件的监听
    private OnItemClickListener mItemClickListener;

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    private void setOnItemClick(final RecyclerView.ViewHolder holder, final int position) {
        if(mItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItemClickListener.onItemClick(holder.itemView, holder.getLayoutPosition());
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mItemClickListener.onItemLongClick(holder.itemView, holder.getLayoutPosition());
                    return false;
                }
            });
        }
    }

    /**
     * 添加position
     * @param position
     */
    public void add(int position) {
        mData.add(position, "insert One");
        notifyItemInserted(position);
    }

    /**
     * 删除position
     * @param position
     */
    public void remove(int position) {
        mData.remove(position);
        notifyItemRemoved(position);
    }
}
