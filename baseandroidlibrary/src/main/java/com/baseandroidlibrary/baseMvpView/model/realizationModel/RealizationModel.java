package com.baseandroidlibrary.baseMvpView.model.realizationModel;

import com.baseandroidlibrary.baseMvpView.baseMvpPresenter.BasePresenter;
import com.baseandroidlibrary.baseMvpView.model.BaseModel;
import com.baseandroidlibrary.netWork.http.HttpServiceHelper.HttpServiceHelper;
import com.baseandroidlibrary.netWork.http.retrofitInit.RetrofitInit;

/**
 * Created by zy on 2018/6/15.
 */

public class RealizationModel<P extends BasePresenter> implements BaseModel{

    private P basePresenterWeakReference;

    /**
     * 设置BasePresenter.
     * @param p
     */
    public void setMyBasePresenter(P p){
        basePresenterWeakReference = p;
    }

    /**
     * 返回一个Http接口操作实例.
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> HttpServiceHelper<T> getHttpInterface(Class<T> clazz){
       return RetrofitInit.getInstance().createService(clazz);
    }

    /**
     * 返回BasePresenter实例.
     * @return
     */
    public P getBasePresenter() {
        return basePresenterWeakReference;
    }

    @Override
    public void destroy() {
        basePresenterWeakReference = null;
    }
}
