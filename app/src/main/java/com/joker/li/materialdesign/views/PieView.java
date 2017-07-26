package com.joker.li.materialdesign.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.joker.li.materialdesign.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 5/17/17.
 */

public class PieView extends View {
    private int mRadius;
    private int mBgRadius;

    public static class PieViewData {
        public int mColor;
        public float mAmount;
        private int mAngle;
        private int mNowAngle;
    }

    private static final int RADIUS = 230;

    private static final int DURATION = 700;

    private List<PieViewData> mDataList = new ArrayList<PieViewData>();
    private Paint mPaint = new Paint();

    public PieView(Context context) {
        super(context);
        init();
    }

    public PieView(Context context, AttributeSet attrsSet) {
        super(context, attrsSet);
        TypedArray typedArray = context.obtainStyledAttributes(attrsSet, R.styleable.PieView);
        mRadius = typedArray.getDimensionPixelSize(R.styleable.PieView_radius, RADIUS);
        mBgRadius = typedArray.getDimensionPixelSize(R.styleable.PieView_bgradius, RADIUS + 15);
        typedArray.recycle();
        init();
    }

    public PieView(Context context, AttributeSet attrsSet, int defStyle) {
        super(context, attrsSet, defStyle);
        init();
    }

    private void init() {
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(20);
        mPaint.setAntiAlias(true);
//        startAnimation();
    }

    public void setData(List<PieViewData> dataList) {
        if (dataList == null || dataList.isEmpty()) {
            return;
        }
        mDataList.addAll(dataList);
        parseData();
        invalidate();
        startAnimation();
    }

    private void parseData() {
        float totalAmount = 0;
        for (PieViewData data : mDataList) {
            totalAmount += data.mAmount;
        }
        for (PieViewData data : mDataList) {
            data.mAngle = (int) (360 * (data.mAmount / totalAmount));
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initCanvas(canvas);

        drawBackground(canvas);
        drawDataList(canvas);
    }

    private void drawDataList(Canvas canvas) {
        if (mDataList.isEmpty()) {
            return;
        }

        int startAngle = 0;
        for (PieViewData data : mDataList) {
            drawArc(canvas, startAngle, data.mNowAngle, data.mColor);
            startAngle = startAngle + data.mAngle;
        }
    }

    private void drawArc(Canvas canvas, int startAngle, int sweepAngle, int color) {
        Path src = new Path();
        RectF oval = new RectF(-mRadius, -mRadius, mRadius, mRadius);
        src.addArc(oval, startAngle, sweepAngle);
        changePaint(Paint.Style.STROKE, color);
        canvas.drawPath(src, mPaint);
    }

    private void drawBackground(Canvas canvas) {
        Path path = new Path();
        path.addCircle(0, 0, mBgRadius, Path.Direction.CW);
        changePaint(Paint.Style.FILL, Color.WHITE);
        canvas.drawPath(path, mPaint);
    }

    private void changePaint(Paint.Style style, int color) {
        mPaint.setStyle(style);
        mPaint.setColor(color);
    }

    private void initCanvas(Canvas canvas) {
        canvas.translate(getWidth() / 2, getHeight() / 2);
        canvas.scale(1, -1);
    }

    void startAnimation() {
        for (final PieViewData data : mDataList) {
            ValueAnimator valueAnimator = ValueAnimator.ofInt(0, data.mAngle);
            valueAnimator.setInterpolator(new LinearInterpolator());
            valueAnimator.setDuration(DURATION);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    data.mNowAngle = (int) animation.getAnimatedValue();
                    invalidate();
                }
            });
            valueAnimator.start();
        }
    }

}
