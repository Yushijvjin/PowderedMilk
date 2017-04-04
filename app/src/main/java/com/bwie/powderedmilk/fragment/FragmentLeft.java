package com.bwie.powderedmilk.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.bwie.powderedmilk.R;
import com.bwie.powderedmilk.adapter.MyLeftAdapter;
import com.bwie.powderedmilk.bean.LeftBean;
import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.List;

/**
 * 1. 类的用途
 * 2. @author： 李小兵
 * 3. @date：2017/4/4 18:40
 */

public class FragmentLeft extends Fragment{

    private ListView left_lv;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String qq = (String) msg.obj;
            Gson gson = new Gson();
            leftBean = gson.fromJson(qq, LeftBean.class);
            left_lv.setAdapter(new MyLeftAdapter(getActivity(), leftBean));
        }
    };
    private LeftBean leftBean;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_left,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        left_lv = (ListView) view.findViewById(R.id.left_lv);
        initData();
        okok();
    }

    private void okok() {
        //创建okHttpClient对象
        OkHttpClient mOkHttpClient = new OkHttpClient();
        //创建一个Request
        final Request request = new Request.Builder()
                .url("http://mock.eoapi.cn/success/4q69ckcRaBdxhdHySqp2Mnxdju5Z8Yr4")
                .build();
        //new call
        Call call = mOkHttpClient.newCall(request);
        //请求加入调度
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                String htmlStr =  response.body().string();
                handler.obtainMessage(0,htmlStr).sendToTarget();
            }
        });

    }

    private void initData() {
        left_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), ""+leftBean.getRs().get(i).getDirName(), Toast.LENGTH_SHORT).show();
                List<LeftBean.RsBean.ChildrenBean> children = leftBean.getRs().get(i).getChildren();
                FragmentManager fragmentManager = getFragmentManager();
                Fragment fragmentright = fragmentManager.findFragmentById(R.id.fragmentright);
                FragmentRight fragmentRight = (FragmentRight) fragmentright;
                fragmentRight.setList(children);
            }
        });
    }
}
