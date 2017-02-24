package com.bolo4963gmail.mygankio.ConnectionClasses;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;

import com.bolo4963gmail.mygankio.AcitivityClasses.ContentActivity;
import com.bolo4963gmail.mygankio.AcitivityClasses.MainActivity;
import com.bolo4963gmail.mygankio.GsonClasses.LoginGson;
import com.bolo4963gmail.mygankio.GsonClasses.NewsGson;
import com.bolo4963gmail.mygankio.GsonClasses.ProjectsGson;
import com.bolo4963gmail.mygankio.GsonClasses.TopicBodyGson;
import com.bolo4963gmail.mygankio.GsonClasses.TopicsGson;
import com.bolo4963gmail.mygankio.GsonClasses.UserInfoGson;
import com.bolo4963gmail.mygankio.SharedPreferencesClasses.PreferencesController;
import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 10733 on 2017/1/28.
 */

public class OkHttpConnection {

    private static Handler mainHandler;

    private static Handler contentHandler;

    private static final String TAG = "OkHttpConnection";

    private static String token = null;
    private static String refresh_token = null;

    private static final String AUTHORIZATION = "Authorization";

    /**
     * URL 基本路径
     */
    private static final String BASE_URL = "https://diycode.cc/api/v3";//any

    /**
     * 选取Topics
     */
    public static final String TOPICS_LAST_ACTIVED = "last_actived";
    public static final String TOPICS_RECENT = "recent";
    public static final String TOPICS_NO_REPLY = "no_reply";
    public static final String TOPICS_POPULAR = "popular";
    public static final String TOPICS_EXCELLENT = "excellent";

    private static OkHttpClient client = new OkHttpClient();

