package com.xiaoxing.mvp_core.base;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.v4.app.FragmentManager;

import rx.Subscriber;

/**
 * @name Xiaoxing_Mvp
 * @class name：com.xiaoxing.mvp_core.base
 * @class describe
 * @anthor xiaoxing QQ:2235445233
 * @time 2017/9/22 21:03
 * @change
 * @chang time
 * @class describe
 */
public abstract class CoreBaseSubscriber<T> extends Subscriber<T> {
    private Context mContext;
    private FragmentManager mFragmentManager;
    private int mResLoading;

    public CoreBaseSubscriber() {

    }

    public CoreBaseSubscriber(Context context) {
        mContext = context;
    }

    public CoreBaseSubscriber(Context context, FragmentManager fragmentManager) {
        mContext = context;
        mFragmentManager = fragmentManager;
    }

    public CoreBaseSubscriber(Context context, FragmentManager fragmentManager, int resLoading) {
        mContext = context;
        mFragmentManager = fragmentManager;
        mResLoading = resLoading;
    }

    public Context getContext() {
        return mContext;
    }

    public FragmentManager getFragmentManager() {
        return mFragmentManager;
    }
    public int getResLoading() {
        return mResLoading;
    }

    @Override
    public void onCompleted() {

    }

    @CallSuper
    @Override
    public void onError(Throwable e) {
        /** 根据异常处理错误信息 */
    }

    @Override
    public void onNext(T t) {
        _onNext(t);
    }

    public abstract void _onNext(T entity);
}
