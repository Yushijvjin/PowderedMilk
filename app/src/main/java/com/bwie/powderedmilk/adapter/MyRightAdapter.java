package com.bwie.powderedmilk.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwie.powderedmilk.R;
import com.bwie.powderedmilk.bean.LeftBean;
import com.bwie.powderedmilk.view.MyGridView;

import java.util.List;


/**
 * Created by asus on 2017/3/5.
 */
public class MyRightAdapter extends BaseAdapter {
    Context context;
    List<LeftBean.RsBean.ChildrenBean> list;

    public MyRightAdapter(Context context, List<LeftBean.RsBean.ChildrenBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
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
            view = View.inflate(context, R.layout.rightlv_item,null);
        }
        TextView tv = (TextView) view.findViewById(R.id.rightlv_item_tv);
        MyGridView gv = (MyGridView) view.findViewById(R.id.rightlv_item_gv);
        tv.setText(list.get(i).getDirName());
        List<LeftBean.RsBean.ChildrenBean> children = list.get(i).getChildren();
        gv.setAdapter(new MyGvAdapter(context,children));

        return view;
    }
}
