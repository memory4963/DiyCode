package com.bolo4963gmail.mygankio.GsonClasses;

/**
 * Created by 10733 on 2017/1/30.
 */

public class NewsGson {
    
    /**
     * id : 1927
     * title : 微影时代前端的技术架构
     * created_at : 2017-01-24T15:10:29.597+08:00
     * updated_at : 2017-01-24T15:10:29.597+08:00
     * user : {"id":1,"login":"jixiaohua","name":"寂小桦","avatar_url":"https://diycode.b0.upaiyun.com/user/large_avatar/2.jpg"}
     * node_name : F2E
     * node_id : 3
     * last_reply_user_id : null
     * last_reply_user_login : null
     * replied_at : null
     * address : https://mp.weixin.qq.com/s?__biz=MzI5MTEwNzM4Mg==&mid=2650546365&idx=1&sn=8998cf90eab0534c6b49689ed87e8e30&chksm=f41d27e4c36aaef24cc1bb00ac991e8b8b5d47b98a3aafdd457c43b2792490608fb0d642a206&mpshare=1&scene=1&srcid=0124D2HwsGhoZZ1aVADihKiz&key=c35f460fa5b3ddd907abf793cfd50c1fe17401a75562b624a65ef5ac23710dc0d6a5d9d5e6958ae6d686fe9689604bf7157c8779d823207c0ad10f5bbe095e2b1ada70fc541d676d253cf6d7bb55fa29&ascene=0&uin=NTI1MzE1NDE1&devicetype=iMac+MacBookPro12%2C1+OSX+OSX+10.12.2+build(16C67)&version=12010110&nettype=WIFI&fontScale=100&pass_ticket=wMZjg%2B4NwXkInmlNPi4TycP%2BgkoLu8p8PkVn%2FV6amqj1Rxo55SpmgjVZw7d5cYcD
     * replies_count : 0
     */

    private int id;
    private String title;
    private String created_at;
    private String updated_at;
    private UserBean user;
    private String node_name;
    private int node_id;
    private Object last_reply_user_id;
    private Object last_reply_user_login;
    private Object replied_at;
    private String address;
    private int replies_count;

    public int getId() { return id;}

    public void setId(int id) { this.id = id;}

    public String getTitle() { return title;}

    public void setTitle(String title) { this.title = title;}

    public String getCreated_at() { return created_at;}

    public void setCreated_at(String created_at) { this.created_at = created_at;}

    public String getUpdated_at() { return updated_at;}

    public void setUpdated_at(String updated_at) { this.updated_at = updated_at;}

    public UserBean getUser() { return user;}

    public void setUser(UserBean user) { this.user = user;}

    public String getNode_name() { return node_name;}

    public void setNode_name(String node_name) { this.node_name = node_name;}

    public int getNode_id() { return node_id;}

    public void setNode_id(int node_id) { this.node_id = node_id;}

    public Object getLast_reply_user_id() { return last_reply_user_id;}

    public void setLast_reply_user_id(Object last_reply_user_id) {
        this.last_reply_user_id = last_reply_user_id;
    }

    public Object getLast_reply_user_login() { return last_reply_user_login;}

    public void setLast_reply_user_login(Object last_reply_user_login) {
        this.last_reply_user_login = last_reply_user_login;
    }

    public Object getReplied_at() { return replied_at;}

    public void setReplied_at(Object replied_at) { this.replied_at = replied_at;}

    public String getAddress() { return address;}

    public void setAddress(String address) { this.address = address;}

    public int getReplies_count() { return replies_count;}

    public void setReplies_count(int replies_count) { this.replies_count = replies_count;}

    public static class UserBean {

        /**
         * id : 1
         * login : jixiaohua
         * name : 寂小桦
         * avatar_url : https://diycode.b0.upaiyun.com/user/large_avatar/2.jpg
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
}
