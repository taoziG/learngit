package com.baobaole.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public class MinePageFragment extends BaseFragment {

    private ConvenientBanner canvenient_banner;
    private List<String> imageUrlLists;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mine_page_fragment, null);
        initView(view);
        initData();
        return view;
    }

    private void initView(View view) {
        canvenient_banner = (ConvenientBanner) view.findViewById(R.id.canvenient_banner);
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
}
