package com.joker.li.materialdesign.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.joker.li.materialdesign.R;

/**
 * Created by root on 5/18/17.
 */

public class DetailSourceView extends FrameLayout implements ITwoSide {
    private TextView mTitleLeft;
    private TextView mTitleRight;
    private TextView mDesLeft;
    private TextView mDesRight;

    private ImageView mImageView;

    private String mTitle;
    private String mDes;

    public DetailSourceView(Context context) {
        super(context);
        init();
    }

    public DetailSourceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DetailSourceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        View view = LayoutInflater.from(getContext()).inflate(R.layout.detail_item, null);
        view.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        mTitleLeft = (TextView) view.findViewById(R.id.detail_title_left);
        mTitleRight = (TextView) view.findViewById(R.id.detail_title_right);
        mDesLeft = (TextView) view.findViewById(R.id.detail_description_left);
        mDesRight = (TextView) view.findViewById(R.id.detail_description_right);
        mImageView = (ImageView) view.findViewById(R.id.detail_image);
        addView(view);
    }

    public void setText(String title, String desc) {
        mTitle = title;
        mDes = desc;
    }

    public void setImageResourceId(int resId) {
        mImageView.setImageResource(resId);
    }

    public void setImageBitmap(Bitmap bitmap) {
        mImageView.setImageBitmap(bitmap);
    }

    @Override
    public void setLocation(int location) {
        if (location == LOCATION_LEFT) {
            mTitleLeft.setText(mTitle);
            mDesLeft.setText(mDes);
            mTitleLeft.setVisibility(VISIBLE);
            mDesLeft.setVisibility(VISIBLE);
            mTitleRight.setVisibility(GONE);
            mDesRight.setVisibility(GONE);
        } else {
            mTitleRight.setText(mTitle);
            mDesRight.setText(mDes);
            mTitleLeft.setVisibility(GONE);
            mDesLeft.setVisibility(GONE);
            mTitleRight.setVisibility(VISIBLE);
            mDesRight.setVisibility(VISIBLE);
        }
    }

}
