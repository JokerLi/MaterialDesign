package com.joker.li.materialdesign.fragments.main;

import com.joker.li.materialdesign.data.adapters.MainDetailViewHolder;
import com.joker.li.materialdesign.data.adapters.MainDetailsAdapter;
import com.joker.li.materialdesign.data.items.MainDetailItem;

/**
 * Created by root on 5/17/17.
 */

public class MainDetailHeadItem extends MainDetailItem {
    public MainDetailHeadItem() {
        super(MainDetailsAdapter.ITEMTYPE.HEAD);
    }

    @Override
    public void bindView(MainDetailViewHolder viewHolder) {
        //do nothing
    }
}
