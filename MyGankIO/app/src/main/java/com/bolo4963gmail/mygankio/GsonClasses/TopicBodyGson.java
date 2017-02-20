package com.bolo4963gmail.mygankio.GsonClasses;

/**
 * Created by 10733 on 2017/2/19.
 */

public class TopicBodyGson {

    /**
     * id : 589
     * title : Android 仿今日头条详情页实现
     * created_at : 2017-02-04T10:34:54.769+08:00
     * updated_at : 2017-02-15T20:57:24.343+08:00
     * replied_at : 2017-02-15T14:31:38.657+08:00
     * replies_count : 12
     * node_name : Android
     * node_id : 1
     * last_reply_user_id : 2735
     * last_reply_user_login : sword
     * user : {"id":2735,"login":"sword","name":"ice_Anson","avatar_url":"https://diycode.cc/system/letter_avatars/2/S/162_136_126/240.png"}
     * deleted : false
     * excellent : false
     * abilities : {"update":false,"destroy":false}
     * body : # Android仿今日头条详情页实现

     ## 源码地址：

     [Android仿今日头条详情页实现 github源码地址](https://github.com/iceAnson/NewsDetail)

     !["Screen Shot"](http://okttsxi3s.bkt.clouddn.com/xiaoguo.gif)

     最近项目有个需求，需要实现一个和今日头条新闻详情页一样的体验。上部分是webview来展示新闻内容，下半部分是listview来展示评论区，可无限加载更多。
     起初的实现思路是 将webview放置在listview头部，看似没有什么问题，实现之后发现，webview各种奇怪的问题：黑屏，图片闪烁白屏,渲染速度慢等等问题；
     将webview和listview独立放置遍没有问题；于是反编译了一下头条的实现：

     ![Screen Shot](http://okttsxi3s.bkt.clouddn.com/toutiao1.png)

     从上图可以知道，实现的原理是，ViewGroup包着listview和webview实现的；于是顺着这条思路往下走。

     今日头条的代码是混淆的无法直接使用，我采用的方案是ScrollView里边嵌套了webview+listview;

     这套方案有以下几个问题需要解决：

     ```java
     1. 解决webview在scrollview全部展开的问题。不展开的方法太过复杂，手势处理太麻烦，这里采用展开的形式
     2. 我们知道scrollview包含的childview是无法复用了，那么首先要解决listview的复用问题；
     3. 滑动到listview和webview边界的时候，对于手势事件的交换和状态的保存。

     ```

     ## 1、webview全部展开的问题

     ```java
     mWebView.loadUrl(url);
     mWebView.setWebViewClient(new WebViewClient() {
    @Override public void onPageFinished(WebView view, String url) {
    super.onPageFinished(view, url);
    int w = View.MeasureSpec.makeMeasureSpec(0,
    View.MeasureSpec.UNSPECIFIED);
    int h = View.MeasureSpec.makeMeasureSpec(0,
    View.MeasureSpec.UNSPECIFIED);
    //重新测量
    view.measure(w, h);
    mWebViewHeight = view.getHeight();
    Log.i(TAG, "WEBVIEW高度:" + view.getHeight());
    }
    });

     ```

     ## 2和3、listview复用问题和手势切换问题

     1、复用意味着不能全部展开，现将高度定为（屏幕高度-状态栏高度-标题栏高度）；

     2、当scrollview滚动到底部的时候，让listview根据手势惯性fling一会，以加强体验，然后将手势交给listview；

     3、当listview滑动到底部的时候，加载更多；

     4、当listview滑动到顶部的时候，向上滚5个像素，并将手势交给scrollview，便可向上流畅滑动；

     5、当listview即将到达顶部的时候，手动往下拖动，当到达边界的时候，需要让scrollview跟着以前scrollby，让用户感知是一起滑动的，当手指松开的时候，要让scrollview惯性滚动一会，以增强体验；

     ## 遗留问题
     1、scrollview和listview的内部滚动速度是不一致的，scrollview是比较大的，在scrollview滚动到底部的时候，listview采用scrollview滚动速度的三分之一进行fling，体验下来感觉还是比较流畅的。但总感觉还是不够稳妥，优化思路是：接管scrollview和listview的滚动速度，手动控制两个控件的过渡过程；

     2、当listview即将到达顶部的时候，手动往下拖动，当到达边界的时候，需要让scrollview跟着以前scrollby，让用户感知是一起滑动的，当手指松开的时候，要让scrollview惯性滚动一会，这里的惯性也由于速度不一致的问题，造成一点点的那么不自然；优化思路和1一致；


     Done
     ----------
     QQ:452825089

     mail:452825089@qq.com

     wechat:ice3897315

     blog:http://iceAnson.github.io







     * body_html : <h2 id="Android仿今日头条详情页实现">Android仿今日头条详情页实现</h2><h2 id="源码地址：">源码地址：</h2>
     <p><a href="https://github.com/iceAnson/NewsDetail" target="_blank">Android仿今日头条详情页实现 github源码地址</a> </p>

     <p><img src="http://okttsxi3s.bkt.clouddn.com/xiaoguo.gif" title="" alt=""></p>

     <p>最近项目有个需求，需要实现一个和今日头条新闻详情页一样的体验。上部分是webview来展示新闻内容，下半部分是listview来展示评论区，可无限加载更多。<br>
     起初的实现思路是 将webview放置在listview头部，看似没有什么问题，实现之后发现，webview各种奇怪的问题：黑屏，图片闪烁白屏,渲染速度慢等等问题；<br>
     将webview和listview独立放置遍没有问题；于是反编译了一下头条的实现：</p>

     <p><img src="http://okttsxi3s.bkt.clouddn.com/toutiao1.png" title="" alt="Screen Shot"></p>

     <p>从上图可以知道，实现的原理是，ViewGroup包着listview和webview实现的；于是顺着这条思路往下走。</p>

     <p>今日头条的代码是混淆的无法直接使用，我采用的方案是ScrollView里边嵌套了webview+listview;</p>

     <p>这套方案有以下几个问题需要解决：</p>
     <pre class="highlight java"><code> <span class="mi">1</span><span class="o">.</span> <span class="err">解决</span><span class="n">webview</span><span class="err">在</span><span class="n">scrollview</span><span class="err">全部展开的问题。不展开的方法太过复杂，手势处理太麻烦，这里采用展开的形式</span>
     <span class="mi">2</span><span class="o">.</span> <span class="err">我们知道</span><span class="n">scrollview</span><span class="err">包含的</span><span class="n">childview</span><span class="err">是无法复用了，那么首先要解决</span><span class="n">listview</span><span class="err">的复用问题；</span>
     <span class="mi">3</span><span class="o">.</span> <span class="err">滑动到</span><span class="n">listview</span><span class="err">和</span><span class="n">webview</span><span class="err">边界的时候，对于手势事件的交换和状态的保存。</span></code></pre>
     <h2 id="1、webview全部展开的问题">1、webview全部展开的问题</h2><pre class="highlight java"><code>        <span class="n">mWebView</span><span class="o">.</span><span class="na">loadUrl</span><span class="o">(</span><span class="n">url</span><span class="o">);</span>
     <span class="n">mWebView</span><span class="o">.</span><span class="na">setWebViewClient</span><span class="o">(</span><span class="k">new</span> <span class="n">WebViewClient</span><span class="o">()</span> <span class="o">{</span>
     <span class="nd">@Override</span>
     <span class="kd">public</span> <span class="kt">void</span> <span class="n">onPageFinished</span><span class="o">(</span><span class="n">WebView</span> <span class="n">view</span><span class="o">,</span> <span class="n">String</span> <span class="n">url</span><span class="o">)</span> <span class="o">{</span>
     <span class="kd">super</span><span class="o">.</span><span class="na">onPageFinished</span><span class="o">(</span><span class="n">view</span><span class="o">,</span> <span class="n">url</span><span class="o">);</span>
     <span class="kt">int</span> <span class="n">w</span> <span class="o">=</span> <span class="n">View</span><span class="o">.</span><span class="na">MeasureSpec</span><span class="o">.</span><span class="na">makeMeasureSpec</span><span class="o">(</span><span class="mi">0</span><span class="o">,</span>
     <span class="n">View</span><span class="o">.</span><span class="na">MeasureSpec</span><span class="o">.</span><span class="na">UNSPECIFIED</span><span class="o">);</span>
     <span class="kt">int</span> <span class="n">h</span> <span class="o">=</span> <span class="n">View</span><span class="o">.</span><span class="na">MeasureSpec</span><span class="o">.</span><span class="na">makeMeasureSpec</span><span class="o">(</span><span class="mi">0</span><span class="o">,</span>
     <span class="n">View</span><span class="o">.</span><span class="na">MeasureSpec</span><span class="o">.</span><span class="na">UNSPECIFIED</span><span class="o">);</span>
     <span class="c1">//重新测量</span>
     <span class="n">view</span><span class="o">.</span><span class="na">measure</span><span class="o">(</span><span class="n">w</span><span class="o">,</span> <span class="n">h</span><span class="o">);</span>
     <span class="n">mWebViewHeight</span> <span class="o">=</span> <span class="n">view</span><span class="o">.</span><span class="na">getHeight</span><span class="o">();</span>
     <span class="n">Log</span><span class="o">.</span><span class="na">i</span><span class="o">(</span><span class="n">TAG</span><span class="o">,</span> <span class="s">"WEBVIEW高度:"</span> <span class="o">+</span> <span class="n">view</span><span class="o">.</span><span class="na">getHeight</span><span class="o">());</span>
     <span class="o">}</span>
     <span class="o">});</span></code></pre>
     <h2 id="2和3、listview复用问题和手势切换问题">2和3、listview复用问题和手势切换问题</h2>
     <p>1、复用意味着不能全部展开，现将高度定为（屏幕高度-状态栏高度-标题栏高度）；</p>

     <p>2、当scrollview滚动到底部的时候，让listview根据手势惯性fling一会，以加强体验，然后将手势交给listview；</p>

     <p>3、当listview滑动到底部的时候，加载更多；</p>

     <p>4、当listview滑动到顶部的时候，向上滚5个像素，并将手势交给scrollview，便可向上流畅滑动；</p>

     <p>5、当listview即将到达顶部的时候，手动往下拖动，当到达边界的时候，需要让scrollview跟着以前scrollby，让用户感知是一起滑动的，当手指松开的时候，要让scrollview惯性滚动一会，以增强体验；</p>
     <h2 id="遗留问题">遗留问题</h2>
     <p>1、scrollview和listview的内部滚动速度是不一致的，scrollview是比较大的，在scrollview滚动到底部的时候，listview采用scrollview滚动速度的三分之一进行fling，体验下来感觉还是比较流畅的。但总感觉还是不够稳妥，优化思路是：接管scrollview和listview的滚动速度，手动控制两个控件的过渡过程；</p>

     <p>2、当listview即将到达顶部的时候，手动往下拖动，当到达边界的时候，需要让scrollview跟着以前scrollby，让用户感知是一起滑动的，当手指松开的时候，要让scrollview惯性滚动一会，这里的惯性也由于速度不一致的问题，造成一点点的那么不自然；优化思路和1一致；</p>
     <h2 id="Done">Done</h2>
     <p>QQ:452825089</p>

     <p>mail:452825089@qq.com</p>

     <p>wechat:ice3897315</p>

     <p>blog:<a href="http://iceAnson.github.io" rel="nofollow" target="_blank">http://iceAnson.github.io</a></p>
     * hits : 1496
     * likes_count : 6
     * suggested_at : null
     */

