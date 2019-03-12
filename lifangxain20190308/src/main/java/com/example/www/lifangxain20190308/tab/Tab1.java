package com.example.www.lifangxain20190308.tab;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.ListView;

import com.example.www.lifangxain20190308.BaseFragment;
import com.example.www.lifangxain20190308.HttpUtil;
import com.example.www.lifangxain20190308.R;
import com.example.www.lifangxain20190308.adapater.MyAdapater;
import com.example.www.lifangxain20190308.bean.Data;
import com.example.www.lifangxain20190308.bean.Data1;
import com.example.www.lifangxain20190308.bean.Javabean;
import com.example.www.lifangxain20190308.sql.Sqlhelper;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;

public class Tab1 extends BaseFragment {

    String str="http://365jia.cn/news/api3/365jia/news/categories/hotnews?page=1";
    private PullToRefreshListView plist;
    private SQLiteDatabase database;
    private ArrayList<Data1> arrayList;
    private MyAdapater adapater;
    @Override
    public int bindlayout() {
        return R.layout.tab1;
    }

    @Override
    protected void initView() {
        plist = bindView(R.id.plist);
        plist.setMode(PullToRefreshBase.Mode.BOTH);
        plist.setPullToRefreshOverScrollEnabled(true);
        //创建数据库
        Sqlhelper sqlhelper = new Sqlhelper(getActivity());
        database = sqlhelper.getReadableDatabase();
    }

    @Override
    protected void initData() {
        if(HttpUtil.isNetworkConnected(getActivity())){
            HttpUtil.getAsyncTask(str, new HttpUtil.Callbackss() {




                @Override
                public void getClass(String s) {
                    Cursor cursor = database.query("users", null, null, null, null, null, null);
                    if(!cursor.moveToFirst()){
                        ContentValues values = new ContentValues();
                        values.put("title",s);
                        database.insert("uses",null,values);
                    }
                    Gson gson=new Gson();
                    Javabean javabean = gson.fromJson(s, Javabean.class);
                    Data data = javabean.getData();
                    ArrayList<Data1> data1 = data.getData();
                    arrayList = new ArrayList<>();
                    arrayList.addAll(data1);
                    adapater = new MyAdapater(getActivity(),arrayList);
                    plist.setAdapter(adapater);
                }
            });
        }else{
            Cursor cursor = database.query("users", null, null, null, null, null, null);
            if(cursor.moveToFirst()){
                String ss = cursor.getString(cursor.getColumnIndex("title"));
                Gson gson=new Gson();
                Javabean javabean = gson.fromJson(ss, Javabean.class);
                Data data = javabean.getData();
                ArrayList<Data1> data1 = data.getData();

                ArrayList<Data1> nlist=new ArrayList<>();
                nlist.addAll(data1);
                MyAdapater adapater=new MyAdapater(getActivity(),nlist);
                plist.setAdapter(adapater);
            }
        }
    }

    @Override
    protected void bindEvent() {
        plist.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                if(HttpUtil.isNetworkConnected(getActivity())){
                    HttpUtil.getAsyncTask(str, new HttpUtil.Callbackss() {
                        @Override
                        public void getClass(String s) {
                            Gson gson=new Gson();
                            Javabean javabean = gson.fromJson(s, Javabean.class);
                            Data data = javabean.getData();
                            ArrayList<Data1> data1 = data.getData();
                            arrayList = new ArrayList<>();
                            arrayList.addAll(data1);
                            adapater = new MyAdapater(getActivity(),arrayList);
                            plist.setAdapter(adapater);
                            plist.onRefreshComplete();
                        }
                    });
                }
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                if(HttpUtil.isNetworkConnected(getActivity())){
                    HttpUtil.getAsyncTask(str, new HttpUtil.Callbackss() {
                        @Override
                        public void getClass(String s) {
                            Gson gson=new Gson();
                            Javabean javabean = gson.fromJson(s, Javabean.class);
                            Data data = javabean.getData();
                            ArrayList<Data1> data1 = data.getData();

                            ArrayList<Data1> nlist=new ArrayList<>();
                            nlist.addAll(data1);
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
