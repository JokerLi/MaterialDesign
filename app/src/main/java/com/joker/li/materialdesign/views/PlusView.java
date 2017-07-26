package com.joker.li.materialdesign.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.joker.li.materialdesign.R;

/**
 * Created by root on 5/17/17.
 */

public class PlusView extends View {
    private static final int COLOR_UP = Color.parseColor("#3F51B5");
    private static final int COLOR_DOWN = Color.parseColor("#2f3c87");

    private static final int RADIUS = 100;
    private int mRadius;
    private int[] attrs = {
            R.attr.radius
    };
    private Paint mPaint = new Paint();

    public PlusView(Context context) {
        super(context);
        init();
    }

    public PlusView(Context context, AttributeSet attrsSet) {
        super(context, attrsSet);
        TypedArray typedArray = context.obtainStyledAttributes(attrsSet, R.styleable.PieView);
        mRadius = typedArray.getDimensionPixelSize(R.styleable.PieView_radius, RADIUS);
        typedArray.recycle();
        init();
    }

    public PlusView(Context context, AttributeSet attrsSet, int defStyle) {
        super(context, attrsSet, defStyle);
        init();
    }

    private void init() {
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(COLOR_UP);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initCanvas(canvas);

        int small = 10;

        Path src = new Path();
        RectF oval = new RectF(-mRadius, -small, mRadius, small);
        src.addRoundRect(oval, 20, 20, Path.Direction.CW);
        canvas.drawPath(src, mPaint);

        RectF ovalv = new RectF(-small, -mRadius, small, mRadius);
        src.addRoundRect(ovalv, 20, 20, Path.Direction.CW);
        canvas.drawPath(src, mPaint);
    }

    private void initCanvas(Canvas canvas) {
        canvas.translate(getWidth() / 2, getHeight() / 2);
        canvas.scale(1, -1);
    }
}
