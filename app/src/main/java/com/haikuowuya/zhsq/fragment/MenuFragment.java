package com.haikuowuya.zhsq.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.haikuowuya.core.util.PhotoUtils;
import com.haikuowuya.zhsq.R;
import com.haikuowuya.zhsq.adapter.menu.MenuRecyclerAdapter;
import com.haikuowuya.zhsq.base.BaseFragment;

import java.util.LinkedList;

import butterknife.Bind;
import butterknife.OnClick;

/***
 * 侧滑左侧的菜单
 */
public class MenuFragment extends BaseFragment
{
    public static MenuFragment newInstance()
    {
        MenuFragment fragment = new MenuFragment();
        return fragment;
    }

    @Bind(R.id.rv_recycler_view)
    RecyclerView mRecyclerView;
    @Bind(R.id.iv_photo)
    ImageView mImageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_menu, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mRecyclerView.setAdapter(new MenuRecyclerAdapter(mActivity, genMockData()));
    }

    /**
     * 点击头像事件
     */
    @OnClick(R.id.iv_photo)
    void onPhotoClcik()
    {
        PhotoUtils.showSelectDialog(mActivity);
    }

    @Override
    public String getFragmentTitle()
    {
        return "菜单";
    }

    private LinkedList<MenuRecyclerAdapter.MenuItem> genMockData()
    {
        LinkedList<MenuRecyclerAdapter.MenuItem> items = new LinkedList<>();
        items.add(new MenuRecyclerAdapter.MenuItem(R.mipmap.ic_launcher, "精选"));
        items.add(new MenuRecyclerAdapter.MenuItem(R.mipmap.ic_launcher, "商品"));
        items.add(new MenuRecyclerAdapter.MenuItem(R.mipmap.ic_launcher, "付款"));
        items.add(new MenuRecyclerAdapter.MenuItem(R.mipmap.ic_launcher, "社区"));
        items.add(new MenuRecyclerAdapter.MenuItem(R.mipmap.ic_launcher, "免费电话"));
        items.add(new MenuRecyclerAdapter.MenuItem(R.mipmap.ic_launcher, "关于本店"));
        return items;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (resultCode == Activity.RESULT_OK)
        {
            String croppedImagePath = PhotoUtils.getFinalCroppedImagePath();
            if (null != croppedImagePath)
            {
                mImageView.setImageBitmap(BitmapFactory.decodeFile(croppedImagePath));
            } else
            {
                System.out.println("图片选取失败");
            }
        }
    }
}
