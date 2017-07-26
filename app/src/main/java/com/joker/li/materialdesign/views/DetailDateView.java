package com.joker.li.materialdesign.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.joker.li.materialdesign.R;

/**
 * Created by root on 5/18/17.
 */

public class DetailDateView extends FrameLayout implements ITwoSide {
    private TextView mTextViewLeft;
    private TextView mTextViewRight;
    private String mText;

    public DetailDateView(Context context) {
        super(context);
        init();
    }

    public DetailDateView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DetailDateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        View view = LayoutInflater.from(getContext()).inflate(R.layout.detail_date, null);
        view.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        mTextViewLeft = (TextView) view.findViewById(R.id.detail_title_left);
        mTextViewRight = (TextView) view.findViewById(R.id.detail_title_right);
        addView(view);
    }

    public void setText(String text) {
        mText = text;
    }

    @Override
    public void setLocation(int location) {
        if (location == LOCATION_LEFT) {
            mTextViewLeft.setText(mText);
            mTextViewLeft.setVisibility(VISIBLE);
            mTextViewRight.setVisibility(GONE);
        } else {
            mTextViewRight.setText(mText);
            mTextViewLeft.setVisibility(GONE);
            mTextViewRight.setVisibility(VISIBLE);
        }
    }

}
