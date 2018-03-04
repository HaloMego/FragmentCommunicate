package com.uma.mvp_demo.struct;

/**
 * Created by AlphaGo on 2018/3/4 【dot】
 */

public abstract class FunctionOnlyWithResult<Result> extends Function {

    public FunctionOnlyWithResult(String mFucntionName) {
        super(mFucntionName);
    }

    public abstract Result function();
}
