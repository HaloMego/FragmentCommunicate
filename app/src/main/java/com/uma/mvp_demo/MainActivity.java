package com.uma.mvp_demo;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.uma.mvp_demo.struct.FunctionManager;
import com.uma.mvp_demo.struct.FunctionNoParamsNoResult;
import com.uma.mvp_demo.struct.FunctionOnlyWithResult;
import com.uma.mvp_demo.struct.FunctionResultAndParams;

/**
 * 万能接口
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setFunctionForFrament(String tag){
        FragmentManager fragmentManager = getFragmentManager();
        BaseFragment fragment = (BaseFragment) fragmentManager.findFragmentByTag(tag);
        FunctionManager instance = FunctionManager.getInstance();
        fragment.setFunctionManager(instance.addFunction(new FunctionNoParamsNoResult(FragmentA.Instance) {
            @Override
            public void function() {
                Toast.makeText(MainActivity.this,"成功调用",Toast.LENGTH_SHORT).show();
            }
        }).addFunction(new FunctionOnlyWithResult<String>(FragmentB.Instance) {
            @Override
            public String function() {
                return "111111111";
            }
        }).addFunction(new FunctionResultAndParams<String,String>(FragmentC.instance) {

            @Override
            public String function(String s) {
                return "heihei"+s;
            }
        }));

    }
}
