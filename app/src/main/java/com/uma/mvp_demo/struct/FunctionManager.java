package com.uma.mvp_demo.struct;

import android.text.TextUtils;

import java.util.HashMap;

/**
 * Created by AlphaGo on 2018/3/4 【dot】
 */

@SuppressWarnings("unchecked")
public class FunctionManager {
    private static final FunctionManager ourInstance = new FunctionManager();

    public static FunctionManager getInstance() {
        return ourInstance;
    }

    private FunctionManager() {
        mFunctionNoParamsNoResult = new HashMap<>();
        mFunctionOnlyWithParams = new HashMap<>();
        mFunctionResultAndParams = new HashMap<>();
        mFunctionOnlyWithResult = new HashMap<>();
    }

    private HashMap<String, FunctionNoParamsNoResult> mFunctionNoParamsNoResult;
    private HashMap<String, FunctionOnlyWithParams> mFunctionOnlyWithParams;
    private HashMap<String, FunctionResultAndParams> mFunctionResultAndParams;
    private HashMap<String, FunctionOnlyWithResult> mFunctionOnlyWithResult;

    public FunctionManager addFunction(FunctionNoParamsNoResult functionNoParamsNoResult) {
        mFunctionNoParamsNoResult.put(functionNoParamsNoResult.mFucntionName, functionNoParamsNoResult);
        return this;
    }

    public FunctionManager addFunction(FunctionOnlyWithResult functionOnlyWithResult) {
        mFunctionOnlyWithResult.put(functionOnlyWithResult.mFucntionName, functionOnlyWithResult);
        return this;
    }

    public FunctionManager addFunction(FunctionOnlyWithParams functionOnlyWithParams) {
        mFunctionOnlyWithParams.put(functionOnlyWithParams.mFucntionName, functionOnlyWithParams);
        return this;
    }

    public FunctionManager addFunction(FunctionResultAndParams functionResultAndParams) {
        mFunctionResultAndParams.put(functionResultAndParams.mFucntionName, functionResultAndParams);
        return this;
    }


    public void invokeFunc(String functionName) {
        if (TextUtils.isEmpty(functionName)) {
            return;

        }
        if (mFunctionNoParamsNoResult != null) {
            FunctionNoParamsNoResult functionNoParamsNoResult = mFunctionNoParamsNoResult.get(functionName);
            if (functionNoParamsNoResult != null) {
                functionNoParamsNoResult.function();
            }
            if (functionNoParamsNoResult == null) {
                throw new FunctionException("Has No");
            }
        }

    }

    public <Result> Result invoke(String functionName, Class<Result> clazz) {
        if (TextUtils.isEmpty(functionName)) {
            return null;

        }
        if (mFunctionOnlyWithResult != null) {
            FunctionOnlyWithResult functionOnlyWithResult = mFunctionOnlyWithResult.get(functionName);
            if (functionOnlyWithResult != null) {
                return clazz.cast(functionOnlyWithResult.function());
            } else {
                return (Result) functionOnlyWithResult.function();
            }

        } else {
            throw new FunctionException("Has No");
        }

    }

    public <Params> void invoke(String functionName, Params params) {
        if (TextUtils.isEmpty(functionName)) {
            return;

        }
        if (mFunctionOnlyWithParams != null) {
            FunctionOnlyWithParams functionOnlyWithParams = mFunctionOnlyWithParams.get(functionName);
            if (functionOnlyWithParams != null) {
                functionOnlyWithParams.function(params);
            }

        } else {
            throw new FunctionException("Has No");
        }

    }


    public <Params, Result> Result invoke(String functionName, Params params, Class<Result> clazz) {
        if (TextUtils.isEmpty(functionName)) {
            return null;

        }
        if (mFunctionResultAndParams != null) {
            FunctionResultAndParams functionResultAndParams = mFunctionResultAndParams.get(functionName);
            if (clazz != null) {
                return clazz.cast(functionResultAndParams.function(params));
            } else {
                return (Result) functionResultAndParams.function(params);

            }


        } else {
            throw new FunctionException("Has No");
        }

    }
}
