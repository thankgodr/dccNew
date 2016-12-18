package com.xoxo.dccapp.views;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xoxo.dccapp.Coonection.CallBackFunction;
import com.xoxo.dccapp.Coonection.DCCAPI;
import com.xoxo.dccapp.Coonection.JsonTask;
import com.xoxo.dccapp.MainActivity;
import com.xoxo.dccapp.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * A simple {@link Fragment} subclass.
 */
public class Articles extends Fragment {


    DCCAPI dccapi = DCCAPI.getInstance();
    ArrayList arrayList ;
    RecyclerView recyclerView;
    public Articles() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_articles, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        dccapi.setUpRecyclerView(recyclerView,getContext(),arrayList);
        new JsonTask(new CallBackFunction() {
            @Override
            public void success(InputStream stream) {
                Log.i("burn", "It worked");
                BufferedReader bR = new BufferedReader(  new InputStreamReader(stream));
                String line = "";

                StringBuilder responseStrBuilder = new StringBuilder();
                try {
                    while((line =  bR.readLine()) != null){

                        responseStrBuilder.append(line);
                        stream.close();
                      JSONObject result = new JSONObject(responseStrBuilder.toString());
                        Log.i("burn2", String.valueOf(result));
                        Iterator<?> keys = result.keys(); // get the keys of the jsonObject
                        while( keys.hasNext() ) {//iterrate over them
                            String key = (String) keys.next();
                          //  arrayList.add(result.optString(key));
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void error() {

            }
        }).execute(dccapi.url + "/get_recent_posts/");
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
