package com.haikuowuya.zhsq;

/**
 * Created by Steven on 2015/12/28 0028.
 */
public class APIURL
{

    private  static final String  BASE_API_URL="http://www.17gw.top/apio2o";

    public  static  final  String GET_KUAI_DI_CATEGORY_LIST_URL=BASE_API_URL+"/getProClass.ashx";
    private APIURL()
    {
        throw new RuntimeException("APIURL类不可以实例化");
    }
}
