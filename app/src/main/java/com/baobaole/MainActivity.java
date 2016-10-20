package com.baobaole;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TabHost;
import android.widget.TextView;

import com.baobaole.fragment.EnglishPageFragment;
import com.baobaole.fragment.HomePageFragment;
import com.baobaole.fragment.KnowladgePageFragment;
import com.baobaole.fragment.MinePageFragment;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;

public class MainActivity extends FragmentActivity {

    //定义FragmentTabHost对象
    private FragmentTabHost mTabHost;

    private TextView titleTxt ;

    private ImageButton backButton ;

    private Class fragment[] = {HomePageFragment.class, EnglishPageFragment.class, KnowladgePageFragment.class, MinePageFragment.class};

    //Tab选项卡的文字
    private String mTextviewArray[] = {"首页", "英语", "识字", "我的"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SpeechUtility.createUtility(MainActivity.this, SpeechConstant.APPID +"=57fef996");
        initView();
    }

    private void initView() {
        //实例化TabHost对象，得到TabHost
        mTabHost = (FragmentTabHost) findViewById(R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        titleTxt =(TextView)findViewById(R.id.title_txt);
        titleTxt.setText("首页");
        backButton =(ImageButton) findViewById(R.id.back_btn);
        backButton.setVisibility(View.GONE);

        //得到fragment的个数
        int count = fragment.length;

        for (int i = 0; i < count; i++) {
            //为每一个Tab按钮设置图标、文字和内容
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(mTextviewArray[i]).setIndicator(mTextviewArray[i]);
            //将Tab按钮添加进Tab选项卡中
            mTabHost.addTab(tabSpec, fragment[i], null);
        }
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                if(s.equals("首页")){
                    titleTxt.setText("首页");
                }else if(s.equals("英语")){
                    titleTxt.setText("英语");
                }else if(s.equals("识字")){
                    titleTxt.setText("识字");
                }else {
                    titleTxt.setText("我的");
                }
            }
        });
    }

}
