package com.team.termproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;


public class SetNewVersion extends AppCompatActivity {

    Toolbar mToolbar;
    TextView tx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_new_version);

        mToolbar = (Toolbar) findViewById(R.id.toolbar3);
        tx = (TextView) findViewById(R.id.versioninfo);

    }
}
