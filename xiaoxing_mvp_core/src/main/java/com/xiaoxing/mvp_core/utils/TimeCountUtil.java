package com.xiaoxing.mvp_core.utils;

import android.os.CountDownTimer;
import android.widget.TextView;

/**
 * 描述：时间倒计时(发送验证码)
 * 作者：徐小星 on 2016/9/24 0024 10:31
 * 邮箱：xx@yougudongli.com
 */

public class TimeCountUtil extends CountDownTimer {
    private TextView mBtnCountDown;

    public TimeCountUtil(TextView btnCountDown, long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
        this.mBtnCountDown = btnCountDown;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        mBtnCountDown.setClickable(false);
        mBtnCountDown.setText(millisUntilFinished / 1000 + "秒後重新獲取");
    }

    @Override
    public void onFinish() {
        mBtnCountDown.setText("重新獲取驗證碼");
        mBtnCountDown.setClickable(true);
    }
}
