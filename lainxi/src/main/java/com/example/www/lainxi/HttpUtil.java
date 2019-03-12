package com.example.www.lainxi;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {
    public static boolean isNetWorkconnected(Context context){
        if(context!=null){
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if(networkInfo!=null){
                return networkInfo.isAvailable();
            }
        }
        return false;
    }

    public static void getAsyncTask(final String str, final Cannback cannback){
        new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... strings) {

                return httpget(strings[0]);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                cannback.getClass(s);
            }
        }.execute(str);
    }
    public  interface  Cannback{

        void getClass(String s);
     }

    public static String httpget(String strURL){
        try {
            URL url = new URL(strURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.setRequestMethod("GET");
            if(connection.getResponseCode()==200){
                InputStream inputStream = connection.getInputStream();
                InputStreamReader inputStreamReader=new InputStreamReader(inputStream,"utf-8");
                BufferedReader reader=new BufferedReader(inputStreamReader);
                StringBuffer buffer=new StringBuffer();
                String str="";
                while ((str=reader.readLine())!=null){
                    buffer.append(str);
                }
                return buffer.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
           return null;
    }
}
