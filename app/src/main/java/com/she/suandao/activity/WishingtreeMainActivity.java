package com.she.suandao.activity;

import android.app.Dialog;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.mrj.framworklib.utils.OkHttpCallBack;
import com.she.suandao.R;
import com.she.suandao.base.BaseFragmentActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.OnClick;

/**
 * 愿望树
 */
public class WishingtreeMainActivity extends BaseFragmentActivity implements OkHttpCallBack {


    List<View> viewList;
    List<View> views = new ArrayList();


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_wishingtree_main;
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.wishtree_main_bang, R.id.btn_back, R.id.introduct, R.id.btn_mywish, R.id.btn_wishCard})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.introduct:
                Dialog dialog = createSingleBtnTipDialog(WishingtreeMainActivity.this);
                dialog.show();
                break;
            case R.id.wishtree_main_bang:
                startAct(WishingtreeBangActivity.class);
                break;
            case R.id.btn_mywish:
                startAct(WishingMywishActivity.class);
                break;
            case R.id.btn_wishCard:
                startAct(WishingCardActivity.class);
                break;


        }
    }


    private Dialog createSingleBtnTipDialog(Context context) {
        final Dialog dialog = new Dialog(context, R.style.base_AlertDialog);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.wishingtree_dialog_introduct, null);
        dialog.setContentView(view);
        ViewPager viewPager = view.findViewById(R.id.vp_content);
        final LinearLayout linearLayout = view.findViewById(R.id.view_point);

        View view1 = inflater.inflate(R.layout.wishingtree_view_home_intoduct_one, null);
        View view2 = inflater.inflate(R.layout.wishingtree_view_home_intoduct_two, null);
        View view3 = inflater.inflate(R.layout.wishingtree_view_home_intoduct_third, null);
        View view4 = inflater.inflate(R.layout.wishingtree_view_home_intoduct_fourth, null);
        View view5 = inflater.inflate(R.layout.wishingtree_view_home_intoduct_fifth, null);
        viewList = new ArrayList();
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewList.add(view4);
        viewList.add(view5);
        GuideAdapter adapter = new GuideAdapter();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < linearLayout.getChildCount(); i++) {
                    if(i == position){
                        linearLayout.getChildAt(i).setBackgroundResource(R.mipmap.wishingtree_point_yellow);
                    }else{
                        linearLayout.getChildAt(i).setBackgroundResource(R.mipmap.wishingtree_point_grey);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(viewList.size());

        return dialog;
    }


    @Override
    public void onSuccess(String requestUrl, String resultStr) {

    }

    @Override
    public void onFailed(Exception e) {

    }





    class GuideAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return viewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = viewList.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
