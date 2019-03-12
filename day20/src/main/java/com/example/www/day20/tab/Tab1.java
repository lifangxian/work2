package com.example.www.day20.tab;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.www.day20.BaseFragement;
import com.example.www.day20.Dao.SqlHelpter;
import com.example.www.day20.HttpUtil;
import com.example.www.day20.R;
import com.example.www.day20.adapater.MyAdapater;
import com.example.www.day20.jiexi.CommodityList;
import com.example.www.day20.jiexi.Javabean;
import com.example.www.day20.jiexi.Result;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.sql.SQLData;
import java.util.ArrayList;

public class Tab1 extends BaseFragement {
    String strs="https://api.apiopen.top/videoCategory";
    String str="http://172.17.8.100/small/commodity/v1/commodityList";
    private PullToRefreshListView plist;
    private SQLiteDatabase database;
    private MyAdapater adapater;
    private ArrayList<CommodityList> arrayList;

    @Override
    public int bindlayout() {
        return R.layout.tab1;
    }

    @Override
    protected void initView() {
        plist = bindView(R.id.plist);
        plist.setMode(PullToRefreshBase.Mode.BOTH);
        plist.setPullToRefreshOverScrollEnabled(true);
        //创建表
        SqlHelpter sqlHelpter = new SqlHelpter(getActivity());
        database = sqlHelpter.getReadableDatabase();
    }

    @Override
    protected void initData() {

                //有网的时候加载数据
                if(HttpUtil.isNetworkConnected(getActivity())){
                    HttpUtil.getAsyncTask(str, new HttpUtil.Callbacks() {



                        @Override
                        public void getClass(String s) {
                            Log.d("s",s);
                            Cursor cursor = database.query("users", null, null, null, null, null, null);
                            if(!cursor.moveToFirst()){
                                ContentValues values = new ContentValues();
                                values.put("title",s);
                                database.insert("users",null,values);
                            }
                            //解析
                            Gson gson=new Gson();
                            Javabean javabean = gson.fromJson(s, Javabean.class);
                            Result result = javabean.getResult();

                            ArrayList<CommodityList> pzsh = result.getPzsh().getCommodityList();
                            ArrayList<CommodityList> mlss = result.getMlss().getCommodityList();
                            ArrayList<CommodityList> rxxp = result.getRxxp().getCommodityList();
                            arrayList = new ArrayList<>();

                            arrayList.addAll(mlss);
                            arrayList.addAll(pzsh);
                            arrayList.addAll(rxxp);
                            //创建适配器
                            adapater = new MyAdapater(getActivity(), arrayList);
                            plist.setAdapter(adapater);
                        }
                    });
                }else{
                    Cursor cursor = database.query("users", null, null, null, null, null, null);
                    if(cursor.moveToFirst()){
                        String ss = cursor.getString(cursor.getColumnIndex("title"));
                        Gson gson=new Gson();
                        Javabean javabean = gson.fromJson(ss, Javabean.class);
                        Result result = javabean.getResult();
                        ArrayList<CommodityList> mlss = result.getMlss().getCommodityList();
                        ArrayList<CommodityList> pzsh = result.getPzsh().getCommodityList();
                        ArrayList<CommodityList> rxxp = result.getRxxp().getCommodityList();
                        ArrayList<CommodityList> nlist=new ArrayList<>();
                        nlist.addAll(mlss);
                        nlist.addAll(pzsh);
                        nlist.addAll(rxxp);

                        MyAdapater nadapater=new MyAdapater(getActivity(),nlist);
                        plist.setAdapter(nadapater);
                    }
                }

    }

    @Override
    protected void bindEvent() {
        plist.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                if(HttpUtil.isNetworkConnected(getActivity())){
                    HttpUtil.getAsyncTask(str, new HttpUtil.Callbacks() {
                        @Override
                        public void getClass(String s) {
                            Gson gson=new Gson();
                            Javabean javabean = gson.fromJson(s, Javabean.class);
                            Result result = javabean.getResult();
                            ArrayList<CommodityList> mlss = result.getMlss().getCommodityList();
                            ArrayList<CommodityList> pzsh = result.getPzsh().getCommodityList();
                            ArrayList<CommodityList> rxxp = result.getRxxp().getCommodityList();
                            arrayList=new ArrayList<>();
                            arrayList.addAll(mlss);
                            arrayList.addAll(pzsh);
                            arrayList.addAll(rxxp);
                            adapater=new MyAdapater(getActivity(),arrayList);
                            plist.setAdapter(adapater);
                            plist.onRefreshComplete();
                        }
                    });
                }
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                    if(HttpUtil.isNetworkConnected(getActivity())){
                        HttpUtil.getAsyncTask(str, new HttpUtil.Callbacks() {
                            @Override
                            public void getClass(String s) {
                                Gson gson=new Gson();
                                Javabean javabean = gson.fromJson(s, Javabean.class);
                                Result result = javabean.getResult();
                                ArrayList<CommodityList> mlss = result.getMlss().getCommodityList();
                                ArrayList<CommodityList> pzsh = result.getPzsh().getCommodityList();
                                ArrayList<CommodityList> rxxp = result.getRxxp().getCommodityList();
                                ArrayList<CommodityList> nlist=new ArrayList<>();
                                nlist.addAll(mlss);
                                nlist.addAll(pzsh);
                                nlist.addAll(rxxp);
                                arrayList.addAll(nlist);
                                adapater.notifyDataSetChanged();
                                plist.onRefreshComplete();
                            }
                        });
                    }
            }
        });
    }
}
