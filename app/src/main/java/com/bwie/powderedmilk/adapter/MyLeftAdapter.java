package com.bwie.powderedmilk.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwie.powderedmilk.R;
import com.bwie.powderedmilk.bean.LeftBean;


/**
 * Created by asus on 2017/3/4.
 */
public class MyLeftAdapter extends BaseAdapter {
    Context context;
    LeftBean leftBean;

    public MyLeftAdapter(Context context, LeftBean leftBean) {
        this.context = context;
        this.leftBean = leftBean;
    }

    @Override
    public int getCount() {
        return leftBean.getRs().size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = View.inflate(context, R.layout.leftfragment_item,null);
        }
        TextView item_tv = (TextView) view.findViewById(R.id.leftfragment_item_tv);
        item_tv.setText(leftBean.getRs().get(i).getDirName());
        return view;
    }
}
