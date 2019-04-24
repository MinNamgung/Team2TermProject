package com.team.termproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SetHelp extends AppCompatActivity {
    ListView list2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_help);

        list2 = (ListView) findViewById(R.id.helplist);
        ArrayList<String> settinglist2 = new ArrayList<>();
        settinglist2.add("Why is the notification not working? ");
        settinglist2.add("How to add my payment information?");
        settinglist2.add("How to delete my payment information?");
        settinglist2.add("How to invite people(other user)?");

        ArrayAdapter adpter2 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, settinglist2);
        list2.setAdapter(adpter2);

        list2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    Intent intent = new Intent(SetHelp.this, Notification.class);
                    startActivity(intent);
                }
                else if(position == 1) {
                    Intent intent2 = new Intent(SetHelp.this, AddActivity.class);
                    startActivity(intent2);
                }

                else if(position == 2) {
                    Intent intent3 = new Intent(SetHelp.this, EditDataActivity.class);
                    startActivity(intent3);
                }
            }
        });

    }

}

