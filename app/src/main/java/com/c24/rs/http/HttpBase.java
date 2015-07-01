package com.c24.rs.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpBase {
    public StringBuffer request(String urlString, String method) throws IOException {
        StringBuffer chaine = new StringBuffer("");

        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestProperty("User-Agent", "");
        connection.setRequestMethod(method);
        connection.connect();

        InputStream inputStream = connection.getInputStream();

        BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        while ((line = rd.readLine()) != null) {
            chaine.append(line);
        }

        return chaine;
    }
}
