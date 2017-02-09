package com.bolo4963gmail.mygankio.ConnectionClasses;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;

import com.bolo4963gmail.mygankio.GsonClasses.LoginGson;
import com.bolo4963gmail.mygankio.GsonClasses.NewsGson;
import com.bolo4963gmail.mygankio.GsonClasses.ProjectsGson;
import com.bolo4963gmail.mygankio.GsonClasses.TopicsGson;
import com.bolo4963gmail.mygankio.MainActivity;
import com.bolo4963gmail.mygankio.SharedPreferencesClasses.PreferencesController;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 10733 on 2017/1/28.
 */

public class OkHttpConnection {

    private static Handler handler;

    private static final String TAG = "OkHttpConnection";

    private static String token = null;
    private static String refresh_token = null;

    private static final String AUTHORIZATION = "Authorization";

    /**
     * URL 基本路径
     */
    private static final String BASE_URL = "https://diycode.cc/api/v3";//any

    /**
     * 记录用户 Device 信息，用于 Push 通知。
     * 请在每次用户打开 App 的时候调用此 API 以便更新 Token 的 last_actived_at 让服务端知道这个设备还活着。
     * Push 将会忽略那些超过两周的未更新的设备。
     * Method post
     */
    private static final String DEVICES = "/devices.json";

    /**
     * 选取Topics
     */
    public static final String TOPICS_LAST_ACTIVED = "last_actived";
    public static final String TOPICS_RECENT = "recent";
    public static final String TOPICS_NO_REPLY = "no_reply";
    public static final String TOPICS_POPULAR = "popular";
    public static final String TOPICS_EXCELLENT = "excellent";

    /**
     * 登录
     *
     * @return nullable
     */
    public static Map<String, String> login(String account, String password) {
        OkHttpClient client = new OkHttpClient();
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
                    "refresh_token为空吗，先初始化。(refresh_token is null, please initial refresh_token first.)");
        }
        OkHttpClient client = new OkHttpClient();
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
     * 初始化程序，通知服务器 “我还活着”
     * "未登录不要调用"
     */
    public static void initializeApp() {
        OkHttpClient client = new OkHttpClient();
        try {
            Request request = new Request.Builder().url(
                    BASE_URL + DEVICES + "?platform=android&token=" + token)
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
     * @return 返回TopicsGson类，网络连接失败时返回null
     */
    public static TopicsGson getTopics(@Nullable String flag, int node_id, int offset) {
        if (flag == null) {
            flag = TOPICS_LAST_ACTIVED;
        }

        OkHttpClient client = new OkHttpClient();
        try {
            Headers headers = new Headers.Builder().add("Host", "diycode.cc").build();
            Request request = new Request.Builder().url(
                    BASE_URL + "/topics.json" + "?type=" + flag + "&node_id=" + node_id + "&offset="
                            + offset).headers(headers).get().build();
            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();
            return new Gson().fromJson(responseBody, TopicsGson.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取topics
     *
     * @param flag 从5个名称以TOPICS开头的String中选取
     * @return 返回TopicsGson类，网络连接失败时返回null
     */
    public static void getTopics(@Nullable String flag, int offset) {
        if (flag == null) {
            flag = TOPICS_LAST_ACTIVED;
        }

        OkHttpClient client = new OkHttpClient();
        Headers headers = new Headers.Builder().add("Host", "diycode.cc").build();
        Request request = new Request.Builder().url(
                BASE_URL + "/topics.json" + "?type=" + flag + "&offset=" + offset)
                .headers(headers)
                .get()
                .build();
        Callback callback = new Callback() {

            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();

            }

            @Override
            public void onResponse(Response response) throws IOException {
                String responseBody = response.body().string();
                if (handler != null) {
                    Message message = Message.obtain(handler);
                    message.what = MainActivity.GOT_TOPICS;
                    // TODO: 2017/2/9 更改为List 全部替换
                    message.obj = new Gson().fromJson(responseBody, TopicsGson.class);
                    handler.sendMessage(message);
                }
            }
        };
        client.newCall(request).enqueue(callback);
    }

    /**
     * 获取projects
     *
     * @param node_id 选取接收的projects的类别
     * @param offset  请求位置开始数，从0开始
     * @return 返回ProjectsGson类，网络连接失败时返回null
     */
    public static ProjectsGson getProjects(int node_id, int offset) {
        OkHttpClient client = new OkHttpClient();
        try {
            Headers headers = new Headers.Builder().add("Host", "diycode.cc").build();
            Request request = new Request.Builder().url(
                    BASE_URL + "/projects.json" + "?node_id=" + node_id + "&offset=" + offset)
                    .headers(headers)
                    .get()
                    .build();
            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();
            return new Gson().fromJson(responseBody, ProjectsGson.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取projects
     *
     * @param offset 请求位置开始数，从0开始
     * @return 返回ProjectsGson类，网络连接失败时返回null
     */
    public static List<ProjectsGson> getProjects(int offset) {
        OkHttpClient client = new OkHttpClient();
        try {
            Headers headers = new Headers.Builder().add("Host", "diycode.cc").build();
            Request request =
                    new Request.Builder().url(BASE_URL + "/projects.json" + "?offset=" + offset)
                            .headers(headers)
                            .get()
                            .build();
            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();
            return new Gson().fromJson(responseBody, new TypeToken<List<ProjectsGson>>() {}
                    .getType());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取news
     *
     * @param node_id 选取接收的news的类别
     * @param offset  请求位置开始数，从0开始
     * @return 返回ProjectsGson类，网络连接失败时返回null
     */
    public static NewsGson getNews(int node_id, int offset) {
        OkHttpClient client = new OkHttpClient();
        try {
            Headers headers = new Headers.Builder().add("Host", "diycode.cc").build();
            Request request = new Request.Builder().url(
                    BASE_URL + "/news.json" + "?node_id=" + node_id + "&offset=" + offset)
                    .headers(headers)
                    .get()
                    .build();
            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();
            return new Gson().fromJson(responseBody, NewsGson.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取news
     *
     * @param offset 请求位置开始数，从0开始
     * @return 返回ProjectsGson类，网络连接失败时返回null
     */
    public static NewsGson getNews(int offset) {
        OkHttpClient client = new OkHttpClient();
        try {
            Headers headers = new Headers.Builder().add("Host", "diycode.cc").build();
            Request request =
                    new Request.Builder().url(BASE_URL + "/news.json" + "?offset=" + offset)
                            .headers(headers)
                            .get()
                            .build();
            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();
            return new Gson().fromJson(responseBody, NewsGson.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void setRefresh_token(String refresh_token) {
        OkHttpConnection.refresh_token = refresh_token;
    }

    public static void setToken(String token) {
        OkHttpConnection.token = token;
    }

    public static void setHandler(Handler handler) {
        OkHttpConnection.handler = handler;
    }
}
