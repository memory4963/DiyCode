package com.bolo4963gmail.mygankio.RecyclerViewClasses;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bolo4963gmail.mygankio.ConnectionClasses.OkHttpConnection;
import com.bolo4963gmail.mygankio.R;
import com.bolo4963gmail.mygankio.ThreadPoolProviderClasses.ThreadPoolProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import static android.content.ContentValues.TAG;

/**
 * Created by 10733 on 2016/12/14.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private LayoutInflater mInflater;
    private Context mContext;
    private List<RecyclerViewData> mData;
    private Map<Integer, ImageView> imageViewMap = new HashMap<>();

    private final int SET_HEAD_IMAGE = 42352;
    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SET_HEAD_IMAGE:
                    imageViewMap.get(msg.arg1).setImageBitmap((Bitmap) msg.obj);
                    break;
                default:
                    break;
            }
        }
    };

    @Inject
    public RecyclerViewAdapter(Context context, List<RecyclerViewData> data) {
        this.mContext = context;
        this.mData = data;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_recycler_view, parent, false);
        return new RecyclerViewHolder(view, mContext);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        // TODO: 2017/1/28 设置childView的控件
        holder.titleTv.setText(mData.get(position).titleTvStr);
        holder.sortTv.setText(mData.get(position).sortTvStr);
        holder.authorNameTv.setText(mData.get(position).authorNameTvStr);
        if (!mData.get(position).ImageViewUrl.equals("")) {
            imageViewMap.put(position, holder.authorHeadIv);
            ThreadPoolProvider.getThreadPool()
                    .execute(new HeadImageRunnable(position, mData.get(position).ImageViewUrl));
        }
        holder.replyCountTv.setText(mData.get(position).replyCountTvStr.toString());
        holder.releaseTimeTv.setText(mData.get(position).releaseTimeTvStr);
        if (holder.titleTv.getLineCount() == 3) {
            // TODO: 2017/2/12 超过3行更改字号  未找到方法
            holder.titleTv.setTextSize(12);
            Log.d(TAG, "onBindViewHolder: 改变字号");
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    private class HeadImageRunnable implements java.lang.Runnable {

        int num;
        private String url;

        public HeadImageRunnable(int num, String url) {
            this.num = num;
            this.url = url;
        }

        @Override
        public void run() {
            Log.d(TAG, "run: url:" + url);
            Bitmap headImage = OkHttpConnection.getHeadImage(url);
            Message message = Message.obtain();
            message.what = SET_HEAD_IMAGE;
            message.arg1 = num;
            message.obj = headImage;
            handler.sendMessage(message);
        }
    }
}
