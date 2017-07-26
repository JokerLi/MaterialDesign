package com.joker.li.materialdesign.activity.main;

import com.joker.li.materialdesign.R;
import com.joker.li.materialdesign.data.adapters.MainMenuAdapter;
import com.joker.li.materialdesign.data.adapters.MainMenuViewHolder;
import com.joker.li.materialdesign.data.items.MainMenuItem;

/**
 * Created by root on 5/17/17.
 */

public class MainMenuNormalItem extends MainMenuItem {
    public MainMenuNormalItem() {
        super(MainMenuAdapter.ITEMTYPE.ITEM_NORMAL);
    }

    @Override
    public void bindView(MainMenuViewHolder viewHolder) {
        viewHolder.mImageView.setImageResource(R.mipmap.ic_launcher);
        viewHolder.mTextView.setText("MainMenuNormalItem");
    }
}
