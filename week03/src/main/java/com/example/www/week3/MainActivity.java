package com.example.www.week3;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.www.week3.adapater.LgAdapater;
import com.example.www.week3.base.BaseActivity;
import com.example.www.week3.bean.CommodityList;
import com.example.www.week3.bean.Javabean;
import com.example.www.week3.bean.Mlss;
import com.example.www.week3.bean.Pzsh;
import com.example.www.week3.bean.Result;
import com.example.www.week3.bean.Rxxp;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {


    private Banner banner;
    private GridView gridView;
    private PullToRefreshListView plist;
    private String bannerUrl = "https://api.apiopen.top/musicRankings?tdsourcetag=s_pcqq_aiomsg";
    private String listviewUrl = "http://172.17.8.100/small/commodity/v1/commodityList";
    private ArrayList<CommodityList> arrayList;
    private LgAdapater adapater;
    private ArrayList<String> list;

    @Override
    public int bindlayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        banner = findViewById(R.id.banner);
        gridView = findViewById(R.id.gridview);
        plist = findViewById(R.id.pull);
        list = new ArrayList<>();
        list.add("http://172.17.8.100/images/small/banner/cj.png");
        list.add("http://172.17.8.100/images/small/banner/lyq.png");
        list.add("http://172.17.8.100/images/small/banner/px.png");
        list.add("http://172.17.8.100/images/small/banner/px.png");
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        });
        //图片集和
        banner.setImages(list);
        //图片是否轮播
        banner.isAutoPlay(true);
        //设置上拉刷新下拉加载
        banner.setDelayTime(2000);
        banner.start();

        plist.setMode(PullToRefreshBase.Mode.BOTH);
        //在没有网络的时候列表依然可以滑必须设置成true，否则没有网络就不能滑动列表
        plist.setPullToRefreshOverScrollEnabled(true);
        //设置列表上拉加载下拉刷新
        plist.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                HttpUtil.httpAsynTask(listviewUrl, new HttpUtil.Callbanck() {
                    @Override
                    public void getClass(String s) {
                        Gson gson=new Gson();
                        Javabean javabean = gson.fromJson(s, Javabean.class);

                        Result result = javabean.getResult();
                        Mlss mlss = result.getMlss();
                        Pzsh pzsh = result.getPzsh();
                        Rxxp rxxp = result.getRxxp();

                        ArrayList<CommodityList> arrayList = new ArrayList<CommodityList>();
                        arrayList.addAll(mlss.getCommodityList());
                        arrayList.addAll(pzsh.getCommodityList());
                        arrayList.addAll(rxxp.getCommodityList());
                        adapater = new LgAdapater(MainActivity.this, arrayList);
                        plist.setAdapter(adapater);
                        //gridview
                        gridView.setAdapter(adapater);
                        plist.onRefreshComplete();
                    }
                });
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                    HttpUtil.httpAsynTask(listviewUrl, new HttpUtil.Callbanck() {
                        @Override
                        public void getClass(String s) {
                            Gson gson=new Gson();
                            Javabean javabean = gson.fromJson(s, Javabean.class);

                            Result result = javabean.getResult();
                            Mlss mlss = result.getMlss();
                            Pzsh pzsh = result.getPzsh();
                            Rxxp rxxp = result.getRxxp();

                            ArrayList<CommodityList> al = new ArrayList<CommodityList>();
                            al.addAll(mlss.getCommodityList());
                            al.addAll(pzsh.getCommodityList());
                            al.addAll(rxxp.getCommodityList());
                            arrayList.addAll(al);
                            adapater = new LgAdapater(MainActivity.this, arrayList);
                            adapater.notifyDataSetChanged();
                            //gridview
                            plist.onRefreshComplete();
                        }
                    });
            }
        });
    }

    @Override
    protected void initData() {
        HttpUtil.httpAsynTask(listviewUrl, new HttpUtil.Callbanck() {
            @Override
            public void getClass(String s) {
                Gson gson=new Gson();
                Javabean javabean = gson.fromJson(s, Javabean.class);

                Result result = javabean.getResult();
                Mlss mlss = result.getMlss();
                Pzsh pzsh = result.getPzsh();
                Rxxp rxxp = result.getRxxp();

                arrayList = new ArrayList<CommodityList>();
                arrayList.addAll(mlss.getCommodityList());
                arrayList.addAll(pzsh.getCommodityList());
                arrayList.addAll(rxxp.getCommodityList());
                //设置适配器
                adapater = new LgAdapater(MainActivity.this, arrayList);
                plist.setAdapter(adapater);
                //gridview
                gridView.setAdapter(adapater);

            }
        });
    }

    @Override
    protected void bindEvent() {

    }
}
