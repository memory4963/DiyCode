package com.bolo4963gmail.mygankio.AcitivityClasses;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import com.bolo4963gmail.mygankio.ConnectionClasses.OkHttpConnection;
import com.bolo4963gmail.mygankio.GsonClasses.TopicBodyGson;
import com.bolo4963gmail.mygankio.R;
import com.bolo4963gmail.mygankio.RecyclerViewClasses.RecyclerViewData;
import com.zzhoujay.richtext.RichText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContentActivity extends BaseActivity {

    private static final String TAG = "ContentActivity";

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */

    private Dialog dialog;
    private AlertDialog.Builder builder;

    @BindView(R.id.contentToolbar) Toolbar toolbar;
    @BindView(R.id.fab) FloatingActionButton fab;
    @BindView(R.id.contentTv) TextView contentTv;
    @BindView(R.id.contentSwipe) SwipeRefreshLayout contentSwipe;
    @BindView(R.id.contentWebView) WebView webView;

    public static final int GOT_TOPIC = 39596;
    public static final int GET_TOPIC_FAILED = 29596;
    public static final int GOT_NEWS = 15463;
    public static final int GET_NEWS_FAILED = 53399;
    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GOT_TOPIC:
                    TopicBodyGson bodyGson = (TopicBodyGson) msg.obj;
                    RichText.from(bodyGson.getBody_html()).into(contentTv);
                    contentSwipe.setRefreshing(false);
                    break;
                case GET_TOPIC_FAILED:
                case GET_NEWS_FAILED:
                    if (ContentActivity.this.hasWindowFocus()) {
                        dialog = builder.setMessage("获取文章失败！请检查您的网络连接").show();
                    }
                    contentSwipe.setRefreshing(false);
                    break;
                case GOT_NEWS:
                    String body = (String) msg.obj;
                    RichText.from(body).into(contentTv);
                    contentSwipe.setRefreshing(false);
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();
            return true;
        } else if (keyCode == KeyEvent.KEYCODE_BACK && webView.getVisibility() == View.VISIBLE) {
            webView.setVisibility(View.GONE);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        ButterKnife.bind(this);

        // Toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                finish();
            }
        });

        OkHttpConnection.setContentHandler(handler);

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

        //获取数据
        final Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        final int type = intent.getIntExtra("type", -1);
        if (type == RecyclerViewData.TYPE_TOPIC) {
            int topicId = intent.getIntExtra("topicId", -1);
            if (topicId == -1) {
                throw new RuntimeException("无topicId");
            }
            contentSwipe.setRefreshing(true);
            OkHttpConnection.getPieceOfTopic(topicId);
        } else if (type == RecyclerViewData.TYPE_NEWS) {
            String newsUrl = intent.getStringExtra("newsUrl");
            if (TextUtils.isEmpty(newsUrl)) {
                throw new RuntimeException("无newsUrl");
            }
            contentSwipe.setRefreshing(true);
            OkHttpConnection.getPieceOfNews(newsUrl);
        } else if (type == RecyclerViewData.TYPE_PROJECT) {
            String readme = intent.getStringExtra("readme");
            RichText.fromMarkdown(readme).into(contentTv);
        }

        // CollapsingToolbarLayout
        toolbar.setTitle(title);
        setTitle(title);

        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .show();
            }
        });

        contentSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                switch (type) {
                    case RecyclerViewData.TYPE_TOPIC:
                        int topicId = intent.getIntExtra("topicId", -1);
                        if (topicId != -1) {
                            OkHttpConnection.getPieceOfTopic(topicId);
                        }
                        break;
                    case RecyclerViewData.TYPE_NEWS:
                        String newsUrl = intent.getStringExtra("newsUrl");
                        if (!TextUtils.isEmpty(newsUrl)) {
                            OkHttpConnection.getPieceOfNews(newsUrl);
                        }
                        break;
                    case RecyclerViewData.TYPE_PROJECT:
                        String readme = intent.getStringExtra("readme");
                        RichText.fromMarkdown(readme).into(contentTv);
                        contentSwipe.setRefreshing(false);
                        break;
                    default:
                        break;
                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

}
