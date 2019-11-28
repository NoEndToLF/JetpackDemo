package com.wxy.jetpackdemo.lifecycle.observer;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

public class Test implements LifecycleObserver {
    private String TAG="Test";
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate(LifecycleOwner owner) {
        Log.v(TAG,"onCreate");

    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy( LifecycleOwner owner) {
        Log.v(TAG,"onDestroy");

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public void onLifecycleChanged( LifecycleOwner owner,
                             Lifecycle.Event event) {
        Log.v(TAG,"ON_ANY");

    }
}
