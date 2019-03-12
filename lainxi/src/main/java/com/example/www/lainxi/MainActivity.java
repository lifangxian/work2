package com.example.www.lainxi;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.example.www.lainxi.bannerbane.JavaBean;
import com.example.www.lainxi.bannerbane.Result;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    private PullToRefreshListView plist;
    private GridView gridView;
    private Banner banner;
    //1．Banner轮播图列表请求接口
    String strurl="http://172.17.8.100/small/commodity/v1/bannerShow";
    //2．9宫格图片展示接口
    String str="http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1";
    //3．底部ListView条目展示接口
    String sss="http://172.17.8.100/small/commodity/v1/commodityList";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        banner = findViewById(R.id.banner);
        gridView = findViewById(R.id.gridview);
        plist = findViewById(R.id.plist);
        boolean b = HttpUtil.isNetWorkconnected(MainActivity.this);
        if(b){
            HttpUtil.getAsyncTask(strurl, new HttpUtil.Cannback() {
                @Override
                public void getClass(String s) {
                    Gson gson=new Gson();
                    JavaBean javaBean = gson.fromJson(s, JavaBean.class);
                   final ArrayList<Result> result = javaBean.getResult();
                    //Log.d("sss",result.toString());
                    banner.setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            Result result1= (Result) path;

                            Glide.with(MainActivity.this).load(result1.getImageUrl()).into(imageView);
                        }
                    });
                    banner.setImages(result);
                    banner.setDelayTime(2000);
                    banner.isAutoPlay(true);
                    banner.start();
                }
            });
        }
        plist.setMode(PullToRefreshListView.Mode.BOTH);
        plist.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                    HttpUtil.getAsyncTask(sss, new HttpUtil.Cannback() {
                        @Override
                        public void getClass(String s) {
                            Gson gson=new Gson();
                            gson.fromJson(s,JavaBean.class);
                        }
                    });
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

            }
        });

    }

}
