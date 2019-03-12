package com.example.www.day20.fragment;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.example.www.day20.BaseFragement;
import com.example.www.day20.R;
import com.example.www.day20.TwoActivity;
import com.example.www.day20.adapater.TabAdapater;
import com.example.www.day20.tab.Tab1;
import com.example.www.day20.tab.Tab2;

import java.util.ArrayList;

public class Frag01 extends BaseFragement {

    private ViewPager vp;
    private ImageView imageView;
    private TabLayout tab;
    private ArrayList<Fragment> list1;
    private ArrayList<String> list2;
    private TabAdapater adapater;

    @Override
    public int bindlayout() {
        return R.layout.frag01;
    }

    @Override
    protected void initView() {
        vp = bindView(R.id.viewpager);
        imageView = bindView(R.id.imageview);
        tab = bindView(R.id.tab);

    }

    @Override
    protected void initData() {
        list1 = new ArrayList<>();
        list1.add(new Tab1());
        list1.add(new Tab2());

        list2 = new ArrayList<>();
        for (int i=0;i<10;i++){
            list2.add("你好"+i);
        }
        adapater = new TabAdapater(getActivity().getSupportFragmentManager(),list1,list2);
        vp.setAdapter(adapater);
        tab.setupWithViewPager(vp);
    }

    @Override
    protected void bindEvent() {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),TwoActivity.class);
                //startActivity(intent);
                intent.putStringArrayListExtra("key",list2);
                startActivityForResult(intent,200);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==200){
            ArrayList<String> list = data.getStringArrayListExtra("key");
            list1.clear();
            list2.clear();
            tab.removeAllTabs();
            list2.addAll(list);
            for (int t=0;t<list2.size();t++){
                TabLayout.Tab tab1 = this.tab.newTab();
                tab1.setText(list2.get(t));
                tab.addTab(tab1);
                String s = list2.get(t);
                if(t==0){
                    list1.add(new Tab1());
                }else{
                    list1.add(new Tab2());
                }
            }
            adapater.notifyDataSetChanged();
            tab.setupWithViewPager(vp);
        }
    }
}
