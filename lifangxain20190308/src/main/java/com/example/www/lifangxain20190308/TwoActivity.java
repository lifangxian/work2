package com.example.www.lifangxain20190308;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.www.lifangxain20190308.adapater.GridAdapater;

import java.util.ArrayList;

public class TwoActivity extends BaseActivity {

    private GridView grid1;
    private GridView grid2;
    private ImageView ok;
    private ArrayList<String> list2;
    private ArrayList<String> list1;
    private GridAdapater gridAdapater2;
    private GridAdapater gridAdapater1;

    @Override
    public int bindlayout() {
        return R.layout.activity_two;
    }

    @Override
    protected void initView() {
        grid1 = bindView(R.id.grid1);
        grid2 = bindView(R.id.grid2);
        ok = bindView(R.id.ok);

    }

    @Override
    protected void initData() {
        Intent intent=getIntent();
        list1 = intent.getStringArrayListExtra("key");
        list2 = new ArrayList<>();
        for (int i=0;i<10;i++){
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
                list1.remove(position);
                list2.add(s);
                gridAdapater1.notifyDataSetChanged();
                gridAdapater2.notifyDataSetChanged();
            }
        });
        grid2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = list2.get(position);
                list2.remove(position);
                list1.add(s);
                gridAdapater1.notifyDataSetChanged();
                gridAdapater2.notifyDataSetChanged();
            }
        });
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putStringArrayListExtra("key",list2);
                setResult(100,intent);
                finish();
            }
        });
    }
}
