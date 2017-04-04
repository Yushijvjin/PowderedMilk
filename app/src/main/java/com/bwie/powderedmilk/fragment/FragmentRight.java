package com.bwie.powderedmilk.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bwie.powderedmilk.R;
import com.bwie.powderedmilk.adapter.MyRightAdapter;
import com.bwie.powderedmilk.bean.LeftBean;

import java.util.List;


/**
 * Created by asus on 2017/3/4.
 */

public class FragmentRight extends Fragment{

    private List<LeftBean.RsBean.ChildrenBean> list;
    private ListView right_lv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_right,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        right_lv = (ListView) view.findViewById(R.id.right_lv);
    }

    public void setList(final List<LeftBean.RsBean.ChildrenBean> list) {
        this.list = list;
        right_lv.setAdapter(new MyRightAdapter(getActivity(),list));
    }
}
