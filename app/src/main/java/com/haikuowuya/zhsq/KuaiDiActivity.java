package com.haikuowuya.zhsq;

import android.content.Intent;

import com.haikuowuya.core.base.BaseHKWYActivity;
import com.haikuowuya.core.base.BaseHKWYFragment;
import com.haikuowuya.zhsq.base.BaseImageTitleActivity;
import com.haikuowuya.zhsq.fragment.KuaiDiFragment;

/**
 * Created by Steven on 2015/12/28 0028.
 */
public class KuaiDiActivity extends BaseImageTitleActivity
{
    public  static  void  actionKuaiDi(BaseHKWYActivity activity )
    {
        Intent intent = new Intent(activity, KuaiDiActivity.class);
        activity.startActivity(intent);
    }
    public BaseHKWYFragment fragmentAsView()
    {
        return KuaiDiFragment.newInstance();
    }

}
