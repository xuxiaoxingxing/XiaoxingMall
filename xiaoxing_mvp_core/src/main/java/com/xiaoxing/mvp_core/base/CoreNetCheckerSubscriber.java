package com.xiaoxing.mvp_core.base;

import android.content.Context;
import android.support.v4.app.FragmentManager;

import com.xiaoxing.mvp_core.utils.NetUtils;
import com.xiaoxing.mvp_core.utils.ToastUtils;

/**
 * @name Xiaoxing_Mvp
 * @class name：com.xiaoxing.mvp_core.base
 * @class describe
 * @anthor xiaoxing QQ:2235445233
 * @time 2017/9/23 12:17
 * @change
 * @chang time
 * @class describe
 */
public abstract class CoreNetCheckerSubscriber<T> extends CoreBaseSubscriber<T> {

    public CoreNetCheckerSubscriber(Context context) {
        super(context);
    }

    public CoreNetCheckerSubscriber(Context context, FragmentManager fragmentManager) {
        super(context, fragmentManager);
    }

    public CoreNetCheckerSubscriber(Context context, FragmentManager fragmentManager, int resLoading) {
        super(context, fragmentManager, resLoading);
    }


    @Override
    public void onStart() {
        super.onStart();
        if (!NetUtils.isConnected(getContext())) {
            if (isUnsubscribed()) {
                unsubscribe();
            }
            ToastUtils.showToast(getContext(), "请检查网络连接后重试!");

        }
    }

}