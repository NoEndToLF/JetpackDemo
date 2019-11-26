package com.wxy.jetpackdemo.livedata.fragment;

import android.widget.TextView;

import com.wxy.jetpackdemo.R;
import com.wxy.jetpackdemo.base.BaseFragment;
import com.wxy.jetpackdemo.livedata.model.LiveDataViewModel;
import com.wxy.jetpackdemo.viewmodel.model.MyViewModel;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.OnClick;

public class LiveDataFragmentOne extends BaseFragment {
    @BindView(R.id.tv_one)
    TextView tvOne;
    private LiveDataViewModel liveDataViewModel;
    @Override
    public int getLayoutId() {
        liveDataViewModel = ViewModelProviders.of(getActivity()).get(LiveDataViewModel.class);
        liveDataViewModel.getMutableLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tvOne.setText(s);
            }
        });
        return R.layout.fragment_livedata_one;
    }
    @OnClick(R.id.tv_one)
    public void onViewClicked() {
        liveDataViewModel.setName("LiveDataFragmentOne");
    }
}
