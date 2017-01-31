package com.bolo4963gmail.mygankio;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bolo4963gmail.mygankio.RecyclerViewClasses.ChildView;
import com.bolo4963gmail.mygankio.RecyclerViewClasses.RecyclerViewAdapter;
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

    // TODO: 2017/1/27 编辑list
    List<ChildView> communityList = new ArrayList<>();
    List<ChildView> projectList;
    List<ChildView> newsList;

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.fab) FloatingActionButton fab;
    @BindView(R.id.drawerLayout) DrawerLayout drawer;
    @BindView(R.id.navView) NavigationView navigationView;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;
//    @BindView(R.id.swipeRefresh) SwipeRefreshLayout swipeRefresh;

    ImageView headImage;
    TextView userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        toolbar.setTitle("DiyCode");

        //判断是否登录
        String token = PreferencesController.getString(PreferencesController.TOKEN);
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

        View hView = navigationView.getHeaderView(0);
        headImage = (ImageView) hView.findViewById(R.id.user_head_image);
        userName = (TextView) hView.findViewById(R.id.user_name);

        //recyclerView
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, communityList);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(//分割线
                                       new RecyclerViewDecoration(this,
                                                                  LinearLayoutManager.VERTICAL, 12,
                                                                  getResources().getColor(
                                                                          R.color.white)));

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
            Log.d(TAG, "onBackPressed: 没有在第一个");
        } else if (time == 0 || (System.currentTimeMillis() - time > 2700)) {
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onBackPressed: 第一次点击");
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
            // TODO: 2017/1/28 编辑菜单
            Log.d(TAG, "onNavigationItemSelected: community chosen");
        } else if (id == R.id.nav_project) {
            Log.d(TAG, "onNavigationItemSelected: project chosen");
        } else if (id == R.id.nav_news) {
            Log.d(TAG, "onNavigationItemSelected: news chosen");
        } else if (id == R.id.nav_setting) {

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void onHeadClicked() {

    }

}
