package com.team.termproject;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;



public class ListActivity extends AppCompatActivity {
    private static final String TAG = "ListActivity";

    private Context mContext = ListActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        setupToolbar();

        ListView mListView = (ListView) findViewById(R.id.listView);
        TextView totalLbl = (TextView) findViewById(R.id.btmBarAmountTotal);
        TextView leftLbl = (TextView) findViewById(R.id.btmBarAmountLeft);

        //Set up list
        SubscriptionListAdapter adapter = new SubscriptionListAdapter(this, R.layout.adapter_view_layout, returnList());
        mListView.setAdapter(adapter);

        //Set Total Price and Price left

        totalLbl.setText(Double.toString(setTotalPay(returnList())));
        leftLbl.setText(Double.toString(setLeftToPay(returnList())));

    }

    //set up toolbar menu button
    private void setupToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.listViewToolbar);
        setSupportActionBar(toolbar);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.menuAdd:
                        openAddActivity();
                        break;
                    case R.id.menuLog:
                        returnToLogInActivity();
                        break;
                    case R.id.menuSettings:
                        openSetting();
                        break;

                }

                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.action_bar_menu, menu);
        return true;
    }


    public ArrayList<Subscription> returnList(){
        // List items


        Subscription netflix = new Subscription("Netflix", 7, "$9.99", "drawable://" + R.drawable.netflix_icon);

        Subscription spotify = new Subscription("Spotify", 29, "$4.99", "drawable://" + R.drawable.spotify_icon);

        Subscription chegg = new Subscription("Chegg", 27, "$14.99", "drawable://" + R.drawable.chegg_icon);

        Subscription hulu = new Subscription("Hulu", 3, "$12.99", "drawable://" + R.drawable.hulu_icon);

        Subscription humbleBundle = new Subscription("Humble Bundle", 5, "$12.00", "drawable://" + R.drawable.money_stack_ico);

        //Add the subscription objects to the list
        ArrayList<Subscription> subList = new ArrayList<>();

        subList.add(netflix);
        subList.add(spotify);
        subList.add(chegg);
        subList.add(hulu);
        subList.add(humbleBundle);


        return subList;
    }


    public void openAddActivity(){
        Intent intent = new Intent(ListActivity.this, AddActivity.class);
        startActivity(intent);
    }

    public void returnToLogInActivity(){
        Intent intent = new Intent(ListActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void openSetting(){
        Intent intent = new Intent(ListActivity.this, Settings.class);
        startActivity(intent);
    }

    public double setTotalPay(ArrayList<Subscription> list){
        double total = 0;


        for(int i = 0; i < list.size(); i++){
            String temp = list.get(i).getAmount().replaceAll("[$]", "");
            total += Double.parseDouble(temp);
        }

        return total;
    }
    public double setLeftToPay(ArrayList<Subscription> list){
        double left = 0;
        Calendar calendar = Calendar.getInstance();
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);

        System.out.println(currentDay);
        System.out.println();
        for(int i = 0; i < list.size(); i++){
            int temp = list.get(i).getPayDate();

            System.out.println();
            System.out.println(temp);
            System.out.println();
            if(temp > currentDay){
                String amountTemp = list.get(i).getAmount().replaceAll("[$]", "");

                left += Double.parseDouble(amountTemp);
            }
        }
        return left;
    }

}
