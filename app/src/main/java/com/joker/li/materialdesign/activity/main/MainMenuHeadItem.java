package com.joker.li.materialdesign.activity.main;

import com.joker.li.materialdesign.R;
import com.joker.li.materialdesign.data.adapters.MainMenuAdapter;
import com.joker.li.materialdesign.data.adapters.MainMenuViewHolder;
import com.joker.li.materialdesign.data.items.MainMenuItem;

/**
 * Created by root on 5/17/17.
 */

public class MainMenuHeadItem extends MainMenuItem {
    public MainMenuHeadItem() {
        super(MainMenuAdapter.ITEMTYPE.HEAD);
    }

    @Override
    public void bindView(MainMenuViewHolder viewHolder) {
        viewHolder.mImageView.setImageResource(R.mipmap.menu_top);
    }
}
