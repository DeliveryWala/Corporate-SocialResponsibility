package com.example.abhishek.corporatesocialresponsibility.LoginSignup;

/**
 * Created by Abhishek on 04-03-2017.
 */import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.abhishek.corporatesocialresponsibility.R;

public class PasswordRecoveryRequestedActivity extends AppCompatActivity
{
    private Button loginButton;

    @Override
    public void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.password_recovery_requested );

        initUI();
    }

    private void initUI()
    {
        loginButton = (Button) findViewById( R.id.loginButton );

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
