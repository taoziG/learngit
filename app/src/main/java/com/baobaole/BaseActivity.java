package com.baobaole;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by sumpay on 16/7/13.
 */
public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initEvent();
    }

    protected abstract void initView();
    protected  abstract void initData();
    protected abstract void initEvent();

}
