package com.example.demo;


import java.io.IOException;

import com.example.demo.model.ConnectionParam;
import com.github.tsohr.JSONException;
import com.github.tsohr.JSONObject;
import com.github.tsohr.JSONTokener;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;


public class  login {

        @Autowired
        public static ConnectionParam con = new ConnectionParam();
        static String loginAccessToken =null;
        static  String loginInstanceUrl= null;

        public static String[] aoth() {
            HttpClient httpclient = HttpClientBuilder.create().build();
            String loginurl = con.getLOGINURL() + con.getGrantService() + "&client_id=" + con.getClientId() + "&client_secret=" +con.getClientSecret() + "&username=" +
                    con.getEmail() + "&password=" + con.getPassword();
            System.out.println(loginurl);
            HttpPost httpPost = new HttpPost(loginurl);
            HttpResponse response = null;
            try {
                response = httpclient.execute(httpPost);
            } catch (IOException cpException) {
                cpException.printStackTrace();
            }
            assert response != null;
            final int statusCode = response.getStatusLine().getStatusCode();
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



            return new String[]{loginInstanceUrl, loginAccessToken};
        }


    }
