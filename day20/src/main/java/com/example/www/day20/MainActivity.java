package com.example.www.day20;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.example.www.day20.fragment.Frag01;
import com.example.www.day20.fragment.Frag02;
import com.example.www.day20.fragment.Frag03;
import com.example.www.day20.fragment.Frag04;

public class MainActivity extends BaseActivity{

    private RadioGroup radioGroup;
    private Frag01 frag01;
    private Frag02 frag02;
    private Frag03 frag03;
    private Frag04 frag04;
    private FragmentManager manager;

    @Override
    public int bindlayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        radioGroup = findViewById(R.id.radio_group);

    }

    @Override
    protected void initData() {
        frag01 = new Frag01();
        frag02 = new Frag02();
        frag03 = new Frag03();
        frag04 = new Frag04();
        manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.frame,frag01).add(R.id.frame,frag02).add(R.id.frame,frag03).add(R.id.frame,frag04)
                .show(frag01).hide(frag02).hide(frag03).hide(frag04).commit();
    }

    @Override
    protected void bindEvent() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction = manager.beginTransaction();
                switch (checkedId){
                    case R.id.rb1:
                        transaction.show(frag01).hide(frag02).hide(frag03).hide(frag04);
                        break;
                    case R.id.rb2:
                        transaction.show(frag02).hide(frag01).hide(frag03).hide(frag04);
                        break;
                    case R.id.rb3:
                        transaction.show(frag03).hide(frag02).hide(frag01).hide(frag04);
                        break;
                    case R.id.rb4:
                        transaction.show(frag04).hide(frag02).hide(frag03).hide(frag01);
                        break;

                }
                transaction.commit();
            }
        });
    }
}
