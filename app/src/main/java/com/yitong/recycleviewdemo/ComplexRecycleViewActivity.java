package com.yitong.recycleviewdemo;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yitong.recycleviewdemo.adapter.ComplexRecyclerViewAdapter;
import com.yitong.recycleviewdemo.base.BaseActivity;
import com.yitong.recycleviewdemo.bean.DataModel;
import com.yitong.recycleviewdemo.bean.DataModelOne;
import com.yitong.recycleviewdemo.bean.DataModelThree;
import com.yitong.recycleviewdemo.bean.DataModelTwo;

import java.util.ArrayList;
import java.util.List;

public class ComplexRecycleViewActivity extends BaseActivity {

    private RecyclerView recyclerView;

    private ComplexRecyclerViewAdapter adapter;

    private List<DataModel> modelList;

    private int[] colors = new int[]{android.R.color.holo_blue_bright, android.R.color.holo_orange_dark, android.R.color.holo_purple};

    @Override
    public int getLayoutId() {
        return R.layout.activity_complex_recycle_view_actvity;
    }

    @Override
    public void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.rcv_content);
        //        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int type = recyclerView.getAdapter().getItemViewType(position);
                if (type == ComplexRecyclerViewAdapter.TYPE_ONE || type == ComplexRecyclerViewAdapter.TYPE_TWO) {
                    return 1;
                }
                return gridLayoutManager.getSpanCount();
            }
        });
        // 添加分割线
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();
                int spanSize = layoutParams.getSpanSize();
                int spanIndex = layoutParams.getSpanIndex();
                outRect.top = 20;
                if (spanSize != gridLayoutManager.getSpanCount()) {
                    if (spanIndex == 0) {// 第一个
                        outRect.right = 10;
                    } else {
                        outRect.left = 10;
                    }
                }
                //super.getItemOffsets(outRect, view, parent, state);
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    @Override
    public void initAction() {
        adapter = new ComplexRecyclerViewAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void initData() {
        //        modelList = new ArrayList<>();
        //        for (int i = 0; i < 30; i++) {
        //            int type;
        //            if (i < 5 || (i > 15 && i < 20)) {
        //                type = 1;
        //            } else if (i < 10 || i > 25) {
        //                type = 2;
        //            } else {
        //                type = 3;
        //            }
        //
        //            DataModel dataModel = new DataModel();
        //            dataModel.type = type;
        //            dataModel.avatarColor = colors[type - 1];
        //            dataModel.name = "name : " + type;
        //            dataModel.content = "content : " + type;
        //            dataModel.contentColor = colors[(type + 1) % 3];
        //            modelList.add(dataModel);
        //        }
        //        adapter.addData(modelList);
        //        adapter.notifyDataSetChanged();

        List<DataModelOne> list1 = new ArrayList<>();
        List<DataModelTwo> list2 = new ArrayList<>();
        List<DataModelThree> list3 = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            DataModelOne dataModelOne = new DataModelOne();
            dataModelOne.type = ComplexRecyclerViewAdapter.TYPE_ONE;
            dataModelOne.avatarColor = colors[(int) (Math.random() * 3)];
            dataModelOne.name = "name " + i;
            list1.add(dataModelOne);
        }
        for(int i = 0; i < 10; i++) {
            DataModelTwo dataModelTwo = new DataModelTwo();
            dataModelTwo.type = ComplexRecyclerViewAdapter.TYPE_TWO;
            dataModelTwo.avatarColor = colors[(int) (Math.random() * 3)];
            dataModelTwo.name = "name " + i;
            dataModelTwo.content = "content " + i;
            list2.add(dataModelTwo);
        }
        for(int i = 0; i < 10; i++) {
            DataModelThree dataModelThree = new DataModelThree();
            dataModelThree.type = 1;
            dataModelThree.avatarColor = colors[(int) (Math.random() * 3)];
            dataModelThree.name = "name " + i;
            dataModelThree.content = "content " + i;
            dataModelThree.contentColor = colors[(int) (Math.random() * 3)];
            list3.add(dataModelThree);
        }
        adapter.addList(list1, list2, list3);
        adapter.notifyDataSetChanged();
    }

}
