package com.joker.li.materialdesign.activity.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.joker.li.materialdesign.R;
import com.joker.li.materialdesign.data.adapters.MainMenuAdapter;
import com.joker.li.materialdesign.data.items.MainMenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mMenu = (RecyclerView) findViewById(R.id.main_menu);
        mMenu.setHasFixedSize(true);
        mMenu.setLayoutManager(new LinearLayoutManager(this));
        MainMenuAdapter mAdapter = new MainMenuAdapter(getItems());
        mMenu.setAdapter(mAdapter);
        mMenu.setItemAnimator(new DefaultItemAnimator());
    }

    public List<MainMenuItem> getItems() {
        List<MainMenuItem> list = new ArrayList<MainMenuItem>();
        list.add(new MainMenuHeadItem());
        list.add(new MainMenuNormalItem());
        list.add(new MainMenuNormalItem());
        list.add(new MainMenuNormalItem());
        list.add(new MainMenuNormalItem());
        list.add(new MainMenuNormalItem());
        list.add(new MainMenuLineItem());
        return list;
    }
}
