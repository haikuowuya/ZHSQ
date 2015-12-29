package com.haikuowuya.zhsq.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.haikuowuya.core.base.BaseHKWYFragment;
import com.haikuowuya.core.util.DensityUtils;
import com.haikuowuya.zhsq.MainActivity;
import com.haikuowuya.zhsq.Pref;
import com.haikuowuya.zhsq.R;
import com.haikuowuya.zhsq.base.BaseFragment;
import com.haikuowuya.zhsq.view.CirclePageIndicator;

import butterknife.Bind;

/***
 * 欢迎引导页
 */
public class WelcomeFragment extends BaseFragment
{
    public static WelcomeFragment newInstance()
    {
        WelcomeFragment fragment = new WelcomeFragment();
        return fragment;
    }

    @Bind(R.id.vp_viewpager)
    ViewPager mViewPager;
    @Bind(R.id.cpi_indicator)
    CirclePageIndicator mCirclePageIndicator;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_welcome, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        mViewPager.setAdapter(new WelcomeFragmentPagerAdapter(getChildFragmentManager()));
        mCirclePageIndicator.setRadius(DensityUtils.dpToPx(mActivity, 5.5f));
        mCirclePageIndicator.setViewPager(mViewPager);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {

            }

            @Override
            public void onPageSelected(int position)
            {
                mCirclePageIndicator.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state)
            {

            }
        });
    }

    @Override
    public String getFragmentTitle()
    {
        return "菜单";
    }

    public static class WelcomeFragmentPagerAdapter extends FragmentPagerAdapter
    {
        public WelcomeFragmentPagerAdapter(FragmentManager fm)
        {
            super(fm);
        }

        @Override
        public Fragment getItem(int position)
        {
            return FragmentItem.newInstance(position);
        }

        @Override
        public int getCount()
        {
            return 3;
        }
    }

    public static class FragmentItem extends BaseHKWYFragment
    {
        public static final String ARG_POSITION = "position";

        public static FragmentItem newInstance(int position)
        {
            FragmentItem fragmentItem = new FragmentItem();
            Bundle bundle = new Bundle();
            bundle.putInt(ARG_POSITION, position);
            fragmentItem.setArguments(bundle);
            return fragmentItem;
        }

        private ImageView mImageView;
        private TextView mTvStart;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
        {
            View view = inflater.inflate(R.layout.fragment_welcom_item, container, false);
            initView(view);
            return view;
        }

        private void initView(View view)
        {
            mImageView = (ImageView) view.findViewById(R.id.iv_image);
            mTvStart = (TextView) view.findViewById(R.id.tv_start);
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState)
        {
            super.onActivityCreated(savedInstanceState);
            mTvStart.setVisibility(View.GONE);
            int postion = getArguments().getInt(ARG_POSITION, 0);
            switch (postion)
            {
                case 0:
                    mImageView.setImageResource(R.mipmap.ic_welcome_0);
                    mImageView.setBackgroundColor(0xFF9B58B5);
                    break;
                case 1:
                    mImageView.setImageResource(R.mipmap.ic_welcome_1);
                    mImageView.setBackgroundColor(0xFF45D07F);
                    mImageView.setScaleType(ImageView.ScaleType.FIT_END);
                    break;
                case 2:
                    mImageView.setImageResource(R.mipmap.ic_welcome_2);
                    mImageView.setBackgroundColor(0xFF278DD0);
                    mTvStart.setVisibility(View.VISIBLE);
                    mTvStart.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            MainActivity.actionMain(mActivity);
                            mActivity.getPreferences().edit().putBoolean(Pref.PREF_FIRST_RUN, false).commit();
                        }
                    });
                    break;
            }

        }

        @Override
        public String getFragmentTitle()
        {
            return "引导页";
        }
    }

}
