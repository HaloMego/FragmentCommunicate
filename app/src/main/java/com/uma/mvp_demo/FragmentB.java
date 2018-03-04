package com.uma.mvp_demo;

import android.app.Fragment;
import android.os.Bundle;

/**
 * Created by AlphaGo on 2018/3/4 【dot】
 */

public class FragmentB  extends BaseFragment{
    public static final String Instance = FragmentB.class.getName() + "_OnlyWithResult";
    public static FragmentB newInstance() {
        
        Bundle args = new Bundle();
        
        FragmentB fragment = new FragmentB();
        fragment.setArguments(args);
        return fragment;
    }


    public void onButtonPressed() {
        functionManager.invoke(Instance, String.class);
    }
}
