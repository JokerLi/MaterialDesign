package com.joker.li.materialdesign.fragments.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joker.li.materialdesign.R;
import com.joker.li.materialdesign.activity.main.MainMenuHeadItem;
import com.joker.li.materialdesign.activity.main.MainMenuLineItem;
import com.joker.li.materialdesign.activity.main.MainMenuNormalItem;
import com.joker.li.materialdesign.data.adapters.MainDetailsAdapter;
import com.joker.li.materialdesign.data.items.MainDetailItem;
import com.joker.li.materialdesign.views.PieView;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        PieView pieView = (PieView) view.findViewById(R.id.main_pieView);
        /*List<PieView.PieViewData> datas = new ArrayList<PieView.PieViewData>();

        PieView.PieViewData data = new PieView.PieViewData();
        data.mAmount = 100;
        data.mColor = Color.parseColor("#FF6666");
        datas.add(data);

        PieView.PieViewData data1 = new PieView.PieViewData();
        data1.mAmount = 40;
        data1.mColor = Color.parseColor("#ffff00");
        datas.add(data1);

        PieView.PieViewData data2 = new PieView.PieViewData();
        data2.mAmount = 80;
        data2.mColor = Color.parseColor("#006699");
        datas.add(data2);
        pieView.setData(datas);*/
        /*RecyclerView mMenu = (RecyclerView) view.findViewById(R.id.main_details);
        mMenu.setHasFixedSize(true);
        mMenu.setLayoutManager(new LinearLayoutManager(getContext()));
        MainMenuAdapter mAdapter = new MainMenuAdapter(getItems());
        mMenu.setAdapter(mAdapter);*/


        RecyclerView mMenu = (RecyclerView) view.findViewById(R.id.main_details);
        mMenu.setHasFixedSize(true);
        mMenu.setLayoutManager(new LinearLayoutManager(getContext()));
        MainDetailsAdapter mAdapter = new MainDetailsAdapter(getItems());
        mMenu.setAdapter(mAdapter);
        return view;
    }

    public List<MainDetailItem> getItems() {
        List<MainDetailItem> list = new ArrayList<MainDetailItem>();
        list.add(new MainDetailHeadItem());
        list.add(new MainDetailSourceItem());
        list.add(new MainDetailDateItem());
        list.add(new MainDetailSourceItem());
        list.add(new MainDetailDateItem());
        list.add(new MainDetailSourceItem());
        list.add(new MainDetailSourceItem());
        return list;
    }
}
