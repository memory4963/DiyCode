package com.bolo4963gmail.mygankio.GsonClasses;

/**
 * Created by 10733 on 2017/1/30.
 */

public class TopicsGson {
    
    /**
     * id : 588
     * title : 简约漂亮的 Vue 圆环菜单组件
     * created_at : 2017-01-29T12:31:33.179+08:00
     * updated_at : 2017-01-29T12:31:40.426+08:00
     * replied_at : null
     * replies_count : 0
     * node_name : 分享发现
     * node_id : 27
     * last_reply_user_id : null
     * last_reply_user_login : null
     * user : {"id":3762,"login":"oysun","name":null,"avatar_url":"https://diycode.cc/system/letter_avatars/2/O/255_168_0/240.png"}
     * deleted : false
     * excellent : false
     * abilities : {"update":false,"destroy":false}
     */

    private int id;
    private String title;
    private String created_at;
    private String updated_at;
    private Object replied_at;
    private int replies_count;
    private String node_name;
    private int node_id;
    private Object last_reply_user_id;
    private Object last_reply_user_login;
    private UserBean user;
    private boolean deleted;
    private boolean excellent;
    private AbilitiesBean abilities;

    public int getId() { return id;}

    public void setId(int id) { this.id = id;}

    public String getTitle() { return title;}

    public void setTitle(String title) { this.title = title;}

    public String getCreated_at() { return created_at;}

    public void setCreated_at(String created_at) { this.created_at = created_at;}

    public String getUpdated_at() { return updated_at;}

    public void setUpdated_at(String updated_at) { this.updated_at = updated_at;}

    public Object getReplied_at() { return replied_at;}

    public void setReplied_at(Object replied_at) { this.replied_at = replied_at;}

    public int getReplies_count() { return replies_count;}

    public void setReplies_count(int replies_count) { this.replies_count = replies_count;}

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

    public UserBean getUser() { return user;}

    public void setUser(UserBean user) { this.user = user;}

    public boolean isDeleted() { return deleted;}

    public void setDeleted(boolean deleted) { this.deleted = deleted;}

    public boolean isExcellent() { return excellent;}

    public void setExcellent(boolean excellent) { this.excellent = excellent;}

    public AbilitiesBean getAbilities() { return abilities;}

    public void setAbilities(AbilitiesBean abilities) { this.abilities = abilities;}

    public static class UserBean {

        /**
         * id : 3762
         * login : oysun
         * name : null
         * avatar_url : https://diycode.cc/system/letter_avatars/2/O/255_168_0/240.png
         */

        private int id;
        private String login;
        private Object name;
        private String avatar_url;

        public int getId() { return id;}

        public void setId(int id) { this.id = id;}

        public String getLogin() { return login;}

        public void setLogin(String login) { this.login = login;}

        public Object getName() { return name;}

        public void setName(Object name) { this.name = name;}

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
