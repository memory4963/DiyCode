package com.bolo4963gmail.mygankio.RecyclerViewClasses;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 10733 on 2017/1/27.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    private TextView titleTv;
    private TextView sortTv;
    private TextView authorNameTv;
    private ImageView authorHeadIv;
    private TextView replyCountTv;

    private TextView releaseTimeTv;

    public TextView getTitleTv() {
        return titleTv;
    }

    public TextView getSortTv() {
        return sortTv;
    }

    public TextView getAuthorNameTv() {
        return authorNameTv;
    }

    public ImageView getAuthorHeadIv() {
        return authorHeadIv;
    }

    public TextView getReplyCountTv() {
        return replyCountTv;
    }

    public TextView getReleaseTimeTv() {
        return releaseTimeTv;
    }

    RecyclerViewHolder(View itemView) {
        super(itemView);

    }



}
