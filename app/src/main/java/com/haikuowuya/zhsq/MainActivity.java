package com.haikuowuya.zhsq;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.haikuowuya.core.base.BaseHKWYActivity;
import com.haikuowuya.core.base.BaseHKWYFragment;
import com.haikuowuya.core.base.BaseHKWYSlidingMenuActivity;
import com.haikuowuya.core.slidingmenu.SlidingMenu;
import com.haikuowuya.core.util.ViewUtils;
import com.haikuowuya.zhsq.fragment.MainFragment;
import com.haikuowuya.zhsq.fragment.MenuFragment;

public class MainActivity extends BaseHKWYSlidingMenuActivity
{
    private MenuFragment mMenuFragment;

    public static  void  actionMain(BaseHKWYActivity activity)
    {
        Intent intent = new Intent(activity, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        activity.startActivity(intent);
        activity.finish();
    }


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

    @Override
    public void onBackPressed()
    {
        if(mSlidingMenu.isMenuShowing())
        {
            mSlidingMenu.showContent();
            return;
        }
        super.onBackPressed();
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
