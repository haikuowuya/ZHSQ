package com.haikuowuya.zhsq.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.haikuowuya.zhsq.R;
import com.haikuowuya.zhsq.base.BaseFragment;
import com.haikuowuya.zhsq.view.CircleMenu;
import com.haikuowuya.zhsq.view.MenuItem;

import butterknife.Bind;

/**
 * Created by Steven on 2015/11/3 0003.
 */
public class MainFragment extends BaseFragment
{
    public static MainFragment newInstance()
    {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Bind(R.id.cm_circle_menu)
    CircleMenu mCircleMenu;
    private String[] mItemTexts = new String[]{"安全中心 ", "特色服务", "投资理财", "特色服务", "安全中心 "};
    private int[] mItemImgs = new int[]{R.drawable.home_mbank_1_normal, R.drawable.home_mbank_2_normal, R.drawable.home_mbank_3_normal, R.drawable.home_mbank_2_normal, R.drawable.home_mbank_1_normal};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_main, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        mCircleMenu.setRotating(true);//是否启用旋转
        mCircleMenu.setItems(mItemTexts, mItemImgs);//显示文字及图标
        //circleMenu.setItems(itemIcons);//只显示图标
        mCircleMenu.setIconSize(60);//图标大小，单位为px
        mCircleMenu.setCenterImage(R.drawable.turnplate_center_unlogin);//中间圆环内图标
        mCircleMenu.setOnItemClickListener(new CircleMenu.OnItemClickListener()
        {
            @Override
            public void onItemClick(MenuItem view)
            {
                Toast.makeText(mActivity, mItemTexts[view.getPosition()], Toast.LENGTH_SHORT).show();
            }
        });
        mCircleMenu.setOnCenterClickListener(new CircleMenu.OnCenterClickListener()
        {
            @Override
            public void onCenterClick()
            {
                Toast.makeText(mActivity, "点击圆环中心", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public String getFragmentTitle()
    {
        return "首页";
    }

}
