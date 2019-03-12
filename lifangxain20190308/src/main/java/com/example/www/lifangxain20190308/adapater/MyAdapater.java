package com.example.www.lifangxain20190308.adapater;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.www.lifangxain20190308.R;
import com.example.www.lifangxain20190308.bean.Data1;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyAdapater extends BaseAdapter {
    private Context context;
    private ArrayList<Data1> arrayList;

    public MyAdapater(Context context, ArrayList<Data1> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type=getItemViewType(position);
        switch (type){
            case 0:
                ViewHolder holder;
                if(convertView==null){
                    convertView = View.inflate(context, R.layout.item1, null);
                    holder=new ViewHolder();
                    holder.textView1=convertView.findViewById(R.id.textview1);
                    holder.textView2=convertView.findViewById(R.id.textview2);
                    holder.textView3=convertView.findViewById(R.id.textview3);
                    convertView.setTag(holder);
                }else{
                    holder = (ViewHolder) convertView.getTag();
                }
                holder.textView1.setText(arrayList.get(position).getTitle());
                holder.textView2.setText(arrayList.get(position).getType());
                holder.textView3.setText(arrayList.get(position).getLink());

                break;
            case 1:
                ViewHolder1 holder1;
                if(convertView==null){
                    convertView = View.inflate(context, R.layout.item2, null);
                    holder1=new ViewHolder1();
                    holder1.text1=convertView.findViewById(R.id.textview11);
                    holder1.text2=convertView.findViewById(R.id.textview22);
                    convertView.setTag(holder1);
                }else {
                    holder1 = (ViewHolder1) convertView.getTag();
                }
                holder1.text1.setText(arrayList.get(position).getType());
                holder1.text2.setText(arrayList.get(position).getTitle());
                break;
        }


        return convertView;
    }
    class ViewHolder{
        private TextView textView1;
        private TextView textView2;
        private TextView textView3;
    }
    class ViewHolder1{
        private TextView text1;
        private TextView text2;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return position%2;
    }
}
