package com.xiaoxing.mvp_core.base;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.v4.app.FragmentManager;

import com.xiaoxing.gifloadingview.LoadingDialogUtil;
import com.xiaoxing.mvp_core.R;

/**
 * @name Xiaoxing_Mvp
 * @class name：com.xiaoxing.mvp_core.base
 * @class describe
 * @anthor xiaoxing QQ:2235445233
 * @time 2017/9/22 21:06
 * @change
 * @chang time
 * @class describe
 */
public abstract class CoreLoadingSubscriber<T> extends CoreNetCheckerSubscriber<T> {


    public CoreLoadingSubscriber(Context context, FragmentManager fragmentManager, int resLoading) {
        super(context, fragmentManager, resLoading);
    }

    @Override
    public void onCompleted() {
        /** 完成，
         *  hide Loading
         * */
        LoadingDialogUtil.dismissDialog();
        super.onCompleted();
    }

    @CallSuper
    @Override
    public void onError(Throwable e) {
        /** 出错，
         *  hide Loading
         * */
        LoadingDialogUtil.dismissDialog();
        super.onError(e);
    }

    @Override
    public void onStart() {
        super.onStart();
        /** 在这显示loading */
//        LoadingDialogUtil.showGifdialog2(getFragmentManager(), getResLoading());
        LoadingDialogUtil.showGifdialog1(getFragmentManager(), R.drawable.loading);
    }

    @Override
    public void onNext(T t) {
        super.onNext(t);
    }


}
