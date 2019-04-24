package com.team.termproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.w3c.dom.Text;

public class EditDataActivity extends AppCompatActivity {

    private Context mContext;

    private Button btnDelete;
    private ImageView image;
    private TextView nameLbl, payDayLbl, amountLbl, emailLbl, memoLbl;

    private String name, payDay, amount, email, memoBody, imgURL;
    private int selectedID;
    DatabaseHelper mDatabaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);

        btnDelete = (Button) findViewById(R.id.editViewDeleteBtn);
        image = (ImageView) findViewById(R.id.editViewIcon);
        nameLbl = (TextView) findViewById(R.id.editViewNameLbl);
        payDayLbl = (TextView) findViewById(R.id.editViewDayLbl);
        amountLbl = (TextView) findViewById(R.id.editViewPriceLbl);
        emailLbl = (TextView) findViewById(R.id.editViewEmailLbl);
        memoLbl = (TextView) findViewById(R.id.editViewMemoSpaceLbl);
        mDatabaseHelper = new DatabaseHelper(this);

        //get the intent exxtra from the ListActivity
        Intent recievedIntent = getIntent();

        selectedID = recievedIntent.getIntExtra("id", -1);
        name = recievedIntent.getStringExtra("name");
        payDay = recievedIntent.getStringExtra("payDay");
        amount = recievedIntent.getStringExtra("amount");
        email = recievedIntent.getStringExtra("email");
        memoBody = recievedIntent.getStringExtra("memo");
        imgURL = recievedIntent.getStringExtra("imgURL");

        //set text for items in edit page
        nameLbl.setText(name);
        payDayLbl.setText(payDay);
        amountLbl.setText(amount);
        emailLbl.setText(email);
        memoLbl.setText(memoBody);

        imgURL = imgURL.substring(11);

        image.setBackgroundResource(Integer.parseInt(imgURL));


        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabaseHelper.deleteItem(selectedID,name,payDay,amount,email,memoBody,imgURL);

                Intent intent = new Intent(EditDataActivity.this, ListActivity.class);
                startActivity(intent);

                toastMessage("Subscription Deleted!");
            }
        });

    }

    /**
     *
     * @param message
     */
    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
