package com.haikuowuya.zhsq.base;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.haikuowuya.core.base.BaseHKWYTitleActivity;
import com.haikuowuya.core.util.DensityUtils;
import com.haikuowuya.core.util.ViewUtils;
import com.haikuowuya.zhsq.R;

public abstract  class BaseImageTitleActivity extends BaseHKWYTitleActivity
{
    @Override
    public CharSequence getActivityTitle()
    {
        return "";
    }


    @Override
    public void afterOnCreate(Bundle savedInstanceState)
    {
        super.afterOnCreate(savedInstanceState);

        initBack();
        initCenter();
        initRight();
    }



    /***
     * 初始化首页左侧按钮的点击事件
     */
    private void initBack()
    {
        ImageView ivBack = (ImageView) findViewById(R.id.iv_back);
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setImageResource(R.mipmap.ic_menu_menu);
        int padding = ViewUtils.getActionBarHeight(mActivity) / 4;
        ivBack.setPadding(padding, padding, padding, padding);
        ivBack.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                onBackPressed();
            }
        });
    }
     private void initCenter()
     {
         RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relative_title_container);
         ImageView imageView = new ImageView(mActivity);
         RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
         layoutParams.alignWithParent = true;
         layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
         layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
         layoutParams.addRule(RelativeLayout.LEFT_OF, R.id.iv_right);
         layoutParams.addRule(RelativeLayout.RIGHT_OF, R.id.iv_back);
         imageView.setImageResource(R.mipmap.ic_nav_logo);
         imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
         int paddingLRTB = DensityUtils.dpToPx(mActivity, 8);
         imageView.setPadding(paddingLRTB, paddingLRTB, paddingLRTB, paddingLRTB);
         relativeLayout.addView(imageView, layoutParams);

     }
    private void initRight()
    {
        ImageView ivRight = (ImageView) findViewById(R.id.iv_right);
        ivRight.setVisibility(View.VISIBLE);
        ivRight.setImageResource(R.mipmap.ic_title_user);
        int padding = ViewUtils.getActionBarHeight(mActivity) / 4;
        ivRight.setPadding(padding, padding, padding, padding);
        ivRight.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mActivity.showToast("用户");
            }
        });
    }

}
