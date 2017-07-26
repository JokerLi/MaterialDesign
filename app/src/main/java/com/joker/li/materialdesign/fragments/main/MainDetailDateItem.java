package com.joker.li.materialdesign.fragments.main;

import com.joker.li.materialdesign.data.adapters.MainDetailViewHolder;
import com.joker.li.materialdesign.data.adapters.MainDetailsAdapter;
import com.joker.li.materialdesign.data.items.MainDetailItem;
import com.joker.li.materialdesign.views.DetailDateView;
import com.joker.li.materialdesign.views.DetailSourceView;
import com.joker.li.materialdesign.views.ITwoSide;

/**
 * Created by root on 5/17/17.
 */

public class MainDetailDateItem extends MainDetailItem {
    static int a = 0;

    public MainDetailDateItem() {
        super(MainDetailsAdapter.ITEMTYPE.DATE);
    }

    @Override
    public void bindView(MainDetailViewHolder viewHolder) {
        DetailDateView view = (DetailDateView) viewHolder.itemView;
        view.setText("test date");
        if (a % 2 == 0) {
            view.setLocation(ITwoSide.LOCATION_RIGHT);
        } else {
            view.setLocation(ITwoSide.LOCATION_LEFT);
        }
        a++;
    }
}
