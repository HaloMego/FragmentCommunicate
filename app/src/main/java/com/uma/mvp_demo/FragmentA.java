package com.uma.mvp_demo;

import android.app.Fragment;
import android.os.Bundle;

/**
 * Created by AlphaGo on 2018/3/4 【dot】
 */

public class FragmentA extends BaseFragment {
    public static final String Instance = FragmentA.class.getName() + "NoParamsNoResult";

    public static FragmentA newInstance() {

        Bundle args = new Bundle();

        FragmentA fragment = new FragmentA();
        fragment.setArguments(args);
        return fragment;
    }

    public void onButtonPressed() {
        functionManager.invokeFunc(Instance);
    }

}
