package com.wxy.jetpackdemo.lifecycle.observer;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

public class MyLifecycleObserver implements DefaultLifecycleObserver {
    private String TAG="MyLifecycleObserver";
    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        Log.v(TAG,"onCreate");
    }

    @Override
    public void onStart(@NonNull LifecycleOwner owner) {
        Log.v(TAG,"onStart");

    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        Log.v(TAG,"onResume");

    }

    @Override
    public void onPause(@NonNull LifecycleOwner owner) {
        Log.v(TAG,"onPause");
    }

    @Override
    public void onStop(@NonNull LifecycleOwner owner) {
        Log.v(TAG,"onStop");
    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {
        Log.v(TAG,"onDestroy");

    }
}
