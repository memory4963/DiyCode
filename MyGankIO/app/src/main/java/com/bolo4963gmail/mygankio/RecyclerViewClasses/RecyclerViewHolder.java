package com.bolo4963gmail.mygankio.RecyclerViewClasses;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bolo4963gmail.mygankio.ContentActivity;
import com.bolo4963gmail.mygankio.R;

/**
 * Created by 10733 on 2017/1/27.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    public int type;
    public TextView titleTv;
    public int titleId;
    public TextView sortTv;
    public int sortId;
    public TextView authorNameTv;
    public int authorId;
    public ImageView authorHeadIv;
    public TextView replyTv;
    public TextView replyCountTv;
    public TextView releaseTimeTv;
    public String projectReadMe;
    public String newsUrl;
    public String projectTitle;

    RecyclerViewHolder(View itemView, final Context context) {
        super(itemView);
        titleTv = (TextView) itemView.findViewById(R.id.titleTv);
        sortTv = (TextView) itemView.findViewById(R.id.sortTv);
        authorNameTv = (TextView) itemView.findViewById(R.id.authorNameTv);
        authorHeadIv = (ImageView) itemView.findViewById(R.id.authorHeadIv);
        replyTv = (TextView) itemView.findViewById(R.id.replyTv);
        replyCountTv = (TextView) itemView.findViewById(R.id.replyCountTv);
        releaseTimeTv = (TextView) itemView.findViewById(R.id.releaseTimeTv);
        // TODO: 2017/2/17 设置分类点击和作者点击
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
                Intent intent = new Intent(context, ContentActivity.class);
                intent.putExtra("sortId", sortId);
                intent.putExtra("authorId", authorId);
                intent.putExtra("type", type);
                if (type == RecyclerViewData.TYPE_TOPIC) {
                    intent.putExtra("title", titleTv.getText());
                    intent.putExtra("topicId", titleId);
                } else if (type == RecyclerViewData.TYPE_NEWS) {
                    intent.putExtra("title", titleTv.getText());
                    intent.putExtra("newsUrl", newsUrl);
                } else if (type == RecyclerViewData.TYPE_PROJECT) {
                    intent.putExtra("title", projectTitle);
                    intent.putExtra("readme", projectReadMe);
                }

                context.startActivity(intent);
            }
        });

    }

}
