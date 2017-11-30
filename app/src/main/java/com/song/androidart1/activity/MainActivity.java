package com.song.androidart1.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.song.androidart1.R;

import java.util.Arrays;

/**
 * 一个查看activity生命周期的例子，可以查看正常情况和异常情况(屏幕旋转或被杀死等)的周期
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            String test = savedInstanceState.getString("extra_test");
            Log.d(TAG, "[onCreate]restore extra_test:" + test);
        }


        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                Intent intent = new Intent("com.ryg.charpter_1.c");
                Intent intent = new Intent(MainActivity.this, FirstActivity.class);
//                intent.setClass(MainActivity.this, SecondActivity.class);
//                intent.putExtra("time", System.currentTimeMillis());
//                intent.addCategory("com.ryg.category.c");
//                intent.setDataAndType(Uri.parse("file://abc"), "text/plain");

                Bundle b1 = new Bundle();

                startActivity(intent);
            }
        });

        int[] nums = {2,100,1000,10,80,60,70,54,87,89};

        arrayPairSum(nums);
    }


    public int arrayPairSum(int[] nums) {
        // 2  1
        int temp;
        int sum = 0;
        for(int i=0;i<nums.length;i++){

            for(int j=0;j<nums.length-1;j++){

                if(nums[j] > nums[i]){
                    temp = nums[i];
                    nums[i] =nums[j];
                    nums[j] = temp;
                }
            }

            Log.e("Main", Arrays.toString(nums));

        }



        Arrays.sort(nums);


        for(int k=0;k<nums.length;k=k+2){

            sum += nums[k];
        }

        return sum;

    }


    @Override
    protected void onStart() {
        Log.d(TAG, "onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume");
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart");
        super.onRestart();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "onConfigurationChanged, newOrientation:" + newConfig.orientation);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");
        outState.putString("extra_test", "test");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //Log.d(TAG, "onRestoreInstanceState");
        String test = savedInstanceState.getString("extra_test");
        Log.d(TAG, "[onRestoreInstanceState]restore extra_test:" + test);
    }
}
