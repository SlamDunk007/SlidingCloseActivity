package com.example.guannan.slidingcloseactivity;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by guannan on 2017/7/26.
 */

public class SlidingActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding);

    }

    @Override
    protected boolean enableRightSliding() {
        return true;
    }
}
