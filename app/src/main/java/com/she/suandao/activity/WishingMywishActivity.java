package com.she.suandao.activity;

import android.app.Dialog;
import android.view.View;

import com.mrj.framworklib.utils.OkHttpCallBack;
import com.she.suandao.R;
import com.she.suandao.base.BaseFragmentActivity;

import butterknife.OnClick;

/**
 * 我的愿望
 */
public class WishingMywishActivity  extends BaseFragmentActivity implements OkHttpCallBack {


    @Override
    protected int getLayoutResId() {
        return R.layout.wishingtree_activity_mywish;
    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.btn_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
        }
    }

    @Override
    public void onSuccess(String requestUrl, String resultStr) {

    }

    @Override
    public void onFailed(Exception e) {

    }

}
