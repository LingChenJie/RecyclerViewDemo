package com.yitong.recycleviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.yitong.recycleviewdemo.R;
import com.yitong.recycleviewdemo.bean.DataModelOne;
import com.yitong.recycleviewdemo.bean.DataModelThree;
import com.yitong.recycleviewdemo.bean.DataModelTwo;
import com.yitong.recycleviewdemo.holder.TypeOneHolder;
import com.yitong.recycleviewdemo.holder.TypeThreeHolder;
import com.yitong.recycleviewdemo.holder.TypeTwoHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * date：2016/12/30
 * des：
 * Create by suqi
 * Copyright (c) 2016 Shanghai P&C Information Technology Co., Ltd.
 */

public class ComplexRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    // 定义三种类型，类型更改在这里调整
    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;
    public static final int TYPE_THREE = 3;

    private Context mContext;
    private LayoutInflater layoutInflater;

    public ComplexRecyclerViewAdapter(Context context) {
        mContext = context;
        layoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_ONE:
                return new TypeOneHolder(layoutInflater.inflate(R.layout.item_type_one, parent, false));

            case TYPE_TWO:
                return new TypeTwoHolder(layoutInflater.inflate(R.layout.item_type_two, parent, false));

            case TYPE_THREE:
                return new TypeThreeHolder(layoutInflater.inflate(R.layout.item_type_three, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //  ((TypeBaseViewHolder) holder).bindHolder(dataModels.get(position));
        int viewType = getItemViewType(position);
        int realPosition = position - mPositions.get(viewType);
        switch (getItemViewType(position)) {
            case TYPE_ONE:
                ((TypeOneHolder) holder).bindHolder(dataModelOnes.get(realPosition));
                break;

            case TYPE_TWO:
                ((TypeTwoHolder) holder).bindHolder(dataModelTwos.get(realPosition));
                break;

            case TYPE_THREE:
                ((TypeThreeHolder) holder).bindHolder(dataModelThrees.get(realPosition));
                break;
        }
    }

    //    雏形，只有一种类型时使用
    //    private List<DataModel> dataModels = new ArrayList<>();

    //    public void addData(List<DataModel> dataModels) {
    //        this.dataModels.addAll(dataModels);
    //    }

    // 有多种类型
    private List<Integer> types;// 存储所有的types类型，便于getItemViewType()获取
    private Map<Integer, Integer> mPositions;// 存储每个type含有的item数量

    private List<DataModelOne> dataModelOnes;// 第一种类型的数据集合
    private List<DataModelTwo> dataModelTwos;// 第二种类型的数据集合
    private List<DataModelThree> dataModelThrees;// 第三种类型的数据集合

    public void addList(List<DataModelOne> dataModelOnes, List<DataModelTwo> dataModelTwos, List<DataModelThree> dataModelThrees) {
        types = new ArrayList<>();
        mPositions = new HashMap<>();

        addListByType(TYPE_ONE, dataModelOnes);
        addListByType(TYPE_TWO, dataModelTwos);
        addListByType(TYPE_THREE, dataModelThrees);

        this.dataModelOnes = dataModelOnes;
        this.dataModelTwos = dataModelTwos;
        this.dataModelThrees = dataModelThrees;
    }

    private void addListByType(int type, List list) {
        mPositions.put(type, types.size());
        for (int i = 0, len = list.size(); i < len; i++) {
            types.add(type);
        }
    }

    @Override
    public int getItemCount() {
        //  return dataModels.size();
        return types.size();
    }

    @Override
    public int getItemViewType(int position) {
        //   return dataModels.get(position).type;
        return types.get(position);
    }
}
