package com.bolo4963gmail.mygankio.GsonClasses;

/**
 * Created by 10733 on 2017/2/1.
 */

public class LoginGson {
    
    /**
     * access_token : 4bf60f5657c9d40de2fef1436a6e4eb7f7baa901daac04f27d2fde87f914a637
     * token_type : bearer
     * expires_in : 5184000
     * refresh_token : fea8d7a46451333b5d3652525a0527186b72c5fdc8604a07a3035115e4efcb35
     * created_at : 1485950128
     */

    private String access_token;
    private String token_type;
    private int expires_in;
    private String refresh_token;
    private int created_at;

    public String getAccess_token() { return access_token;}

    public void setAccess_token(String access_token) { this.access_token = access_token;}

    public String getToken_type() { return token_type;}

    public void setToken_type(String token_type) { this.token_type = token_type;}

    public int getExpires_in() { return expires_in;}

    public void setExpires_in(int expires_in) { this.expires_in = expires_in;}

    public String getRefresh_token() { return refresh_token;}

    public void setRefresh_token(String refresh_token) { this.refresh_token = refresh_token;}

    public int getCreated_at() { return created_at;}

    public void setCreated_at(int created_at) { this.created_at = created_at;}
}
