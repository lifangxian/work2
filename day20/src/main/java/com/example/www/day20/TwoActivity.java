package com.example.www.day20;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.www.day20.adapater.GridAdapater;

import java.util.ArrayList;

public class TwoActivity extends BaseActivity {


    private GridView grid1;
    private GridView grid2;
    private ImageView imageView;
    private ImageView wanc;
    private ArrayList<String> list1;
    private ArrayList<String> list2;
    private GridAdapater gridAdapater1;
    private GridAdapater gridAdapater2;



    @Override
    public int bindlayout() {
        return R.layout.activity_two;
    }

    @Override
    protected void initView() {
        grid1 = bindView(R.id.grid1);
        grid2 = bindView(R.id.grid2);
        imageView = bindView(R.id.imageview2);
        wanc = bindView(R.id.wanc);

    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        list1 = intent.getStringArrayListExtra("key");
        list2 = new ArrayList<>();
        for(int i=0;i<10;i++){
            list2.add("hello"+i);
        }
        list2.remove(list1);

        gridAdapater1 = new GridAdapater(TwoActivity.this,list1);
        gridAdapater2 = new GridAdapater(TwoActivity.this,list2);
        grid1.setAdapter(gridAdapater1);
        grid2.setAdapter(gridAdapater2);
    }

    @Override
    protected void bindEvent() {
        grid1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = list1.get(position);
                list1.remove(s);
                list2.add(s);
                gridAdapater1.notifyDataSetChanged();
                gridAdapater2.notifyDataSetChanged();
            }
        });
        grid2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = list2.get(position);
                list2.remove(s);
                list1.add(s);
                gridAdapater2.notifyDataSetChanged();
                gridAdapater1.notifyDataSetChanged();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putStringArrayListExtra("key",list1);
                setResult(100,intent);
                finish();

            }
        });

        wanc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putStringArrayListExtra("key",list1);
                setResult(100,intent);
                finish();
            }
        });
    }
}
