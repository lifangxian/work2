package com.example.www.week3.adapater;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.www.week3.R;
import com.example.www.week3.bean.CommodityList;

import java.util.ArrayList;

public class LgAdapater extends BaseAdapter {
    private Context context;
    private ArrayList<CommodityList> arrayList;

    public LgAdapater(Context context, ArrayList<CommodityList> arrayList) {
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
        ViewHolder holder;
        if(convertView==null){
            convertView = View.inflate(context, R.layout.item, null);
            holder=new ViewHolder();
            holder.imageView=convertView.findViewById(R.id.imageview);
            holder.textView = convertView.findViewById(R.id.textview);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(arrayList.get(position).getMasterPic()).into(holder.imageView);
        holder.textView.setText(arrayList.get(position).getCommodityName());
        return convertView;
    }
    class ViewHolder{
        private ImageView imageView;
        private TextView textView;
    }
}
