package com.bolo4963gmail.mygankio.RecyclerViewClasses;

import com.bolo4963gmail.mygankio.GsonClasses.NewsGson;
import com.bolo4963gmail.mygankio.GsonClasses.ProjectsGson;
import com.bolo4963gmail.mygankio.GsonClasses.TopicsGson;

import java.util.List;

/**
 * Created by 10733 on 2017/2/9.
 */

public class RecyclerViewController {

    public static List<RecyclerViewData> setTopicsList(List<RecyclerViewData> list,
                                                   List<TopicsGson> resourseList, int offset) {
        TopicsGson topicsGson;
        for (int i = offset; i < offset + resourseList.size(); i++) {
            RecyclerViewData data = new RecyclerViewData(RecyclerViewData.TYPE_TOPIC);
            topicsGson = resourseList.get(i - offset);
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

    public static List<RecyclerViewData> setNewsList(List<RecyclerViewData> list,
                                                     List<NewsGson> resourseList,
                                                     int offset) {
        NewsGson newsGson;
        for (int i = offset; i < offset + resourseList.size(); i++) {
            RecyclerViewData data = new RecyclerViewData(RecyclerViewData.TYPE_NEWS);
            newsGson = resourseList.get(i - offset);
            data.titleTvStr = newsGson.getTitle();
            data.titleId = newsGson.getId();
            data.sortTvStr = newsGson.getNode_name();
            data.sortId = newsGson.getNode_id();
            data.ImageViewUrl = newsGson.getUser().getAvatar_url();
            data.authorNameTvStr = newsGson.getUser().getLogin();
            data.releaseTimeTvStr =
                    newsGson.getCreated_at().substring(0, 10) + " " + newsGson.getCreated_at()
                            .substring(11, 19);
            data.replyCountTvStr = newsGson.getReplies_count();
            data.newsUrl = newsGson.getAddress();
            list.add(i, data);
        }
        return list;
    }

    public static List<RecyclerViewData> setProjectList(List<RecyclerViewData> list,
                                                        List<ProjectsGson> resourseList,
                                                        int offset) {
        ProjectsGson projectsGson;
        for (int i = offset; i < offset + resourseList.size(); i++) {
            RecyclerViewData data = new RecyclerViewData(RecyclerViewData.TYPE_PROJECT);
            projectsGson = resourseList.get(i - offset);
            data.type = RecyclerViewData.TYPE_PROJECT;
            data.titleTvStr = projectsGson.getName() + " " + projectsGson.getDescription();
            data.titleId = projectsGson.getId();
            data.sortTvStr = projectsGson.getCategory().getName();
            data.sortId = projectsGson.getCategory().getId();
            data.ImageViewUrl = projectsGson.getProject_cover_url();
            data.authorNameTvStr = projectsGson.getSub_category().getName();
            data.releaseTimeTvStr =
                    projectsGson.getLast_updated_at().substring(0, 10) + " " + projectsGson.getLast_updated_at()
                            .substring(11, 19);
            data.replyCountTvStr = projectsGson.getStar();
            data.projectReadMe = projectsGson.getReadme();
            data.projectTitle = projectsGson.getName();
            list.add(i, data);
        }
        return list;
    }

}
