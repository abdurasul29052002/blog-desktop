package com.example.blogdesktop.service;

import com.example.blogdesktop.Main;
import lombok.SneakyThrows;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.*;

public class ConnectionService {
    @SneakyThrows
    public static InputStream getConnection(String stringUrl){
        HttpURLConnection httpUrlConnection = getHttpUrlConnection(stringUrl);
        httpUrlConnection.setRequestMethod("GET");
        httpUrlConnection.connect();
        return httpUrlConnection.getInputStream();
    }

    @SneakyThrows
    public static InputStream postConnection(String stringUrl, String json){
        HttpURLConnection httpUrlConnection = getHttpUrlConnection(stringUrl);
        httpUrlConnection.setRequestMethod("POST");
        httpUrlConnection.connect();
        PrintWriter printWriter = new PrintWriter(httpUrlConnection.getOutputStream(), true);
        printWriter.println(json);
        httpUrlConnection.connect();
        return httpUrlConnection.getInputStream();
    }

    private static HttpURLConnection getHttpUrlConnection(String stringUrl) throws IOException {
        URL url = new URL(Main.BASE_URL + stringUrl);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        if (!Main.token.equals("")) {
            httpURLConnection.setRequestProperty("Authorization", "Bearer " + Main.token);
        }
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }
}
