package com.bolo4963gmail.mygankio.RecyclerViewClasses;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bolo4963gmail.mygankio.R;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by 10733 on 2016/12/14.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private LayoutInflater mInflater;
    private Context mContext;
    private List<ChildView> mData;

    @Inject
    public RecyclerViewAdapter(Context context, List<ChildView> data) {
        this.mContext = context;
        this.mData = data;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_recycler_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // TODO: 2017/1/28 设置childView的控件
//        holder.textView.setText("");
    }

    @Override
    public int getItemCount() {
        // TODO: 2017/1/28 长度
        return 10;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
