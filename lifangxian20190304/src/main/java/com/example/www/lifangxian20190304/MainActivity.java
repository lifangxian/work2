package com.example.www.lifangxian20190304;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Banner banner;
    private GridView gridView;
    private PullToRefreshListView plist;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        banner = findViewById(R.id.banner);
        gridView = findViewById(R.id.gridview);
        plist = findViewById(R.id.plist);
        arrayList = new ArrayList<>();
        arrayList.add("http://172.17.8.100/images/small/banner/cj.png");
        arrayList.add("http://172.17.8.100/images/small/banner/lyq.png");
        arrayList.add("http://172.17.8.100/images/small/banner/px.png");
        arrayList.add("http://172.17.8.100/images/small/banner/wy.png");
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        });
        banner.setImages(arrayList);
        banner.isAutoPlay(true);
        banner.setDelayTime(2000);
        banner.start();
        HttpUtil.httpAsyncTask();
    }

}
