package com.xiaoxing.mvp_core.base;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.xiaoxing.mvp_core.RxManager;

/**
 * Created by hpw on 16/10/28.
 */

public abstract class CoreBasePresenter<M, T> {
    public M mModel;
    public T mView;
    public Context mContext;
    public FragmentActivity mActivity;
    public Fragment mFragment;
    public RxManager mRxManager = new RxManager();

    public void attachVM(T v, M m, Context context) {
        this.mView = v;
        this.mModel = m;
        this.mContext = context;
        this.onStart();
    }

    public void attachVM(T v, M m, Context context, FragmentActivity activity) {
        this.mView = v;
        this.mModel = m;
        this.mContext = context;
        this.mActivity = activity;
        this.onStart();
    }

    public void attachVM(T v, M m, Context context, Fragment fragment) {
        this.mView = v;
        this.mModel = m;
        this.mContext = context;
        this.mFragment = fragment;
        this.onStart();
    }

    public void detachVM() {
        mRxManager.clear();
        mView = null;
        mModel = null;
    }

    public abstract void onStart();
}
