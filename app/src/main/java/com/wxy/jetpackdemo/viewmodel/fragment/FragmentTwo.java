package com.wxy.jetpackdemo.viewmodel.fragment;

import android.widget.Toast;

import com.wxy.jetpackdemo.R;
import com.wxy.jetpackdemo.base.BaseFragment;
import com.wxy.jetpackdemo.viewmodel.model.MyViewModel;

import androidx.lifecycle.ViewModelProviders;
import butterknife.OnClick;

public class FragmentTwo extends BaseFragment {
    @Override
    public int getLayoutId() {
        return R.layout.fragment_two;
    }

    @OnClick(R.id.tv_two)
    public void onViewClicked() {
        MyViewModel myViewModel = ViewModelProviders.of(getActivity(),new MyViewModel.Factory("myViewModel")).get("myViewModel",MyViewModel.class);
        Toast.makeText(getActivity(), "myViewModel的name: "+myViewModel.getName(), Toast.LENGTH_SHORT).show();
    }
}
