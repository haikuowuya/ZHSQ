package com.haikuowuya.zhsq;

import android.content.Intent;

import com.haikuowuya.core.base.BaseHKWYActivity;
import com.haikuowuya.core.base.BaseHKWYFragment;
import com.haikuowuya.zhsq.base.BaseImageTitleActivity;
import com.haikuowuya.zhsq.fragment.GameFragment;

/**
 * Created by Steven on 2015/12/28 0028.
 */
public class GameActivity extends BaseImageTitleActivity
{
    public  static  void  actionGame(BaseHKWYActivity activity )
    {
        Intent intent = new Intent(activity, GameActivity.class);
        activity.startActivity(intent);
    }
    public BaseHKWYFragment fragmentAsView()
    {
        return GameFragment.newInstance();
    }

}
