package com.haikuowuya.zhsq.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haikuowuya.core.mvp.view.DataView;
import com.haikuowuya.core.util.GsonUtils;
import com.haikuowuya.zhsq.APIURL;
import com.haikuowuya.zhsq.R;
import com.haikuowuya.zhsq.base.BaseFragment;
import com.haikuowuya.zhsq.http.RequestUtils;
import com.haikuowuya.zhsq.model.APIResult;

/**
 * Created by Steven on 2015/12/28 0028.
 */
public class KuaiDiFragment extends BaseFragment implements DataView
{
    public static KuaiDiFragment newInstance()
    {
        KuaiDiFragment fragment = new KuaiDiFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_kuaidi, null);
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
        System.out.println("result = " + result);
        mActivity.showToast(result);
        APIResult apiResult = GsonUtils.jsonToClass(result, APIResult.class);
        if (null != apiResult && apiResult.success())
        {
        }
    }
}
