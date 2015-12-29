package com.haikuowuya.zhsq;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.haikuowuya.core.base.BaseHKWYActivity;
import com.haikuowuya.core.base.BaseHKWYFragment;
import com.haikuowuya.core.base.BaseHKWYTitleActivity;
import com.haikuowuya.zhsq.fragment.WelcomeFragment;

/**
 * Created by Administrator on 2015/12/25 0025.
 */
public class WelcomeActivity extends BaseHKWYTitleActivity
{
    private static final String EXTRA_SHOW_WELCOME = "show_welcome";

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        if (!getIntent().getBooleanExtra(EXTRA_SHOW_WELCOME, false))
        {
            if (!getSharedPreferences(getPackageName(), Context.MODE_PRIVATE).getBoolean(Pref.PREF_FIRST_RUN, true))
            {
                MainActivity.actionMain(this);
                finish();
            }
        }
        super.onCreate(savedInstanceState);
        hideTitleContainer();
    }

    public static void actionWelcome(BaseHKWYActivity activity)
    {
        Intent intent = new Intent(activity, WelcomeActivity.class);
        intent.putExtra(EXTRA_SHOW_WELCOME, true);
        activity.startActivity(intent);
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
