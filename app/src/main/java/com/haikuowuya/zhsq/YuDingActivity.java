package com.haikuowuya.zhsq;

import android.content.Intent;

import com.haikuowuya.core.base.BaseHKWYActivity;
import com.haikuowuya.core.base.BaseHKWYFragment;
import com.haikuowuya.zhsq.base.BaseImageTitleActivity;
import com.haikuowuya.zhsq.fragment.YuDingFragment;

/**
 * Created by Steven on 2015/12/28 0028.
 */
public class YuDingActivity extends BaseImageTitleActivity
{
    public  static  void  actionYuDing(BaseHKWYActivity activity )
    {
        Intent intent = new Intent(activity, YuDingActivity.class);
        activity.startActivity(intent);
    }
    public BaseHKWYFragment fragmentAsView()
    {
        return YuDingFragment.newInstance();
    }

}
