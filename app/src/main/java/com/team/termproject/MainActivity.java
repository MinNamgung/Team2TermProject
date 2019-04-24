package com.team.termproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private Button buttonLog;
    private Button buttonReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLog = (Button) findViewById(R.id.loginBtn);
        buttonLog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openListActivity();
            }
        });

        buttonReg = (Button) findViewById(R.id.pswdBtn);
        buttonReg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openRegister();
            }
        });
    }

    private void openRegister() {
        Intent intent = new Intent(this, RegisterView.class);
        startActivity(intent);
    }

    public void openListActivity(){
        Intent intent = new Intent(MainActivity.this, ListActivity.class);
        startActivity(intent);
    }
}