    /**
     * 登录
     *
     * @return nullable
     */
    public static Map<String, String> login(String account, String password) {
        try {
            Headers headers =
                    new Headers.Builder().add("content-type", "application/x-www-form-urlencoded")
                            .add("Host", "www.diycode.cc")
                            .build();
            RequestBody requestBody = new FormEncodingBuilder().add("client_id", "e5f8ed12")
                    .add("client_secret",
                         "69ad01192f1b217e1cd948500b4ea03db72cefdcec05814d4fddd15b27445496")
                    .add("grant_type", "password")
                    .add("password", password)
                    .add("username", account)
                    .build();
            Request request = new Request.Builder().url("https://www.diycode.cc/oauth/token")
                    .headers(headers)
                    .post(requestBody)
                    .build();
            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();
            LoginGson loginGson = new Gson().fromJson(responseBody, LoginGson.class);

            token = loginGson.getAccess_token();
            refresh_token = loginGson.getRefresh_token();

            //存储
            PreferencesController.setPreferences(PreferencesController.TOKEN, token);
            PreferencesController.setPreferences(PreferencesController.REFRESH_TOKEN,
                                                 refresh_token);

            Map<String, String> map = new HashMap<>();
            map.put(PreferencesController.TOKEN, token);
            map.put(PreferencesController.REFRESH_TOKEN, refresh_token);
            return map;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 通过refresh_token获取新的token
     *
     * @return 返回装有token和refresh_token的map，如果refresh_token为空抛出错误，如果网络连接出错返回Null
     */
    public static Map<String, String> refreshToken() {
        if (refresh_token == null) {
            throw new RuntimeException(
                    "refresh_token为空，先初始化。(refresh_token is null, please initial refresh_token first.)");
        }
        try {
            Headers headers =
                    new Headers.Builder().add("content-type", "application/x-www-form-urlencoded")
                            .add("Host", "www.diycode.cc")
                            .build();
            RequestBody requestBody = new FormEncodingBuilder().add("client_id", "e5f8ed12")
                    .add("client_secret",
                         "69ad01192f1b217e1cd948500b4ea03db72cefdcec05814d4fddd15b27445496")
                    .add("grant_type", "refresh_token")
                    .add("refresh_token", refresh_token)
                    .build();
            Request request = new Request.Builder().url("https://www.diycode.cc/oauth/token")
                    .headers(headers)
                    .post(requestBody)
                    .build();
            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();
            LoginGson loginGson = new Gson().fromJson(responseBody, LoginGson.class);

            token = loginGson.getAccess_token();
            refresh_token = loginGson.getRefresh_token();

            //存储
            PreferencesController.setPreferences(PreferencesController.TOKEN, token);
            PreferencesController.setPreferences(PreferencesController.REFRESH_TOKEN,
                                                 refresh_token);

            Map<String, String> map = new HashMap<>();
            map.put(PreferencesController.TOKEN, token);
            map.put(PreferencesController.REFRESH_TOKEN, refresh_token);
            return map;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取当前登录用户信息
     */
    public static void getUserInfo() {
        if (token == null) {
            throw new RuntimeException("先登录并初始化token和refresh_token再调用");
        }
        Headers headers = new Headers.Builder().add("Authorization", "Bearer " + token).build();
        Request request = new Request.Builder().url(BASE_URL + "/users/me.json")
                .get()
                .headers(headers)
                .build();
        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Request request, IOException e) {
                Message message = Message.obtain();
                message.what = MainActivity.GET_USER_INFO_FAILED;
                mainHandler.sendMessage(message);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                UserInfoGson userInfo =
                        new Gson().fromJson(response.body().string(), UserInfoGson.class);
                Bundle bundle = new Bundle();
                bundle.putInt("userId", userInfo.getId());
                bundle.putString("userLogin", userInfo.getLogin());
                bundle.putString("userEmail", userInfo.getEmail());
                getHeadImageAsy(userInfo.getAvatar_url());
                Message message = Message.obtain();
                message.what = MainActivity.GOT_USER_INFO;
                message.setData(bundle);
                mainHandler.sendMessage(message);
            }
        });
    }

    /**
     * 初始化程序，通知服务器 “我还活着”
     * "未登录不要调用"
     */
    public static void initializeApp() {
        try {
            Request request = new Request.Builder().url(
                    BASE_URL + "/devices.json" + "?platform=android&token=" + token)
                    .post(null)
                    .header(AUTHORIZATION, "Bearer " + token)
                    .header("Host", "diycode.cc")
                    .build();
            client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取topics
     *
     * @param flag    从5个名称以TOPICS开头的String中选取
     * @param node_id 选取接收的topics的类别
     * @param offset  请求位置开始数，从0开始
     */
    public static void getTopics(@Nullable String flag, int node_id, int offset) {
        if (flag == null) {
            flag = TOPICS_LAST_ACTIVED;
        }

        final Headers headers = new Headers.Builder().add("Host", "diycode.cc").build();
        Request request = new Request.Builder().url(
                BASE_URL + "/topics.json" + "?type=" + flag + "&node_id=" + node_id + "&offset="
                        + offset).headers(headers).get().build();
        ListCallBack<TopicsGson> callback =
                new ListCallBack<>(offset, MainActivity.GET_TOPICS_FAILED, MainActivity.GOT_TOPICS,
                                   TopicsGson[].class);
        client.newCall(request).enqueue(callback);
    }

    /**
     * 获取topics
     *
     * @param flag 从5个名称以TOPICS开头的String中选取
     */
    public static void getTopics(@Nullable String flag, int offset) {
        if (flag == null) {
            flag = TOPICS_LAST_ACTIVED;
        }

        Headers headers = new Headers.Builder().add("Host", "diycode.cc").build();
        Request request = new Request.Builder().url(
                BASE_URL + "/topics.json" + "?type=" + flag + "&offset=" + offset)
                .headers(headers)
                .get()
                .build();
        ListCallBack<TopicsGson> callback =
                new ListCallBack<>(offset, MainActivity.GET_TOPICS_FAILED, MainActivity.GOT_TOPICS,
                                   TopicsGson[].class);
        client.newCall(request).enqueue(callback);
    }

    /**
     * 获取projects
     *
     * @param node_id 选取接收的projects的类别
     * @param offset  请求位置开始数，从0开始
     */
    public static void getProjects(int node_id, int offset) {
        Headers headers = new Headers.Builder().add("Host", "diycode.cc").build();
        Request request = new Request.Builder().url(
                BASE_URL + "/projects.json" + "?node_id=" + node_id + "&offset=" + offset)
                .headers(headers)
                .get()
                .build();
        ListCallBack<ProjectsGson> callback =
                new ListCallBack<>(offset, MainActivity.GET_PROJECTS_FAILED,
                                   MainActivity.GOT_PROJECTS, ProjectsGson[].class);
        client.newCall(request).enqueue(callback);
    }

    /**
     * 获取projects
     *
     * @param offset 请求位置开始数，从0开始
     */
    public static void getProjects(int offset) {
        Headers headers = new Headers.Builder().add("Host", "diycode.cc").build();
        Request request =
                new Request.Builder().url(BASE_URL + "/projects.json" + "?offset=" + offset)
                        .headers(headers)
                        .get()
                        .build();
        ListCallBack<ProjectsGson> callback =
                new ListCallBack<>(offset, MainActivity.GET_PROJECTS_FAILED,
                                   MainActivity.GOT_PROJECTS, ProjectsGson[].class);
        client.newCall(request).enqueue(callback);
    }

    /**
     * 获取news
     *
     * @param node_id 选取接收的news的类别
     * @param offset  请求位置开始数，从0开始
     */
    public static void getNews(int node_id, int offset) {
        Headers headers = new Headers.Builder().add("Host", "diycode.cc").build();
        Request request = new Request.Builder().url(
                BASE_URL + "/news.json" + "?node_id=" + node_id + "&offset=" + offset)
                .headers(headers)
                .get()
                .build();
        ListCallBack<NewsGson> callback =
                new ListCallBack<>(offset, MainActivity.GET_NEWS_FAILED, MainActivity.GOT_NEWS,
                                   NewsGson[].class);
        client.newCall(request).enqueue(callback);
    }

    /**
     * 获取news
     *
     * @param offset 请求位置开始数，从0开始
     */
    public static void getNews(int offset) {
        Headers headers = new Headers.Builder().add("Host", "diycode.cc").build();
        Request request = new Request.Builder().url(BASE_URL + "/news.json" + "?offset=" + offset)
                .headers(headers)
                .get()
                .build();
        ListCallBack<NewsGson> callback =
                new ListCallBack<>(offset, MainActivity.GET_NEWS_FAILED, MainActivity.GOT_NEWS,
                                   NewsGson[].class);
        client.newCall(request).enqueue(callback);
    }

    /**
     * 同步方法
     *
     * @param url 取得image的地址
     */
    public static Bitmap getHeadImage(String url) {
        Request request = new Request.Builder().url(url).get().build();
        try {
            Response response = client.newCall(request).execute();
            InputStream in = response.body().byteStream();
            return BitmapFactory.decodeStream(in);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void getHeadImageAsy(String url) {
        Request request = new Request.Builder().url(url).get().build();
        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                InputStream in = response.body().byteStream();
                Message message = Message.obtain();
                message.obj = BitmapFactory.decodeStream(in);
                message.what = MainActivity.GOT_USER_HEAD_IMAGE;
                mainHandler.sendMessage(message);
            }
        });
    }

    public static void setRefresh_token(String refresh_token) {
        OkHttpConnection.refresh_token = refresh_token;
    }

    public static void setToken(String token) {
        OkHttpConnection.token = token;
    }

    public static void setMainHandler(Handler mainHandler) {
        OkHttpConnection.mainHandler = mainHandler;
    }

    public static void setContentHandler(Handler contentHandler) {
        OkHttpConnection.contentHandler = contentHandler;
    }

    private static class ListCallBack<T> implements Callback {

        private int offset;
        private int failure;
        private int success;
        private Class<T[]> clazz;

        public ListCallBack(int offset, int failure, int success, Class<T[]> clazz) {
            this.offset = offset;
            this.failure = failure;
            this.success = success;
            this.clazz = clazz;
        }

        @Override
        public void onFailure(Request request, IOException e) {
            if (mainHandler != null) {
                Message message = Message.obtain(mainHandler);
                message.what = failure;
                mainHandler.sendMessage(message);
            }
        }

        @Override
        public void onResponse(Response response) throws IOException {
            String responseBody = response.body().string();
            if (mainHandler != null) {
                Message message = Message.obtain(mainHandler);
                message.what = success;
                Bundle bundle = new Bundle();
                bundle.putInt("offset", offset);
                message.setData(bundle);
                T[] arr = new Gson().fromJson(responseBody, clazz);
                message.obj = Arrays.asList(arr);
                mainHandler.sendMessage(message);
            }
        }
    }

    /**
     * 获取对应id的topic 调用前先设置contentHandler
     *
     * @param id 对应的topic的id
     */
    public static void getPieceOfTopic(int id) {
        Request request =
                new Request.Builder().url(BASE_URL + "/topics/" + id + ".json").get().build();
        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Request request, IOException e) {
                Message message = Message.obtain();
                message.what = ContentActivity.GET_TOPIC_FAILED;
                contentHandler.sendMessage(message);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String body = response.body().string();
                TopicBodyGson gson = new Gson().fromJson(body, TopicBodyGson.class);
                Message message = Message.obtain();
                message.obj = gson;
                message.what = ContentActivity.GOT_TOPIC;
                contentHandler.sendMessage(message);
            }
        });
    }

    public static void getPieceOfNews(final String newsUrl) {
        Request request = new Request.Builder().url(newsUrl).get().build();
        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Request request, IOException e) {
                Message message = Message.obtain();
                message.what = ContentActivity.GET_NEWS_FAILED;
                contentHandler.sendMessage(message);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String body = response.body().string();
                Message message = Message.obtain();
                message.what = ContentActivity.GOT_NEWS;
                message.obj = body;
                // TODO: 2017/2/19 修复有时崩溃的bug，由RichText引起
                contentHandler.sendMessage(message);
            }
        });
    }

}
