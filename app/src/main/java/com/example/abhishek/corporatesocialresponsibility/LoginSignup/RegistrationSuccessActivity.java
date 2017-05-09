package com.example.abhishek.corporatesocialresponsibility.LoginSignup;

/**
 * Created by Abhishek on 04-03-2017.
 */import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.abhishek.corporatesocialresponsibility.R;

public class RegistrationSuccessActivity extends AppCompatActivity
{
    private TextView messageView;
    private Button loginButton;

    @Override
    public void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.registration_success );

        initUI();
    }

    private void initUI()
    {
        messageView = (TextView) findViewById( R.id.messageView );
        loginButton = (Button) findViewById( R.id.loginButton );


        Resources resources = getResources();
        String message = String.format( resources.getString( R.string.registration_success_message ), resources.getString( R.string.app_name ) );
        messageView.setText( message );

        loginButton.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View view )
            {
                onLoginButtonClicked();
            }
        } );
    }

    public void onLoginButtonClicked()
    {
        startActivity( new Intent( this, LoginActivity.class ) );
        finish();
    }
}