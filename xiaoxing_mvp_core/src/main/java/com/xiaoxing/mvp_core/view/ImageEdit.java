package com.xiaoxing.mvp_core.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.EditText;

import com.xiaoxing.mvp_core.R;


/**
 * Created by ASUS on 2017/12/21.
 */

public class ImageEdit extends EditText {

    private Drawable drawableLeft;
    private int scaleWidth; //dp值
    private int scaleHeight;

    public ImageEdit(Context context) {
        super(context);
    }

    public ImageEdit(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ImageEdit(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ImageTextButton);

        drawableLeft = typedArray.getDrawable(R.styleable.ImageTextButton_leftDrawable);
        scaleWidth = typedArray.getDimensionPixelOffset(R.styleable
                .ImageTextButton_drawableWidth, dip2px(20));
        scaleHeight = typedArray.getDimensionPixelOffset(R.styleable
                .ImageTextButton_drawableHeight, dip2px(20));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (drawableLeft != null) {
            drawableLeft.setBounds(0, 0, dip2px(scaleWidth), dip2px(scaleHeight));
        }
    }

    public int dip2px(int dip) {
        // px/dip = density;
        float density = getResources().getDisplayMetrics().density;
        int px = (int) (dip * density + .5f);
        return px;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.setCompoundDrawables(drawableLeft, null, null, null);
    }

    /**
     * 设置左侧图片并重绘
     *
     * @param drawableLeft
     */
    public void setDrawableLeft(Drawable drawableLeft) {
        this.drawableLeft = drawableLeft;
        invalidate();
    }

    /**
     * 设置左侧图片并重绘
     *
     * @param drawableLeftRes
     */
    public void setDrawableLeft(int drawableLeftRes) {
        this.drawableLeft = getResources().getDrawable(drawableLeftRes);
        invalidate();
    }
}
