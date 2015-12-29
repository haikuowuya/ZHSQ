package com.haikuowuya.zhsq.adapter.kuaidi;

import android.app.Activity;
import android.view.View;

import com.haikuowuya.core.base.BaseHKWYAdapter;
import com.haikuowuya.zhsq.R;
import com.haikuowuya.zhsq.model.KDCateItem;

import java.util.List;

/**
 * Created by Steven on 2015/12/29 0029.
 */
public class KDCateGridAdapter extends BaseHKWYAdapter<KDCateItem>
{
    public KDCateGridAdapter(Activity activity, List<KDCateItem> data)
    {
        super(activity, data);
    }

    @Override
    public void bindDataToView(View convertView, KDCateItem kdCateItem)
    {
        setTextViewText(convertView, R.id.tv_text, kdCateItem.ClassName);
        setViewBackgroundColor(convertView, R.id.linear_kd_cate_item_container, COLORS[getPosition() % mData.size()]);
    }

    @Override
    public int layoutResId()
    {
        return R.layout.grid_kd_cate_item;
    }

    public static final int[] COLORS = {0xFFE77E23, 0xFFE84C3D, 0xFF1BBC9B,  0xFFF1C40F, 0xFF9B58B5, 0xFF3598DB};
}
