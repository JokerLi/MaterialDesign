
package com.joker.li.materialdesign.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.joker.li.materialdesign.R;

public class ResizeRelativeLayout extends RelativeLayout {

    private static final int INDEX_RATIO_X = 0;

    private float mRatioXY;

    private int[] attrs = {
            R.attr.ratioXY
    };

    public ResizeRelativeLayout(Context context, AttributeSet attrsSet, int defStyle) {
        super(context, attrsSet, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrsSet, attrs, defStyle, 0);
        mRatioXY = a.getFloat(INDEX_RATIO_X, -1f);
        a.recycle();
    }

    public ResizeRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ResizeRelativeLayout(Context context) {
        this(context, null);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (mRatioXY < 0) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        if (mRatioXY > 0) {
            int defaultSize = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
            int measuredHeight = (int) (defaultSize * mRatioXY);
            super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(measuredHeight, MeasureSpec.EXACTLY));
        }
    }

}
