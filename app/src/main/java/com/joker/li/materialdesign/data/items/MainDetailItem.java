package com.joker.li.materialdesign.data.items;

import com.joker.li.materialdesign.data.adapters.MainDetailViewHolder;
import com.joker.li.materialdesign.data.adapters.MainDetailsAdapter;

import static com.joker.li.materialdesign.data.adapters.MainDetailsAdapter.ITEMTYPE.ITEM;


/**
 * Created by root on 5/17/17.
 */

public abstract class MainDetailItem {
    private int mImageResId;
    private String mImageUrl;
    private String mTitle;
    private String mUrl;
    private MainDetailsAdapter.ITEMTYPE mType = ITEM;

    public MainDetailItem(MainDetailsAdapter.ITEMTYPE type) {
        mType = type;
    }

    public abstract void bindView(MainDetailViewHolder viewHolder);

    public int getType() {
        return mType.ordinal();
    }
}
