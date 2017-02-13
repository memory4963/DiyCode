package com.bolo4963gmail.mygankio.RecyclerViewClasses;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bolo4963gmail.mygankio.R;

/**
 * Created by 10733 on 2017/1/27.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    public TextView titleTv;
    public String titleUrl;
    public TextView sortTv;
    public String sortUrl;
    public TextView authorNameTv;
    public String authorUrl;
    public ImageView authorHeadIv;
    public TextView replyCountTv;
    public TextView releaseTimeTv;

    RecyclerViewHolder(View itemView, final Context context) {
        super(itemView);
        titleTv = (TextView) itemView.findViewById(R.id.titleTv);
        sortTv = (TextView) itemView.findViewById(R.id.sortTv);
        authorNameTv = (TextView) itemView.findViewById(R.id.authorNameTv);
        authorHeadIv = (ImageView) itemView.findViewById(R.id.authorHeadIv);
        replyCountTv = (TextView) itemView.findViewById(R.id.replyCountTv);
        releaseTimeTv = (TextView) itemView.findViewById(R.id.releaseTimeTv);

        //设置监听器
        sortTv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(context, "分类点击", Toast.LENGTH_SHORT).show();

            }
        });

        authorNameTv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(context, "作者名字点击", Toast.LENGTH_SHORT).show();
            }
        });

        itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(context, "item点击", Toast.LENGTH_SHORT).show();

            }
        });

    }

}
