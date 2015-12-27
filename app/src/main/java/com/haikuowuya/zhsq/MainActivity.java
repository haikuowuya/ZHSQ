package com.haikuowuya.zhsq;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.haikuowuya.core.base.BaseHKWYActivity;
import com.haikuowuya.core.base.BaseHKWYFragment;
import com.haikuowuya.core.base.BaseHKWYSlidingMenuActivity;
import com.haikuowuya.core.slidingmenu.SlidingMenu;
import com.haikuowuya.core.util.DensityUtils;
import com.haikuowuya.core.util.ViewUtils;
import com.haikuowuya.zhsq.fragment.MainFragment;
import com.haikuowuya.zhsq.fragment.MenuFragment;

public class MainActivity extends BaseHKWYSlidingMenuActivity
{
    private MenuFragment mMenuFragment;

    public static void actionMain(BaseHKWYActivity activity)
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
        return "";
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
        initCenter();
        initRight();
    }

    @Override
    public void onBackPressed()
    {
        if (mSlidingMenu.isMenuShowing())
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
