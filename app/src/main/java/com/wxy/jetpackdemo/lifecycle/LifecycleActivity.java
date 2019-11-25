package com.wxy.jetpackdemo.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.wxy.jetpackdemo.R;
import com.wxy.jetpackdemo.lifecycle.observer.MyLifecycleObserver;
import com.wxy.jetpackdemo.lifecycle.observer.Test;

public class LifecycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        getLifecycle().addObserver(new MyLifecycleObserver());
        getLifecycle().addObserver(new Test());
    }
}
