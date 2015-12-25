package com.haikuowuya.zhsq;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.haikuowuya.core.base.BaseHKWYFragment;
import com.haikuowuya.core.base.BaseHKWYSlidingMenuActivity;
import com.haikuowuya.core.slidingmenu.SlidingMenu;
import com.haikuowuya.core.util.ViewUtils;
import com.haikuowuya.zhsq.fragment.MainFragment;
import com.haikuowuya.zhsq.fragment.MenuFragment;

public class MainActivity extends BaseHKWYSlidingMenuActivity
{

    private MenuFragment mMenuFragment;

    @Override
    public BaseHKWYFragment fragmentAsView()
    {
        return MainFragment.newInstance();
    }

    @Override
    public CharSequence getActivityTitle()
    {
        return "首页";
    }

    @Override
    public BaseHKWYFragment fragmentAsMenu()
    {
        mMenuFragment = MenuFragment.newInstance();
        return mMenuFragment;
    }

    @Override
    public void afterOnCreate(Bundle savedInstanceState)
    {
        super.afterOnCreate(savedInstanceState);
        mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        initBack();
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
                mSlidingMenu.toggle();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (null != mMenuFragment)
        {
            mMenuFragment.onActivityResult(requestCode, resultCode, data);
        }
    }
}
