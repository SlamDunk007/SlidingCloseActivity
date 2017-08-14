package com.example.guannan.slidingcloseactivity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by guannan on 2017/7/26.
 */

public class SlidingActivity extends BaseActivity {

    private ArrayList<String> mDatas = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding);
        initData();
        RecyclerView mRecyclerView = findViewById(R.id.recyclerview);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter myAdapter = new MyAdapter(this, mDatas);
        mRecyclerView.setAdapter(myAdapter);
    }

    private void initData() {

        for (int i = 0; i < 100; i++) {
            mDatas.add(i + "");
        }
    }

    @Override
    protected boolean enableRightSliding() {
        return true;
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {

        private final LayoutInflater mInflater;
        private ArrayList<String> mDatas;

        public MyAdapter(Context context, ArrayList<String> datas) {
            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            this.mDatas = datas;
        }

        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new Holder(mInflater.inflate(R.layout.item, null));
        }

        @Override
        public void onBindViewHolder(Holder holder, int position) {

            holder.mTextView.setText(mDatas.get(position));
        }

        @Override
        public int getItemCount() {
            return mDatas == null ? 0 : mDatas.size();
        }

        public class Holder extends RecyclerView.ViewHolder {

            private TextView mTextView;

            public Holder(View itemView) {
                super(itemView);
                this.mTextView = itemView.findViewById(R.id.textview);
            }
        }
    }

}
