package com.example.www.week3;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpUtil {

    private static ConnectivityManager connectivityManager;

    public static boolean isNetworkConnected(Context context){
        if(context!=null){
            //获取连接管理者
            connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if(networkInfo!=null){
                //判断网络是否可用
                return networkInfo.isAvailable();
            }
        }
        return false;
    }

    //封装异步
    public static void httpAsynTask(final String strurl, final Callbanck callbanck){
        new AsyncTask<String, Integer, String>() {
            @Override
            protected String doInBackground(String... strings) {
                return htttpget(strurl);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                callbanck.getClass(s);

            }
        }.execute(strurl);
    }

    public interface Callbanck{

        void getClass(String s);
    }
    //get请求
    public static String htttpget(String strURL){
        try {
            URL url = new URL(strURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);
            connection.setRequestMethod("GET");
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer stringBuffer=new StringBuffer();
            String str="";
            while ((str=bufferedReader.readLine())!=null)
            {
                stringBuffer.append(str);
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
