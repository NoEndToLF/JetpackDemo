package com.wxy.jetpackdemo.viewmodel.fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.wxy.jetpackdemo.R;
import com.wxy.jetpackdemo.base.BaseFragment;
import com.wxy.jetpackdemo.lifecycle.observer.MyLifecycleObserver;
import com.wxy.jetpackdemo.viewmodel.model.MyViewModel;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import butterknife.OnClick;

public class FragmentOne extends BaseFragment {
    @Override
    public int getLayoutId() {
        return R.layout.fragment_one;
    }
    @OnClick(R.id.tv_one)
    public void onViewClicked() {
        MyViewModel myViewModel = ViewModelProviders.of(getActivity(),new MyViewModel.Factory("myViewModel")).get("myViewModel",MyViewModel.class);

        myViewModel.setName("FragmentOne");
        Toast.makeText(getActivity(), "修改myViewModel的name为 FragmentOne", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