    private int id;
    private String title;
    private String created_at;
    private String updated_at;
    private String replied_at;
    private int replies_count;
    private String node_name;
    private int node_id;
    private int last_reply_user_id;
    private String last_reply_user_login;
    private UserBean user;
    private boolean deleted;
    private boolean excellent;
    private AbilitiesBean abilities;
    private String body;
    private String body_html;
    private int hits;
    private int likes_count;
    private Object suggested_at;

    public int getId() { return id;}

    public void setId(int id) { this.id = id;}

    public String getTitle() { return title;}

    public void setTitle(String title) { this.title = title;}

    public String getCreated_at() { return created_at;}

    public void setCreated_at(String created_at) { this.created_at = created_at;}

    public String getUpdated_at() { return updated_at;}

    public void setUpdated_at(String updated_at) { this.updated_at = updated_at;}

    public String getReplied_at() { return replied_at;}

    public void setReplied_at(String replied_at) { this.replied_at = replied_at;}

    public int getReplies_count() { return replies_count;}

    public void setReplies_count(int replies_count) { this.replies_count = replies_count;}

    public String getNode_name() { return node_name;}

    public void setNode_name(String node_name) { this.node_name = node_name;}

    public int getNode_id() { return node_id;}

    public void setNode_id(int node_id) { this.node_id = node_id;}

