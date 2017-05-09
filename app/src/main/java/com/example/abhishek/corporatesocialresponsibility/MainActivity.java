package com.example.abhishek.corporatesocialresponsibility;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.backendless.Backendless;
import com.backendless.exceptions.BackendlessFault;
import com.example.abhishek.corporatesocialresponsibility.LoginSignup.DefaultCallback;
import com.example.abhishek.corporatesocialresponsibility.LoginSignup.LoginActivity;

public class MainActivity extends AppCompatActivity {


    private Button logoutButton;

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

    private void initUI()
    {
        logoutButton = (Button) findViewById( R.id.logoutButton );

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLogoutButtonClicked();
            }
        });
    }

    private void onLogoutButtonClicked()
    {
        Backendless.UserService.logout( new DefaultCallback<Void>( this )
        {
            @Override
            public void handleResponse( Void response )
            {
                super.handleResponse( response );
                startActivity( new Intent( MainActivity.this, LoginActivity.class ) );
                finish();
            }

            @Override
            public void handleFault( BackendlessFault fault )
            {
                if( fault.getCode().equals( "3023" ) ) // Unable to logout: not logged in (session expired, etc.)
                    handleResponse( null );
                else
                    super.handleFault( fault );
            }
        } );

    }
}
