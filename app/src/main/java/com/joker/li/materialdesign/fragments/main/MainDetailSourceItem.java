package com.joker.li.materialdesign.fragments.main;

import com.joker.li.materialdesign.R;
import com.joker.li.materialdesign.data.adapters.MainDetailViewHolder;
import com.joker.li.materialdesign.data.adapters.MainDetailsAdapter;
import com.joker.li.materialdesign.data.items.MainDetailItem;
import com.joker.li.materialdesign.views.DetailSourceView;
import com.joker.li.materialdesign.views.ITwoSide;

/**
 * Created by root on 5/17/17.
 */

public class MainDetailSourceItem extends MainDetailItem {
    static int a = 0;

    public MainDetailSourceItem() {
        super(MainDetailsAdapter.ITEMTYPE.ITEM);
    }

    @Override
    public void bindView(MainDetailViewHolder viewHolder) {
        DetailSourceView view = (DetailSourceView) viewHolder.itemView;
        view.setText("test Title", "test Desc");
        if (a % 2 == 0) {
            view.setLocation(ITwoSide.LOCATION_RIGHT);
            view.setImageResourceId(R.mipmap.food);
        } else {
            view.setLocation(ITwoSide.LOCATION_LEFT);
            view.setImageResourceId(R.mipmap.shopping);
        }
        a++;
    }
}
