package com.joker.li.materialdesign.data.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.joker.li.materialdesign.R;

/**
 * Created by root on 5/17/17.
 */

public class MainMenuViewHolder extends RecyclerView.ViewHolder {
    public ImageView mImageView;
    public TextView mTextView;

    public MainMenuViewHolder(View itemView) {
        super(itemView);
        mImageView = (ImageView) itemView.findViewById(R.id.image);
        mTextView = (TextView) itemView.findViewById(R.id.text);
    }
}
