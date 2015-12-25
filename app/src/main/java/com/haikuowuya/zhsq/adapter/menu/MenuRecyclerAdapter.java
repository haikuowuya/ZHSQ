package com.haikuowuya.zhsq.adapter.menu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.haikuowuya.core.base.BaseHKWYActivity;
import com.haikuowuya.zhsq.R;
import com.haikuowuya.zhsq.base.BaseItem;

import java.util.List;

/**
 * 菜单RecyclerView的适配器
 */
public class MenuRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private LayoutInflater mLayoutInflater;
    private List<MenuItem> mItemList;
    private BaseHKWYActivity mActivity;

    private OnRecyclerItemClickListener mOnRecyclerItemClickListener;

    public MenuRecyclerAdapter(BaseHKWYActivity activity, List<MenuItem> list)
    {
        mActivity = activity;
        mLayoutInflater = LayoutInflater.from(mActivity);
        mItemList = list;
    }

    public MenuRecyclerAdapter(BaseHKWYActivity activity, List<MenuItem> list, OnRecyclerItemClickListener onRecyclerItemClickListener)
    {
        mActivity = activity;
        mLayoutInflater = LayoutInflater.from(mActivity);
        mItemList = list;
        mOnRecyclerItemClickListener = onRecyclerItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = mLayoutInflater.inflate(R.layout.recycler_menu_list_item, null);
        itemView.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new ListItemVH(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        if (holder instanceof ListItemVH)
        {
            final MenuItem menuItem = mItemList.get(position);
            final ListItemVH listItemVH = (ListItemVH) holder;
            listItemVH.mTvText.setText(menuItem.text);
            listItemVH.mImageView.setImageResource(menuItem.resIcon);
            listItemVH.mItemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    if (null != mOnRecyclerItemClickListener)
                    {
                        mOnRecyclerItemClickListener.onItemClick(v, menuItem);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount()
    {
        return mItemList.size();
    }

    public static final class ListItemVH extends RecyclerView.ViewHolder
    {
        private View mItemView;
        private ImageView mImageView;
        private TextView mTvText;

        public ListItemVH(View itemView)
        {
            super(itemView);
            mItemView = itemView;
            mImageView = (ImageView) itemView.findViewById(R.id.iv_image);
            mTvText = (TextView) itemView.findViewById(R.id.tv_text);

        }
    }

    public static class MenuItem extends BaseItem
    {
        public int resIcon;
        public String text;

        public MenuItem(int resIcon, String text)
        {
            this.resIcon = resIcon;
            this.text = text;
        }
    }

    public interface OnRecyclerItemClickListener
    {
        public void onItemClick(View view, MenuItem menuItem);
    }
}
