package com.haikuowuya.zhsq.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.haikuowuya.zhsq.R;
import com.haikuowuya.zhsq.adapter.main.MainGridAdapter;
import com.haikuowuya.zhsq.base.BaseFragment;
import com.haikuowuya.zhsq.view.CircleMenu;
import com.haikuowuya.zhsq.view.MenuItem;

import java.util.LinkedList;
import java.util.List;

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
    @Bind(R.id.gv_gridview)
    GridView mGridView;
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

        setGridView();
    }

    private void setGridView()
    {
        mGridView.setNumColumns(4);
        mGridView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mGridView.setAdapter(new MainGridAdapter(mActivity,genGridData()));
    }

    private List<MainGridAdapter.TextIconItem> genGridData()
    {

        LinkedList<MainGridAdapter.TextIconItem> iconItems = new LinkedList<>();
        iconItems.add(new MainGridAdapter.TextIconItem(R.mipmap.ic_main_kuaidi,"快递"));
        iconItems.add(new MainGridAdapter.TextIconItem(R.mipmap.ic_main_yuding,"预定"));
        iconItems.add(new MainGridAdapter.TextIconItem(R.mipmap.ic_main_game,"游戏"));
        iconItems.add(new MainGridAdapter.TextIconItem(R.mipmap.ic_main_settings,"设置"));
        return  iconItems;
    }

    @Override
    public String getFragmentTitle()
    {
        return "首页";
    }

}
