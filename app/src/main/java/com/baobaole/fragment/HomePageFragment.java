package com.baobaole.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baobaole.R;
import com.baobaole.activity.TtsDemo;
import com.baobaole.adapter.HomeRecyleViewAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by sumpay on 16/7/13.
 */
public class HomePageFragment extends BaseFragment {

    private RecyclerView recyclerView ;
    private List<String> nameList = new ArrayList<String>();
    private HomeRecyleViewAdapter recyleViewAdapter ;
    private TextToSpeech mSpeech;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_page_fragment, null);

        initView(view);
        initData();
        mSpeech = new TextToSpeech(getActivity(), new TextToSpeech.OnInitListener() {

            @Override
            public void onInit(int status) {
                // TODO Auto-generated method stub
                if (status == TextToSpeech.SUCCESS) {
                    int result = mSpeech.setLanguage(Locale.ENGLISH);
                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("lanageTag", "not use");
                    } else {
                    }
                }
            }
        });
        return view;
    }

    private void initView(View view)
    {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        //设置为垂直布局，这也是默认的
        gridLayoutManager.setOrientation(OrientationHelper. VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyleViewAdapter = new HomeRecyleViewAdapter(nameList,getActivity());
        recyleViewAdapter.setOnItemClickListener(new HomeRecyleViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position){
                        case 0 :
                            break;
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                    //    speechDemo.notifyNewMessage("山上有个庙庙里有个老和尚，老尚和跟小和尚讲故事，山上有个庙庙里有个和尚");
                       //     speechDemo.notifyNewMessage("asdfgghjkllnnyyttrrreeeetthggggvvvv");
//                            mSpeech.speak("山上有个庙庙里有个老和尚，老尚和跟小和尚讲故事，山上有个庙庙里有个和尚",
//                                    TextToSpeech.QUEUE_FLUSH, null);
                            Intent intent = new Intent(getActivity(), TtsDemo.class);
                            startActivity(intent);
                            break;
                    }
            }
        });
        recyclerView.setAdapter(recyleViewAdapter);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(){

            @Override
            public int getSpanSize(int position) {
                return recyleViewAdapter.isHead(position)?gridLayoutManager.getSpanCount():1;
            }
        });


    }

    private void initData(){
        nameList.clear();
        nameList.add("游戏");
        nameList.add("营养");
        nameList.add("智力");
        nameList.add("互动");
        recyleViewAdapter.notifyDataSetChanged();
    }




    @Override
    public void onStart() {
        super.onStart();

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
       //
        if (mSpeech != null) {
            mSpeech.stop();
            mSpeech.shutdown();
        }

    }
}
