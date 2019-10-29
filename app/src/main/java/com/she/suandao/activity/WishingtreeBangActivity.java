package com.she.suandao.activity;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.mrj.framworklib.utils.OkHttpCallBack;
import com.she.suandao.R;
import com.she.suandao.base.BaseFragmentActivity;

import butterknife.OnClick;

/**
 * 愿望排行榜
 */
public class WishingtreeBangActivity extends BaseFragmentActivity implements OkHttpCallBack {



    @Override
    protected int getLayoutResId() {
        return R.layout.wishtree_activity_bang;
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.btn_back, R.id.introduct})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.introduct:
                Dialog dialog = createSingleBtnTipDialog();
                dialog.show();
                break;
        }
    }

    private Dialog createSingleBtnTipDialog() {
        final Dialog dialog = new Dialog(this, R.style.base_AlertDialog);
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.wishtree_dialog_smbang, null);
        dialog.setContentView(view);
        Button button = view.findViewById(R.id.wishtree_bang_know);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        return dialog;
    }


    @Override
    public void onSuccess(String requestUrl, String resultStr) {

    }

    @Override
    public void onFailed(Exception e) {

    }



}
