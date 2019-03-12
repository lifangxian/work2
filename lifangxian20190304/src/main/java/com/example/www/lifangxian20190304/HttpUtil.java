package com.example.www.lifangxian20190304;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.InflaterInputStream;

public class HttpUtil {

    private static ConnectivityManager manager;

    public static boolean isNetworkConnected(Context context){
      if(context!=null){
          manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
          NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if(networkInfo!=null){
            return networkInfo.isConnected();
        }
      }
      return false;

  }

  public static void httpAsyncTask (final String strURL, final Callbanck callbanck){
      new AsyncTask<String, Void, String>() {
          @Override
          protected String doInBackground(String... strings) {
              return requestString(strURL);
          }

          @Override
          protected void onPostExecute(String s) {
              super.onPostExecute(s);
              callbanck.getClass(s);
          }
      }.execute(strURL);
  }
  public interface Callbanck{

      void getClass(String s);
  }
  //get请求
    public static String requestString(String strURL){
        try {
            URL url = new URL(strURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.setRequestMethod("GET");
            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer buffer=new StringBuffer();
            String str="";
            while ((str=reader.readLine())!=null){
                buffer.append(str);
            }
            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
