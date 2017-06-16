package com.walnutin.xtht.bracelet.mvp.ui.activity.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.UiUtils;
import com.walnutin.xtht.bracelet.R;
import com.walnutin.xtht.bracelet.mvp.ui.activity.MainActivity;
import com.walnutin.xtht.bracelet.mvp.ui.activity.di.component.DaggerLoadComponent;
import com.walnutin.xtht.bracelet.mvp.ui.activity.di.module.LoadModule;
import com.walnutin.xtht.bracelet.mvp.ui.activity.mvp.contract.LoadContract;
import com.walnutin.xtht.bracelet.mvp.ui.activity.mvp.presenter.LoadPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class LoadActivity extends BaseActivity<LoadPresenter> implements LoadContract.View {


    @BindView(R.id.bt_regist)
    Button btRegist;
    @BindView(R.id.bt_load)
    Button btLoad;

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        DaggerLoadComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .loadModule(new LoadModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        return R.layout.activity_load; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    @OnClick({R.id.bt_regist, R.id.bt_load})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_regist:
                startActivity(new Intent(LoadActivity.this, MainActivity.class));
                break;
            case R.id.bt_load://点击保存按钮
                startActivity(new Intent(LoadActivity.this, MainActivity.class));
                break;
        }
    }


    @Override
    public void initData(Bundle savedInstanceState) {

    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        UiUtils.SnackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        UiUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }



}