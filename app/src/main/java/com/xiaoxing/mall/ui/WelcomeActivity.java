package com.xiaoxing.mall.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.widget.ImageView;

import com.xiaoxing.mall.MainActivity;
import com.xiaoxing.mall.MallConstants;
import com.xiaoxing.mall.R;
import com.xiaoxing.mvp_core.base.CoreBaseActivity;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * 欢迎页面，启动页
 */
public class WelcomeActivity extends CoreBaseActivity {

    private static final int ANIM_TIME = 2000;
    private static final float SCALE_END = 1.15F;
    private static final int[] Imgs = {
            R.mipmap.welcomimg1, R.mipmap.welcomimg2,
            R.mipmap.welcomimg3, R.mipmap.welcomimg4,
            R.mipmap.welcomimg5, R.mipmap.welcomimg6,
            R.mipmap.welcomimg7, R.mipmap.welcomimg8,
            R.mipmap.welcomimg9, R.mipmap.welcomimg10,
            R.mipmap.welcomimg11, R.mipmap.welcomimg12};
    @BindView(R.id.iv_entry)
    ImageView mIVEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        // 判断是否是第一次开启应用
        boolean isFirstOpen = sHelper.getBoolean(MallConstants.FIRST_OPEN, true);
        // 如果是第一次启动，则先进入功能引导页
        if (isFirstOpen) {
            Intent intent = new Intent(this, WelcomeGuideActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        startMainActivity();
    }

    private void startMainActivity() {
        Random random = new Random(SystemClock.elapsedRealtime());//SystemClock.elapsedRealtime() 从开机到现在的毫秒数（手机睡眠(sleep)的时间也包括在内）
        mIVEntry.setImageResource(Imgs[random.nextInt(Imgs.length)]);

        Observable.timer(1000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>() {

                    @Override
                    public void call(Long aLong) {
                        startAnim();
                    }
                });
    }

    private void startAnim() {

        ObjectAnimator animatorX = ObjectAnimator.ofFloat(mIVEntry, "scaleX", 1f, SCALE_END);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(mIVEntry, "scaleY", 1f, SCALE_END);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(ANIM_TIME).play(animatorX).with(animatorY);
        set.start();

        set.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animation) {

                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                WelcomeActivity.this.finish();
            }
        });
    }

    /**
     * 屏蔽物理返回按钮
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
