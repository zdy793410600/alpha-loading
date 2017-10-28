package com.icourt.app.loading.test;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.icourt.loading.AlphaLoading;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
//        final AlphaMessage alphaMessage = AlphaMessage.makeLoading(this, "我在加载...");
//        alphaMessage.show();
//
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                alphaMessage.setMessage("正在上传....");
//            }
//        }, 1000);
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
////                alphaMessage.dismissOk();
////                alphaMessage.dismissFail();
//                alphaMessage.dismiss();
//                AlphaMessage.makeOk(MainActivity.this, "保存成功").show();
//            }
//        }, 2000);


        final AlphaLoading alphaLoading = new AlphaLoading.Builder(this)
                .message("我在加载...")
                .cancelable(true)
                .resultDuration(1000)
                .create();
//        alphaLoading.setMessage("我在加载...");
        alphaLoading.dismissImmediately();
        alphaLoading.dismissOk("111111");
        alphaLoading.show();
        alphaLoading.show();

//        alphaLoading.dismissImmediately();
//        alphaLoading.dismissOk("成功");
//        alphaLoading.dismissFail("加载失败");

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                alphaLoading.setMessage("正在上传图片...");
            }
        }, 1000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                alphaLoading.show();
                if (new Random().nextBoolean()) {
                    alphaLoading.dismissOk("成功");
                } else {
                    alphaLoading.dismissFail("加载失败了");
                }
                alphaLoading.show();
            }
        }, 1000);

//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                alphaLoading.dismissImmediately();
//            }
//        }, 800);    // 1800
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onClick2(View view) {
        startActivity(new Intent(this, DetailActivity.class));
    }
}