package com.joker.li.materialdesign.data.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joker.li.materialdesign.R;
import com.joker.li.materialdesign.data.items.MainDetailItem;
import com.joker.li.materialdesign.views.DetailDateView;
import com.joker.li.materialdesign.views.DetailSourceView;

import java.util.ArrayList;
import java.util.List;

import static com.joker.li.materialdesign.data.adapters.MainDetailsAdapter.ITEMTYPE.DATE;
import static com.joker.li.materialdesign.data.adapters.MainDetailsAdapter.ITEMTYPE.HEAD;
import static com.joker.li.materialdesign.data.adapters.MainDetailsAdapter.ITEMTYPE.ITEM;
import static com.joker.li.materialdesign.views.ITwoSide.LOCATION_RIGHT;


/**
 * Created by root on 5/16/17.
 */

public class MainDetailsAdapter extends RecyclerView.Adapter<MainDetailViewHolder> {
    public enum ITEMTYPE {
        HEAD, ITEM, DATE;
    }

    /******************************************************************************/
    private List<MainDetailItem> mMainMenuItems;

    public MainDetailsAdapter(List<MainDetailItem> input) {
        mMainMenuItems = new ArrayList<MainDetailItem>();
        mMainMenuItems.addAll(input);
    }

    @Override
    public MainDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == HEAD.ordinal()) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_head, parent, false);
        } else if (viewType == ITEM.ordinal()) {
            view = new DetailSourceView(parent.getContext());
        } else if (viewType == DATE.ordinal()) {
            view = new DetailDateView(parent.getContext());
        }
        MainDetailViewHolder vh = new MainDetailViewHolder(view);
        return vh;
    }

    @Override
    public int getItemViewType(int position) {
        return mMainMenuItems.get(position).getType();
    }

    @Override
    public void onBindViewHolder(MainDetailViewHolder holder, int position) {
        mMainMenuItems.get(position).bindView(holder);
    }

    @Override
    public int getItemCount() {
        return mMainMenuItems.size();
    }
}
