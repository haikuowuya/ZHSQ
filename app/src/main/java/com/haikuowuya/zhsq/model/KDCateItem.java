package com.haikuowuya.zhsq.model;

import com.haikuowuya.zhsq.base.BaseItem;

import java.util.List;

/**
 * Created by Steven on 2015/12/28 0028.
 */
public class KDCateItem extends BaseItem
{
    public String ID;
    public String ClassName;
    public String ClassType;
    public String bak1;
    public String bak2;
    public String bak3;

    public static class KDCateItemAPIResult extends APIResult
    {
        public List<KDCateItem> records;
    }
}
