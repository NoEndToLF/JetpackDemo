package com.wxy.jetpackdemo.livedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wxy.jetpackdemo.R;
import com.wxy.jetpackdemo.livedata.fragment.LiveDataFragmentOne;
import com.wxy.jetpackdemo.livedata.fragment.LiveDataFragmentTwo;
import com.wxy.jetpackdemo.livedata.model.LiveDataViewModel;
import com.wxy.jetpackdemo.viewmodel.fragment.VMFragmentOne;
import com.wxy.jetpackdemo.viewmodel.fragment.VMFragmentTwo;
import com.wxy.jetpackdemo.viewmodel.model.MyViewModel;

public class LiveDataActivity extends AppCompatActivity {
    @BindView(R.id.btn_send)
    Button btnSend;
    @BindView(R.id.btn_one)
    TextView btnOne;
    @BindView(R.id.btn_two)
    TextView btnTwo;
    private LiveDataFragmentOne liveDataFragmentOne;
    private LiveDataFragmentTwo liveDataFragmentTwo;
    private Fragment currentFragment=new Fragment();
    private LiveDataViewModel liveDataViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);
        ButterKnife.bind(this);
        liveDataViewModel = ViewModelProviders.of(this).get(LiveDataViewModel.class);
        liveDataViewModel.getMutableLiveData().observe(this, new Observer<LiveDataViewModel.NameModel>() {
            @Override
            public void onChanged(LiveDataViewModel.NameModel nameModel) {
                btnSend.setText(nameModel.getName());
            }
        });
        initFragment();
        showFragment(liveDataFragmentOne);
    }
    private void initFragment() {
        liveDataFragmentOne = (LiveDataFragmentOne) getSupportFragmentManager().findFragmentByTag(LiveDataFragmentOne.class.getName());
        if (liveDataFragmentOne == null) {
            liveDataFragmentOne = new LiveDataFragmentOne();
        }
        liveDataFragmentTwo = (LiveDataFragmentTwo) getSupportFragmentManager().findFragmentByTag(LiveDataFragmentTwo.class.getName());
        if (liveDataFragmentTwo == null) {
            liveDataFragmentTwo = new LiveDataFragmentTwo();
        }
    }
    private void showFragment(Fragment fragment) {
        if (currentFragment!=fragment){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.hide(currentFragment);//  不是则隐藏
            currentFragment=fragment;
            if (!fragment.isAdded()){
                transaction.add(R.id.linear_content,fragment,fragment.getClass().getName()).show(fragment).commit();
            }else {
                transaction.show(fragment).commit();
            }
        }
    }
    @OnClick({R.id.btn_send, R.id.btn_one, R.id.btn_two})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_send:
                liveDataViewModel.setNameModel(new LiveDataViewModel.NameModel("我是LiveDataActivity"));
                break;
            case R.id.btn_one:
                showFragment(liveDataFragmentOne);
                break;
            case R.id.btn_two:
                showFragment(liveDataFragmentTwo);
                break;
        }
    }
}
