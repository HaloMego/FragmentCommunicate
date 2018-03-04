package com.uma.mvp_demo.struct;

/**
 * Created by AlphaGo on 2018/3/4 【dot】
 */

public abstract class FunctionResultAndParams<Param, Result> extends Function {
    public FunctionResultAndParams(String mFucntionName) {
        super(mFucntionName);
    }

    public abstract Result function(Param param);
}
