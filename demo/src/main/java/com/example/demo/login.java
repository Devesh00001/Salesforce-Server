package com.example.demo;


import java.io.IOException;

import com.example.demo.model.ConnectionParam;
import com.github.tsohr.JSONException;
import com.github.tsohr.JSONObject;
import com.github.tsohr.JSONTokener;
import jakarta.servlet.http.HttpSession;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;


public class  login {
    public static HttpResponse response = null;
    public static int statusCode;
    public static String Code;
    @Autowired
    public static ConnectionParam conn = new ConnectionParam();
    static String loginAccessToken = null;
    static String loginInstanceUrl = null;

    public static String[] aoth() {
        HttpClient httpclient = HttpClientBuilder.create().build();
        String loginurl = conn.getLOGINURL() + conn.getGrantService() + "&client_id=" + conn.getClientId() + "&client_secret=" + conn.getClientSecret() + "&username=" +
                conn.getEmail() + "&password=" + conn.getPassword();
        System.out.println(loginurl);
        HttpPost httpPost = new HttpPost(loginurl);
        ;
        try {
            response = httpclient.execute(httpPost);
        } catch (IOException cpException) {
            cpException.printStackTrace();
        }
        assert response != null;
        statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != HttpStatus.SC_OK) {
            System.out.println("Error authenticating to force.com:" + statusCode);


        }
        String getResult = null;
        try {
            getResult = EntityUtils.toString(response.getEntity());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        JSONObject jsonObject;
        try {
            assert getResult != null;
            jsonObject = (JSONObject) new JSONTokener(getResult).nextValue();
            loginAccessToken = jsonObject.getString("access_token");
            loginInstanceUrl = jsonObject.getString("instance_url");
        } catch (JSONException jsonException) {
            jsonException.printStackTrace();
        }

        System.out.println(response.getStatusLine());
        System.out.println("Successful login");
        JSONObject root = new JSONObject();
        root.put("loginInstanceUrl", loginInstanceUrl);
        root.put("loginAccessToken", loginAccessToken);
        System.out.println("instance url" + loginInstanceUrl);
        System.out.println("access token/session ID:" + loginAccessToken);
        httpPost.releaseConnection();
        Code = response.getStatusLine().toString();


        return new String[]{loginInstanceUrl, loginAccessToken};
    }


}
