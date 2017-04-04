package com.bwie.powderedmilk.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.powderedmilk.R;
import com.bwie.powderedmilk.bean.LeftBean;
import com.lidroid.xutils.BitmapUtils;

import java.util.List;


/**
 * Created by asus on 2017/3/5.
 */
public class MyGvAdapter extends BaseAdapter {
    Context context;
    List<LeftBean.RsBean.ChildrenBean> children;

    public MyGvAdapter(Context context, List<LeftBean.RsBean.ChildrenBean> children) {
        this.context = context;
        this.children = children;
    }

    @Override
    public int getCount() {
        return children.size();
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = View.inflate(context, R.layout.mygv_item,null);
        }
        TextView tv = (TextView) view.findViewById(R.id.gv_tv);
        ImageView iv = (ImageView) view.findViewById(R.id.gv_iv);
        tv.setText(children.get(i).getDirName());
        String imgApp = children.get(i).getImgApp();
        BitmapUtils bitmap = new BitmapUtils(context);
        bitmap.display(iv,children.get(i).getImgApp());
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, ""+children.get(i).getDirName(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
