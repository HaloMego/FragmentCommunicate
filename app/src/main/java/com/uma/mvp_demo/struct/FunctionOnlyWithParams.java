package com.uma.mvp_demo.struct;

/**
 * Created by AlphaGo on 2018/3/4 【dot】
 */

public abstract class FunctionOnlyWithParams<Param> extends Function {
    public FunctionOnlyWithParams(String mFucntionName) {
        super(mFucntionName);
    }

    public abstract void function(Param param );
}