    public int getLast_reply_user_id() { return last_reply_user_id;}

    public void setLast_reply_user_id(int last_reply_user_id) {
        this.last_reply_user_id = last_reply_user_id;
    }

    public String getLast_reply_user_login() { return last_reply_user_login;}

    public void setLast_reply_user_login(String last_reply_user_login) {
        this.last_reply_user_login = last_reply_user_login;
    }

    public UserBean getUser() { return user;}

    public void setUser(UserBean user) { this.user = user;}

    public boolean isDeleted() { return deleted;}

    public void setDeleted(boolean deleted) { this.deleted = deleted;}

    public boolean isExcellent() { return excellent;}

    public void setExcellent(boolean excellent) { this.excellent = excellent;}

    public AbilitiesBean getAbilities() { return abilities;}

    public void setAbilities(AbilitiesBean abilities) { this.abilities = abilities;}

    public String getBody() { return body;}

    public void setBody(String body) { this.body = body;}

    public String getBody_html() { return body_html;}

    public void setBody_html(String body_html) { this.body_html = body_html;}

    public int getHits() { return hits;}

    public void setHits(int hits) { this.hits = hits;}

    public int getLikes_count() { return likes_count;}

    public void setLikes_count(int likes_count) { this.likes_count = likes_count;}

    public Object getSuggested_at() { return suggested_at;}

    public void setSuggested_at(Object suggested_at) { this.suggested_at = suggested_at;}

    public static class UserBean {

        /**
         * id : 2735
         * login : sword
         * name : ice_Anson
         * avatar_url : https://diycode.cc/system/letter_avatars/2/S/162_136_126/240.png
         */

        private int id;
        private String login;
        private String name;
        private String avatar_url;

        public int getId() { return id;}

        public void setId(int id) { this.id = id;}

        public String getLogin() { return login;}

        public void setLogin(String login) { this.login = login;}

        public String getName() { return name;}

        public void setName(String name) { this.name = name;}

        public String getAvatar_url() { return avatar_url;}

        public void setAvatar_url(String avatar_url) { this.avatar_url = avatar_url;}
    }

    public static class AbilitiesBean {

        /**
         * update : false
         * destroy : false
         */

        private boolean update;
        private boolean destroy;

        public boolean isUpdate() { return update;}

        public void setUpdate(boolean update) { this.update = update;}

        public boolean isDestroy() { return destroy;}

        public void setDestroy(boolean destroy) { this.destroy = destroy;}
    }
}
