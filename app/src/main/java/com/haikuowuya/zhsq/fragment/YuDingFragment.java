package com.haikuowuya.zhsq.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.haikuowuya.core.mvp.view.DataView;
import com.haikuowuya.core.util.GsonUtils;
import com.haikuowuya.zhsq.APIURL;
import com.haikuowuya.zhsq.R;
import com.haikuowuya.zhsq.adapter.kuaidi.KDCateGridAdapter;
import com.haikuowuya.zhsq.base.BaseFragment;
import com.haikuowuya.zhsq.http.RequestUtils;
import com.haikuowuya.zhsq.model.APIResult;
import com.haikuowuya.zhsq.model.KDCateItem;

import java.util.List;

import butterknife.Bind;

/**
 * Created by Steven on 2015/12/28 0028.
 */
public class YuDingFragment extends BaseFragment implements DataView
{
    public static YuDingFragment newInstance()
    {
        YuDingFragment fragment = new YuDingFragment();
        return fragment;
    }

    @Bind(R.id.gv_gridview)
    GridView mGridView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_yuding, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        RequestUtils.getDataFromUrl(mActivity, APIURL.GET_KUAI_DI_CATEGORY_LIST_URL, this, null, true);
    }

    @Override
    public String getFragmentTitle()
    {
        return null;
    }

    @Override
    public void onGetDataFailured(String msg, String requestTag)
    {

    }

    @Override
    public void onGetDataSuccess(String result, String requestTag)
    {
        APIResult apiResult = GsonUtils.jsonToClass(result, APIResult.class);
        if (null != apiResult && apiResult.success())
        {
            KDCateItem.KDCateItemAPIResult kdCateItemAPIResult = GsonUtils.jsonToClass(result, KDCateItem.KDCateItemAPIResult.class);
            if (kdCateItemAPIResult != null && kdCateItemAPIResult.success() && null != kdCateItemAPIResult.records)
            {
                showGridContent(kdCateItemAPIResult.records);
            }
        }
    }

    private void showGridContent(List<KDCateItem> records)
    {
        if (null != records && !records.isEmpty())
        {
            mGridView.setNumColumns(2);
            mGridView.setAdapter(new KDCateGridAdapter(mActivity, records));
        }
    }
}
