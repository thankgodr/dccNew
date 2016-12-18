package com.xoxo.dccapp.Coonection;


import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xoxo.dccapp.Adapter.RecyclerAdapter;
import com.xoxo.dccapp.model.Landscape;

import java.util.ArrayList;

/**
 * Created by danieloduonye on 12/18/16.
 */
public class DCCAPI {
    private static DCCAPI ourInstance = new DCCAPI();

    public static DCCAPI getInstance() {
        return ourInstance;
    }

    private DCCAPI() {
    }

    public String url = "http://davidschristiancentre.org/api";


    public void setUpRecyclerView(RecyclerView recyclerView , Context c, ArrayList data) {

        RecyclerAdapter adapter = new RecyclerAdapter(c, Landscape.getData());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(c); // (Context context, int spanCount)
        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLinearLayoutManagerVertical);

        // Even if we dont use it then also our items shows default animation. #Check Docs
    }




}
