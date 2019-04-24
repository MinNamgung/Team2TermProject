package com.team.termproject;

import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Button buttonLog;
    private Button buttonReg;

    private NotificationManagerCompat notificationManager;
    private EditText emailEt;
    private EditText passwordEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEt = (EditText) findViewById(R.id.loginemail);
        passwordEt = (EditText) findViewById(R.id.loginpwd);

        buttonLog = (Button) findViewById(R.id.loginBtn);
        buttonLog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String email = emailEt.getText().toString();
                String pswrd = passwordEt.getText().toString();

                if(email.equals("admin@email.com") && pswrd.equals("password")){
                    openListActivity();
                    toastMessage("Successfully logged in");
                }
                else{
                    toastMessage("Incorrect credentials!");
                }


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

    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
