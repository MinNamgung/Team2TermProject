package com.team.termproject;

import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Settings extends AppCompatActivity {

    ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        list = (ListView) findViewById(R.id.settinglist);
        ArrayList<String> settinglist = new ArrayList<>();
        settinglist.add("Version Information");
        settinglist.add("Notification");
        settinglist.add("Help");
        settinglist.add("App store");

        ArrayAdapter adpter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, settinglist);
        list.setAdapter(adpter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    Intent intent = new Intent(Settings.this, SetNewVersion.class);
                    startActivity(intent);
                }
                else if(position == 1) {
                    Intent intent2 = new Intent(Settings.this, NotificationClass.class);
                    startActivity(intent2);
                }
                else if(position == 2) {
                    Intent intent3 = new Intent(Settings.this, SetHelp.class);
                    startActivity(intent3);
                }
            }
        });

    }


}
