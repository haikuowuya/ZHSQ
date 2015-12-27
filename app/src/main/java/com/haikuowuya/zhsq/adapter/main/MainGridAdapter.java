package com.haikuowuya.zhsq.adapter.main ;

import android.app.Activity;
import android.view.View;

import com.haikuowuya.core.base.BaseHKWYAdapter;
import com.haikuowuya.zhsq.R;
import com.haikuowuya.zhsq.base.BaseItem;

import java.util.List;

/**
 * Created by Administrator on 2015/12/27 0027.
 */
public class MainGridAdapter extends BaseHKWYAdapter<MainGridAdapter.TextIconItem>
{
    public MainGridAdapter(Activity activity, List<TextIconItem> data)
    {
        super(activity, data);
    }

    @Override
    public void bindDataToView(View convertView, TextIconItem textIconItem)
    {
           setImageViewResId(convertView, R.id.iv_image, textIconItem.icon);
            setTextViewText(convertView, R.id.tv_text, textIconItem.text);
    }

    @Override
    public int layoutResId()
    {
        return R.layout.grid_main_item;
    }

    public  static  class  TextIconItem extends BaseItem
    {
        public  int icon;
        public  String text;

        public TextIconItem(int icon, String text)
        {
            this.icon = icon;
            this.text = text;
        }
    }
}
