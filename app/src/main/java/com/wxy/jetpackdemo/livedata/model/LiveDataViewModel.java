package com.wxy.jetpackdemo.livedata.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LiveDataViewModel extends ViewModel {
    private MutableLiveData<NameModel> mutableLiveData;

    public NameModel getNameModel() {
        return nameModel;
    }

    public void setNameModel(NameModel nameModel) {
        this.nameModel = nameModel;
        mutableLiveData.postValue(nameModel);
    }

    private NameModel nameModel;
    public LiveDataViewModel() {
        mutableLiveData=new MutableLiveData<>();
    }

    public MutableLiveData<NameModel> getMutableLiveData() {
        return mutableLiveData;
    }


    public static class NameModel{
        private String name;

        public NameModel(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
