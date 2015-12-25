package com.haikuowuya.zhsq;

import android.os.Bundle;

import com.haikuowuya.core.base.BaseHKWYFragment;
import com.haikuowuya.core.base.BaseHKWYTitleActivity;
import com.haikuowuya.zhsq.fragment.WelcomeFragment;

/**
 * Created by Administrator on 2015/12/25 0025.
 */
public class WelcomeActivity extends BaseHKWYTitleActivity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        hideTitleContainer();
    }

    @Override
    public void afterOnCreate(Bundle savedInstanceState)
    {
        super.afterOnCreate(savedInstanceState);
        setSwipeBackEnable(false);
    }

    @Override
    public BaseHKWYFragment fragmentAsView()
    {
        return WelcomeFragment.newInstance();
    }

    @Override
    public CharSequence getActivityTitle()
    {
        return getString(R.string.activity_welcome_title);
    }
}
