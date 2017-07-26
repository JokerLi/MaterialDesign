package com.joker.li.materialdesign.activity.main;

import com.joker.li.materialdesign.data.adapters.MainMenuAdapter;
import com.joker.li.materialdesign.data.adapters.MainMenuViewHolder;
import com.joker.li.materialdesign.data.items.MainMenuItem;

/**
 * Created by root on 5/17/17.
 */

public class MainMenuLineItem extends MainMenuItem {
    public MainMenuLineItem() {
        super(MainMenuAdapter.ITEMTYPE.ITEM_LINE);
    }

    @Override
    public void bindView(MainMenuViewHolder viewHolder) {
        
    }
}
