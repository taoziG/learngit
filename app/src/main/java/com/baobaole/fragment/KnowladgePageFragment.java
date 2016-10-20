package com.baobaole.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baobaole.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sumpay on 16/7/13.
 */
public class KnowladgePageFragment extends BaseFragment {

    private ViewPager knowladge_viewpage ;
    private  View  view1 ,view2 ,view3 ;

    private List<View> viewList ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.knowledge_page_fragment,null);
        initView(view);
        initData();
        return view;
    }

    private void initView(View view){
        knowladge_viewpage =(ViewPager)view.findViewById(R.id.knowladge_viewpage);
    }

    private void initData(){

        LayoutInflater inflater =getActivity().getLayoutInflater();
        view1 = inflater.inflate(R.layout.viewpage_item_one,null);
        view2= inflater.inflate(R.layout.viewpage_item_two,null);
        view3= inflater.inflate(R.layout.viewpage_item_three,null);
        viewList = new ArrayList<View>();

        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);

        PagerAdapter pagerAdapter  = new PagerAdapter() {
            @Override
            public int getCount() {
                return viewList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view== object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(viewList.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(viewList.get(position));
                return viewList.get(position);
            }
        };

        knowladge_viewpage.setAdapter(pagerAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        knowladge_viewpage.setCurrentItem(0);
    }
}
