package com.bolo4963gmail.mygankio.RecyclerViewClasses;

import com.bolo4963gmail.mygankio.GsonClasses.TopicsGson;

import java.util.List;

/**
 * Created by 10733 on 2017/2/9.
 */

public class RecyclerViewController {

    public static List<RecyclerViewData> setTopicsList(List<RecyclerViewData> list,
                                                   List<TopicsGson> resourseList, int offset) {
        // TODO: 2017/2/9 编写List转换
        for (int i = offset; i < offset + resourseList.size(); i++) {
            TopicsGson topicsGson = resourseList.get(i - offset);
            RecyclerViewData data = new RecyclerViewData();
            data.titleTvStr = topicsGson.getTitle();
            data.titleId = topicsGson.getId();
            data.sortTvStr = topicsGson.getNode_name();
            data.sortId = topicsGson.getNode_id();
            data.ImageViewUrl = topicsGson.getUser().getAvatar_url();
            data.authorNameTvStr = topicsGson.getUser().getLogin();
            data.authorId = topicsGson.getUser().getId();
            data.releaseTimeTvStr =
                    topicsGson.getCreated_at().substring(0, 10) + " " + topicsGson.getCreated_at()
                            .substring(11, 19);
            data.replyCountTvStr = topicsGson.getReplies_count();
            list.add(i, data);
        }
        return list;
    }

}
