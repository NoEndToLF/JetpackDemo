package com.wxy.jetpackdemo.livedata.fragment;

import android.os.Bundle;
import android.widget.TextView;

import com.wxy.jetpackdemo.R;
import com.wxy.jetpackdemo.base.BaseFragment;
import com.wxy.jetpackdemo.livedata.model.LiveDataViewModel;
import com.wxy.jetpackdemo.viewmodel.model.MyViewModel;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.OnClick;

public class LiveDataFragmentTwo extends BaseFragment {
    @BindView(R.id.tv_two)
    TextView tvTwo;
    private LiveDataViewModel liveDataViewModel;

    @Override
    public int getLayoutId() {
        liveDataViewModel = ViewModelProviders.of(getActivity()).get(LiveDataViewModel.class);
        liveDataViewModel.getMutableLiveData().observe(this, new Observer<LiveDataViewModel.NameModel>() {
            @Override
            public void onChanged(LiveDataViewModel.NameModel nameModel) {
                tvTwo.setText(nameModel.getName());
            }
        });
        return R.layout.fragment_livedata_two;
    }

    @OnClick(R.id.tv_two)
    public void onViewClicked() {
        liveDataViewModel.setNameModel(new LiveDataViewModel.NameModel("我是LiveDataFragmentTwo"));

    }
}
