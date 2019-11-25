package com.wxy.jetpackdemo.viewmodel.model;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MyViewModel extends ViewModel {
    private String name;

    public MyViewModel(String mKey) {
        this.mKey = mKey;
    }

    private String mKey;

    public String getName() {
        return name;
    }

    public String getKey() {
        return mKey;
    }
    public void setName(String name) {
        this.name = name;
    }
    public static class Factory implements ViewModelProvider.Factory {
        private String mKey;
        public Factory(String key) {
            mKey = key;
        }
        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            return (T) new MyViewModel(mKey);
        }
    }



}
