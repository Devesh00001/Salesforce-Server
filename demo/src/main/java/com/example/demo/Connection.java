package com.example.demo;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.example.demo.login.*;

public class Connection {

    public static int responseCode;

    public static StringBuilder response = new StringBuilder();

    static String[] result = aoth();

    private static final String API_URL = result[0];
    private static final String API_KEY = result[1];


    public static StringBuilder getResponse(String endpoint) throws Exception {
        URL url = new URL(API_URL + endpoint);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Bearer " + API_KEY);
        responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;


            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response;
        } else
            return null;


    }
}
