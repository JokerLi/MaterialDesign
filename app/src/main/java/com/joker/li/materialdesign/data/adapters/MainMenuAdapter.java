package com.joker.li.materialdesign.data.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joker.li.materialdesign.R;
import com.joker.li.materialdesign.data.items.MainMenuItem;

import java.util.ArrayList;
import java.util.List;

import static com.joker.li.materialdesign.data.adapters.MainMenuAdapter.ITEMTYPE.HEAD;
import static com.joker.li.materialdesign.data.adapters.MainMenuAdapter.ITEMTYPE.ITEM_LINE;
import static com.joker.li.materialdesign.data.adapters.MainMenuAdapter.ITEMTYPE.ITEM_NORMAL;

/**
 * Created by root on 5/16/17.
 */

public class MainMenuAdapter extends RecyclerView.Adapter<MainMenuViewHolder> {
    public enum ITEMTYPE {
        HEAD, ITEM_NORMAL, ITEM_LINE;
    }

    /******************************************************************************/
    private List<MainMenuItem> mMainMenuItems;

    public MainMenuAdapter(List<MainMenuItem> input) {
        mMainMenuItems = new ArrayList<MainMenuItem>();
        mMainMenuItems.addAll(input);
    }

    @Override
    public MainMenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutId = getLayoutId(viewType);

        View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        MainMenuViewHolder vh = new MainMenuViewHolder(view);
        return vh;
    }

    private int getLayoutId(int viewType) {
        int layout = R.layout.menu_normal;

        if (viewType == HEAD.ordinal()) {
            layout = R.layout.menu_head;
        } else if (viewType == ITEM_NORMAL.ordinal()) {
            layout = R.layout.menu_normal;
        } else if (viewType == ITEM_LINE.ordinal()) {
            layout = R.layout.menu_line;
        }
        return layout;
    }

    @Override
    public int getItemViewType(int position) {
        return mMainMenuItems.get(position).getType();
    }

    @Override
    public void onBindViewHolder(MainMenuViewHolder holder, int position) {
        mMainMenuItems.get(position).bindView(holder);
    }

    @Override
    public int getItemCount() {
        return mMainMenuItems.size();
    }
}
