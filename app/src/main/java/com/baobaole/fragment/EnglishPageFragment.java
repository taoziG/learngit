package com.baobaole.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.baobaole.R;
import com.baobaole.holder.NetworkImageHolderView;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sumpay on 16/7/13.
 */
public class EnglishPageFragment extends BaseFragment implements View.OnClickListener{


    private ConvenientBanner canvenient_banner;
    private List<String> imageUrlLists;
    private TextView animal_tv ,figure_tv,life_tv ,food_tv,movement_tv ,plant_tv ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.english_page_fragment,null);
        initView(view);
        initData();
        return view;
    }

    private void initView(View view){
        canvenient_banner = (ConvenientBanner) view.findViewById(R.id.canvenient_banner);
        Uri uri = Uri.parse("http://www.yejs.com.cn/upload2005/2007-11-9/20071191089377.jpg");
        animal_tv=(TextView) view.findViewById(R.id.animal_tv);
        figure_tv =(TextView) view.findViewById(R.id.figure_tv);
        life_tv =(TextView)view.findViewById(R.id.life_tv);
        food_tv=(TextView) view.findViewById(R.id.food_tv);
        movement_tv=(TextView)view.findViewById(R.id.movement_tv);
        plant_tv =(TextView)view.findViewById(R.id.plant_tv);
        animal_tv.setOnClickListener(this);
        figure_tv.setOnClickListener(this);
        life_tv.setOnClickListener(this);
        food_tv.setOnClickListener(this);
        movement_tv.setOnClickListener(this);
        plant_tv.setOnClickListener(this);

    }

    private void initData() {
        imageUrlLists = new ArrayList<String>();
        imageUrlLists.add("http://www.yejs.com.cn/upload2005/2007-11-9/20071191089377.jpg");
        imageUrlLists.add("http://www.yejs.com.cn/upload2005/2007-11-9/2007119101939386.jpg");
        imageUrlLists.add("http://www.yejs.com.cn/upload2005/2007-11-7/2007117113310348.jpg");
        imageUrlLists.add("http://www.yejs.com.cn/upload2005/2007-11-7/2007117113159393.jpg");
        imageUrlLists.add("http://www.yejs.com.cn/upload2005/2007-11-7/2007117113029889.jpg");

        canvenient_banner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
            @Override
            public NetworkImageHolderView createHolder() {
                return new NetworkImageHolderView();
            }
        }, imageUrlLists)
                .setPointViewVisible(true)
                .startTurning(3000)
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        Toast.makeText(getContext(), "你好", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.animal_tv:
                break;
            case R.id.figure_tv:
                break;
            case R.id.life_tv:
                break;
            case R.id.food_tv:
                break;
            case R.id.movement_tv:
                break;
            case R.id.plant_tv:
                break;
        }
    }
    private void goNext(Class nextActivity,String message){
        Intent intent = new Intent(getActivity(),nextActivity);
        intent.putExtra("message",message);
        startActivity(intent);
    }
}
