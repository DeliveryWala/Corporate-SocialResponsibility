package com.example.abhishek.corporatesocialresponsibility;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends AppCompatActivity {



    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.home_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        String myDataset[]={"Course Curriculum","State Govt Schemes","Project Outcomes","Photo Gallery"};
        int imgDataset[]={R.drawable.coursecurriculum,R.drawable.ssa,R.drawable.projectoutcomes,R.drawable.gallery};
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(MainActivity.this,myDataset,imgDataset);
        mRecyclerView.setAdapter(mAdapter);
    }
}
