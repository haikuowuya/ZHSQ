package com.haikuowuya.zhsq.model;

import com.haikuowuya.zhsq.base.BaseItem;

/**
 * Created by Steven on 2015/12/28 0028.
 */
public class APIResult extends BaseItem
{
    public String success;
    public String totalCount;

    public boolean success()
    {
        return Boolean.parseBoolean(success);
    }
}
