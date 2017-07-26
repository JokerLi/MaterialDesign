package com.joker.li.materialdesign.data.items;

import com.joker.li.materialdesign.data.adapters.MainMenuAdapter;
import com.joker.li.materialdesign.data.adapters.MainMenuViewHolder;

import static com.joker.li.materialdesign.data.adapters.MainMenuAdapter.ITEMTYPE.ITEM_NORMAL;

/**
 * Created by root on 5/17/17.
 */

public abstract class MainMenuItem {
    private int mImageResId;
    private String mImageUrl;
    private String mTitle;
    private String mUrl;
    private MainMenuAdapter.ITEMTYPE mType = ITEM_NORMAL;

    public MainMenuItem(MainMenuAdapter.ITEMTYPE type) {
        mType = type;
    }

    public abstract void bindView(MainMenuViewHolder viewHolder);

    public int getType() {
        return mType.ordinal();
    }
}
