package com.wxy.jetpackdemo.livedata.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LiveDataViewModel extends ViewModel {
    private MutableLiveData<String> mutableLiveData;
    private String name;
    public LiveDataViewModel() {
        mutableLiveData=new MutableLiveData<>();
    }

    public MutableLiveData<String> getMutableLiveData() {
        return mutableLiveData;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        mutableLiveData.postValue(name);
    }
}
