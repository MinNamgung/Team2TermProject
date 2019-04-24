package com.team.termproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class AddActivity extends AppCompatActivity {

    private Button button;
    DatabaseHelper mDatabaseHelper;
    private EditText nameEt;
    private EditText dayOfPayEt;
    private EditText amountEt;
    private EditText emailEt;
    private EditText memoEt;


    private Context mContext = AddActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        button = (Button) findViewById(R.id.button);
        nameEt = (EditText) findViewById(R.id.nameTextAdd);
        dayOfPayEt = (EditText) findViewById(R.id.addDayOfPay);
        amountEt = (EditText) findViewById(R.id.addAmount);
        emailEt = (EditText) findViewById(R.id.addEmail);
        memoEt = (EditText) findViewById(R.id.addMemo);
        mDatabaseHelper = new DatabaseHelper(this);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEt.getText().toString();
                String payday = dayOfPayEt.getText().toString();
                String amount = amountEt.getText().toString();
                String email = emailEt.getText().toString();
                String memo = memoEt.getText().toString();

                if(nameEt.length() != 0 && dayOfPayEt.length() != 0 && amountEt.length() != 0 && emailEt.length() != 0 && memoEt.length() != 0){
                    addData(name,payday,amount,email,memo,"drawable://" + R.drawable.money_stack_ico);

                    //add test items

//                    addData("Netflix", "7", "$9.99", "testemail@testemail.com", "Test memo for netflix", "drawable://" + R.drawable.netflix_icon);
//                    addData("Spotify", "29", "$4.99", "testemail@testemail.com", "Test memo for spotify", "drawable://" + R.drawable.spotify_icon);
//                    addData("Chegg", "27", "$14.99", "testemail@testemail.com", "Test memo for chegg", "drawable://" + R.drawable.chegg_icon);
//                    addData("Hulu", "3", "$12.99", "testemail@testemail.com", "Test memo for hulu", "drawable://" + R.drawable.hulu_icon);
//                    addData("Humble Bundle", "5", "$12.00", "testemail@testemail.com", "Test memo for humble bundle", "drawable://" + R.drawable.money_stack_ico);

                }else{
                    toastMessage("You must fill out all input fields!");
                }

                Intent intent = new Intent(AddActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });


    }

    public void addData(String name, String day, String amount, String email, String memo, String img_url){
        boolean insertData = mDatabaseHelper.addData(name,day,amount,email,memo,img_url);

        if(insertData){
            toastMessage("Subscription successfully created!");
        }else{
            toastMessage("Subscription failed to create...");
        }
    }

    /**
     *
     * @param message
     */
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }




}
