package com.team.termproject;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;



public class ListActivity extends AppCompatActivity {
    private static final String TAG = "ListActivity";
    private Context mContext = ListActivity.this;
    private DecimalFormat df = new DecimalFormat("0.00");

    DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        setupToolbar();

        ListView mListView = (ListView) findViewById(R.id.listView);
        TextView totalLbl = (TextView) findViewById(R.id.btmBarAmountTotal);
        TextView leftLbl = (TextView) findViewById(R.id.btmBarAmountLeft);

        mDatabaseHelper = new DatabaseHelper(this);
        ArrayList<Subscription> subList = returnDBList();

        //Set up list
        SubscriptionListAdapter adapter = new SubscriptionListAdapter(this, R.layout.adapter_view_layout, subList);
        mListView.setAdapter(adapter);

        //Set Total Price and Price left

        totalLbl.setText(df.format(setTotalPay(subList)));
        leftLbl.setText(df.format(setLeftToPay(subList)));



        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Subscription sub = (Subscription) parent.getItemAtPosition(position);

                Cursor data = mDatabaseHelper.getItemID(sub.getName(),Integer.toString(sub.getPayDate()),sub.getAmount(),sub.getEmail(),sub.getMemo(),sub.getImgURL());
                int itemID = -1;
                while(data.moveToNext()){
                    itemID = data.getInt(0);
                }
                if(itemID > -1){
                    Intent editScreenIntent = new Intent(ListActivity.this, EditDataActivity.class);
                    editScreenIntent.putExtra("id", itemID);
                    editScreenIntent.putExtra("name", sub.getName());
                    editScreenIntent.putExtra("payDay", Integer.toString(sub.getPayDate()));
                    editScreenIntent.putExtra("amount", sub.getAmount());
                    editScreenIntent.putExtra("email", sub.getEmail());
                    editScreenIntent.putExtra("memo", sub.getMemo());
                    editScreenIntent.putExtra("imgURL", sub.getImgURL());

                    startActivity(editScreenIntent);
                }
                else{
                    toastMessage("No ID associated with that subscription");
                }
            }
        });

    }



    /**
     *
     */
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


//    /**
//     *
//     * @return
//     */
//    public ArrayList<Subscription> returnList(){
//        // List items
//
//
//        Subscription netflix = new Subscription("Netflix", 7, "$9.99", "drawable://" + R.drawable.netflix_icon);
//        Subscription spotify = new Subscription("Spotify", 29, "$4.99", "drawable://" + R.drawable.spotify_icon);
//        Subscription chegg = new Subscription("Chegg", 27, "$14.99", "drawable://" + R.drawable.chegg_icon);
//        Subscription hulu = new Subscription("Hulu", 3, "$12.99", "drawable://" + R.drawable.hulu_icon);
//        Subscription humbleBundle = new Subscription("Humble Bundle", 5, "$12.00", "drawable://" + R.drawable.money_stack_ico);
//
//        //Add the subscription objects to the list
//        ArrayList<Subscription> subList = new ArrayList<>();
//
//        subList.add(netflix);
//        subList.add(spotify);
//        subList.add(chegg);
//        subList.add(hulu);
//        subList.add(humbleBundle);
//
//
//        return subList;
//    }

    /**
     * new list content from db
     */
    public ArrayList<Subscription> returnDBList(){
        Cursor data = mDatabaseHelper.getData();
        ArrayList<Subscription> listOfSubs = new ArrayList<>();

        while(data.moveToNext()){
            String name = data.getString(1);
            String payDay = data.getString(2);
            String amount = data.getString(3);
            String email = data.getString(4);
            String memo = data.getString(5);
            String imgURL = data.getString(6);

            Subscription subItem = new Subscription(name,Integer.parseInt(payDay),amount,email,memo,imgURL);
            listOfSubs.add(subItem);
        }

        return listOfSubs;
    }

    /**
     *
     */
    public void openAddActivity(){
        Intent intent = new Intent(ListActivity.this, AddActivity.class);
        startActivity(intent);
    }

    /**
     *
     */
    public void returnToLogInActivity(){
        Intent intent = new Intent(ListActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void openSetting(){
        Intent intent = new Intent(ListActivity.this, Settings.class);
        startActivity(intent);
    }

    /**
     *
     * @param list
     * @return
     */
    public double setTotalPay(ArrayList<Subscription> list){
        double total = 0;


        for(int i = 0; i < list.size(); i++){
            String temp = list.get(i).getAmount().replaceAll("[$]", "");
            total += Double.parseDouble(temp);
        }

        return total;
    }

    /**
     *
     * @param list
     * @return
     */
    public double setLeftToPay(ArrayList<Subscription> list){
        double left = 0;
        Calendar calendar = Calendar.getInstance();
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);

        for(int i = 0; i < list.size(); i++){
            int temp = list.get(i).getPayDate();


            if(temp > currentDay){
                String amountTemp = list.get(i).getAmount().replaceAll("[$]", "");

                left += Double.parseDouble(amountTemp);
            }
        }
        return left;
    }

    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
