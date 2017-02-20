package com.bolo4963gmail.mygankio.RecyclerViewClasses;

/**
 * Created by 10733 on 2017/2/9.
 */

public class RecyclerViewData {

    public static final int TYPE_TOPIC = 23465;
    public static final int TYPE_PROJECT = 61244;
    public static final int TYPE_NEWS = 64245;

    public int type;
    public String titleTvStr = "";
    public int titleId = -1;
    public String sortTvStr = "";
    public int sortId = -1;
    public String authorNameTvStr = "";
    public int authorId = -1;
    public String ImageViewUrl = "";
    public Integer replyCountTvStr = 0;
    public String releaseTimeTvStr = "";
    public String projectReadMe = "";
    public String projectTitle = "";
    public String newsUrl = "";

    public RecyclerViewData(int type) {
        this.type = type;
    }
}
