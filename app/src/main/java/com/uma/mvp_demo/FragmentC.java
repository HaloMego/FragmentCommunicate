package com.uma.mvp_demo;

import android.app.Fragment;
import android.os.Bundle;

/**
 * Created by AlphaGo on 2018/3/4 【dot】
 */

public class FragmentC extends BaseFragment {
    public static final String instance = FragmentC.class.getName();

    public static FragmentC newInstance() {

        Bundle args = new Bundle();

        FragmentC fragment = new FragmentC();
        fragment.setArguments(args);
        return fragment;
    }

    public void onButtonPressed() {
        functionManager.invoke(instance, "hahah", String.class);
    }
}

