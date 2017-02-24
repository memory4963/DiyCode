package com.bolo4963gmail.mygankio.AcitivityClasses;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bolo4963gmail.mygankio.ConnectionClasses.OkHttpConnection;
import com.bolo4963gmail.mygankio.GsonClasses.NewsGson;
import com.bolo4963gmail.mygankio.GsonClasses.ProjectsGson;
import com.bolo4963gmail.mygankio.GsonClasses.TopicsGson;
import com.bolo4963gmail.mygankio.R;
import com.bolo4963gmail.mygankio.RecyclerViewClasses.OnItemTouchListener;
import com.bolo4963gmail.mygankio.RecyclerViewClasses.RecyclerViewAdapter;
import com.bolo4963gmail.mygankio.RecyclerViewClasses.RecyclerViewController;
import com.bolo4963gmail.mygankio.RecyclerViewClasses.RecyclerViewData;
import com.bolo4963gmail.mygankio.RecyclerViewClasses.RecyclerViewDecoration;
import com.bolo4963gmail.mygankio.SharedPreferencesClasses.PreferencesController;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";

    private long time = 0;

    private Dialog dialog;
    private AlertDialog.Builder builder;

    private List<RecyclerViewData> topicsList = new ArrayList<>();
    private List<RecyclerViewData> projectList = new ArrayList<>();
    private List<RecyclerViewData> newsList = new ArrayList<>();
    private RecyclerViewAdapter topicsAdapter;
    private RecyclerViewAdapter projectAdapter;
    private RecyclerViewAdapter newsAdapter;
    private int offset = 0;

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.fab) FloatingActionButton fab;
    @BindView(R.id.drawerLayout) DrawerLayout drawer;
    @BindView(R.id.navView) NavigationView navigationView;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    @BindView(R.id.swipeRefresh) SwipeRefreshLayout swipeRefreshLayout;

    ImageView headImage;
    TextView userName;
    TextView userEmail;

    String token;
    String refreshToken;

    private int navigationSelectedItem;

    public static final int GOT_TOPICS = 12343;
    public static final int GET_TOPICS_FAILED = 12352;
    public static final int GOT_PROJECTS = 56352;
    public static final int GET_PROJECTS_FAILED = 12657;
    public static final int GOT_NEWS = 54652;
    public static final int GET_NEWS_FAILED = 16657;
    public static final int GOT_USER_INFO = 32979;
    public static final int GET_USER_INFO_FAILED = 21909;
    public static final int GOT_USER_HEAD_IMAGE = 9493;

    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GOT_TOPICS:
                    List<TopicsGson> topicsGsonList = (List<TopicsGson>) msg.obj;
                    RecyclerViewController.setTopicsList(topicsList, topicsGsonList,
                                                         msg.getData().getInt("offset"));
                    recyclerView.setAdapter(topicsAdapter);
                    topicsAdapter.notifyDataSetChanged();
                    //设置上拉加载后的位置
                    if (offset != 0) {
                        recyclerView.scrollToPosition(offset);
                        int scrollHeight = recyclerView.getHeight();
                        recyclerView.scrollBy(0, -scrollHeight);
                    }
                    if (swipeRefreshLayout.isRefreshing()) {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                    break;
                case GET_TOPICS_FAILED:
                    if (MainActivity.this.hasWindowFocus()) {
                        dialog = builder.setMessage("获取社区列表失败！请检查您的网络连接").show();
                    }
                    if (swipeRefreshLayout.isRefreshing()) {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                    break;
                case GOT_NEWS:
                    List<NewsGson> newsGsonList = (List<NewsGson>) msg.obj;
                    RecyclerViewController.setNewsList(newsList, newsGsonList,
                                                       msg.getData().getInt("offset"));
                    recyclerView.setAdapter(newsAdapter);
                    newsAdapter.notifyDataSetChanged();

                    if (swipeRefreshLayout.isRefreshing()) {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                    break;
                case GET_NEWS_FAILED:
                    if (MainActivity.this.hasWindowFocus()) {
                        dialog = builder.setMessage("获取NEWS列表失败！请检查您的网络连接").show();
                    }
                    if (swipeRefreshLayout.isRefreshing()) {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                    break;
                case GOT_PROJECTS:
                    List<ProjectsGson> projectsGsonList = (List<ProjectsGson>) msg.obj;
                    RecyclerViewController.setProjectList(projectList, projectsGsonList,
                                                          msg.getData().getInt("offset"));
                    recyclerView.setAdapter(projectAdapter);
                    projectAdapter.notifyDataSetChanged();

                    if (swipeRefreshLayout.isRefreshing()) {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                    break;
                case GET_PROJECTS_FAILED:
                    if (MainActivity.this.hasWindowFocus()) {
                        dialog = builder.setMessage("获取项目列表失败！请检查您的网络连接").show();
                    }
                    if (swipeRefreshLayout.isRefreshing()) {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                    break;
                case GOT_USER_INFO:
                    Bundle bundle = msg.getData();
                    userName.setText(bundle.getInt("userId"));
                    userEmail.setText(bundle.getInt("userEmail"));
                    break;
                case GET_USER_INFO_FAILED:
                    if (MainActivity.this.hasWindowFocus()) {
                        dialog = builder.setMessage("获取用户信息失败！请检查你您的网络连接").show();
                    }
                    break;
                case GOT_USER_HEAD_IMAGE:
                    Bitmap bitmap = (Bitmap) msg.obj;
                    headImage.setImageBitmap(bitmap);
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        //设置AlertDialog
        builder = new AlertDialog.Builder(this).setTitle("连接失败！")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (dialog != null) {
                            dialog.dismiss();
                        }

                    }
                });

        //设置OKHttpConnection回调接口
        OkHttpConnection.setMainHandler(handler);

        toolbar.setTitle("DiyCode");

        //判断是否登录
        token = PreferencesController.getString(PreferencesController.TOKEN);
        refreshToken = PreferencesController.getString(PreferencesController.REFRESH_TOKEN);

        new Thread(new Runnable() {

            @Override
            public void run() {
                OkHttpConnection.login("bolo4963@gmail.com", "456rtyFGHvbn");
            }
        }).start();
        if (token.equals("")) {
            //未登录
            // TODO: 2017/1/31 编写登录选项
        } else {
            
        }

        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .show();
            }
        });

        ActionBarDrawerToggle toggle =
                new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open,
                                          R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);
        navigationSelectedItem = navigationView.getMenu().getItem(0).getItemId();

        View hView = navigationView.getHeaderView(0);
        hView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent userIntent = new Intent(MainActivity.this, UserActivity.class);
                // TODO: 2017/2/23 传递信息
                MainActivity.this.startActivity(userIntent);
            }
        });
        headImage = (ImageView) hView.findViewById(R.id.user_head_image);
        userName = (TextView) hView.findViewById(R.id.user_name);
        userEmail = (TextView) hView.findViewById(R.id.user_mail);


        //set swipeRefreshLayout
        swipeRefreshLayout.setProgressViewOffset(false, -180, 48);
        swipeRefreshLayout.setSize(SwipeRefreshLayout.DEFAULT);
        swipeRefreshLayout.setEnabled(true);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                Log.d(TAG, "onRefresh: navigationSelectedItem:" + navigationSelectedItem);
                switch (navigationSelectedItem) {
                    case R.id.nav_community:
                        Log.d(TAG, "onRefresh: refreshing");
                        topicsList.clear();
                        OkHttpConnection.getTopics(null, 0);
                        offset = 0;
                        break;
                    case R.id.nav_news:
                        newsList.clear();
                        OkHttpConnection.getNews(0);
                        offset = 0;
                        break;
                    case R.id.nav_project:
                        projectList.clear();
                        OkHttpConnection.getProjects(0);
                        offset = 0;
                        break;
                    default:
                        break;
                }
            }
        });
        swipeRefreshLayout.setRefreshing(true);

        //recyclerView
        topicsAdapter = new RecyclerViewAdapter(this, topicsList);
        projectAdapter = new RecyclerViewAdapter(this, projectList);
        newsAdapter = new RecyclerViewAdapter(this, newsList);

        recyclerView.setAdapter(topicsAdapter);
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        //分割线
        recyclerView.addItemDecoration(
                new RecyclerViewDecoration(this, LinearLayoutManager.VERTICAL, 12,
                                           getResources().getColor(R.color.white)));
        recyclerView.addOnItemTouchListener(new OnItemTouchListener() {

        });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                View lastChildView = recyclerView.getLayoutManager()
                        .getChildAt(recyclerView.getLayoutManager().getChildCount() - 1);
                int childBottom = 0;
                if (recyclerView.getLayoutManager().getChildCount() > 20) {

                    View seventhChildView = recyclerView.getLayoutManager().getChildAt(19);
                    childBottom = seventhChildView.getBottom();
                }
                //分割线12px高
                int lastChildBottom = lastChildView.getBottom() + 12;
                int recyclerBottom = recyclerView.getBottom() - recyclerView.getPaddingBottom();
                int lastPosition = recyclerView.getLayoutManager().getPosition(lastChildView);
                Log.d(TAG,
                      "onScrolled: " + lastChildBottom + " " + recyclerBottom + " " + childBottom);

                //上拉加载
                if (lastChildBottom == recyclerBottom
                        && lastPosition == recyclerView.getLayoutManager().getItemCount() - 1) {
                    switch (navigationSelectedItem) {
                        case R.id.nav_community:
                            offset += 20;
                            OkHttpConnection.getTopics(null, offset);
                            break;
                        case R.id.nav_news:
                            offset += 20;
                            OkHttpConnection.getNews(offset);
                            break;
                        case R.id.nav_project:
                            offset += 20;
                            OkHttpConnection.getProjects(offset);
                            break;
                        default:
                            break;
                    }
                }
            }
        });
        recyclerView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return swipeRefreshLayout.isRefreshing();
            }
        });

        //获取Topics
        OkHttpConnection.getTopics(null, 0);

        headImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                onHeadClicked();
            }
        });

        userName.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                onHeadClicked();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (recyclerView.canScrollVertically(-1)) {
            recyclerView.smoothScrollToPosition(0);
        } else if (time == 0 || (System.currentTimeMillis() - time > 2700)) {
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
            time = System.currentTimeMillis();
        } else {
            Log.d(TAG, "onBackPressed: 退出");
            ActivityCollector.finishAll();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_community) {
            navigationSelectedItem = id;
            swipeRefreshLayout.setRefreshing(true);
            offset = 0;
            OkHttpConnection.getTopics(null, 0);
        } else if (id == R.id.nav_setting) {
            // TODO: 2017/2/13 设置Activity
        } else if (id == R.id.nav_project) {
            navigationSelectedItem = id;
            swipeRefreshLayout.setRefreshing(true);
            offset = 0;
            OkHttpConnection.getProjects(0);
        } else if (id == R.id.nav_news) {
            navigationSelectedItem = id;
            swipeRefreshLayout.setRefreshing(true);
            offset = 0;
            OkHttpConnection.getNews(0);
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void onHeadClicked() {

    }

}
