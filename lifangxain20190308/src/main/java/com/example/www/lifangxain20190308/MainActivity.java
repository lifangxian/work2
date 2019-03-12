package com.example.www.lifangxain20190308;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.example.www.lifangxain20190308.fragment.Frag1;
import com.example.www.lifangxain20190308.fragment.Frag2;
import com.example.www.lifangxain20190308.fragment.Frag3;

public class MainActivity extends BaseActivity {


    private RadioGroup radioGroup;
    private Frag1 frag1;
    private Frag2 frag2;
    private Frag3 frag3;
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
        frag1 = new Frag1();
        frag2 = new Frag2();
        frag3 = new Frag3();
        manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.frame,frag1).add(R.id.frame,frag2).add(R.id.frame,frag3)
                .show(frag1).hide(frag2).hide(frag3).commit();
    }

    @Override
    protected void bindEvent() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction = manager.beginTransaction();
                switch (checkedId){
                    case R.id.rb1:
                        transaction.show(frag1).hide(frag2).hide(frag3);
                        break;
                    case R.id.rb2:
                        transaction.show(frag2).hide(frag1).hide(frag3);
                        break;
                    case R.id.rb3:
                        transaction.show(frag3).hide(frag2).hide(frag1);
                        break;
                }
                transaction.commit();
            }
        });
    }
}
