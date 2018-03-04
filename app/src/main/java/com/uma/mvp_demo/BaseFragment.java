package com.uma.mvp_demo;

import android.app.Fragment;
import android.content.Context;

import com.uma.mvp_demo.struct.FunctionManager;

/**
 * Created by AlphaGo on 2018/3/4 【dot】
 */

public class BaseFragment extends Fragment {
  protected   FunctionManager functionManager;
    private MainActivity mainActivity;
    public void setFunctionManager(FunctionManager functionManager) {
        this.functionManager = functionManager;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity){
           mainActivity = (MainActivity) context;
        }
    }
}
