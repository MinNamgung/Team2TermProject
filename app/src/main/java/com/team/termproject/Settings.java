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

import static com.team.termproject.Notification.CHANNEL_1_ID;
import static com.team.termproject.Notification.CHANNEL_2_ID;

public class Settings extends AppCompatActivity {

    ListView list;
    private NotificationManagerCompat notificationManager;
    private EditText editTextTitle;
    private EditText editTextMessage;

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
                    //intent.putExtra("version", list.getItemAtPosition(position).toString());
                    startActivity(intent);
                }
                else if(position == 1) {
                    Intent intent2 = new Intent(Settings.this, Notification.class);
                    //intent.putExtra("version", list.getItemAtPosition(position).toString());
                    startActivity(intent2);
                }
            }
        });

        notificationManager = NotificationManagerCompat.from(this);

        editTextTitle = findViewById(R.id.notificationTT);
        editTextMessage = findViewById(R.id.notificationmsg);
    }


    public void SendOnChannel1(View v) {
        String title = editTextTitle.getText().toString();
        String message = editTextMessage.getText().toString();

        android.app.Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_date)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManager.notify(1, notification);
    }

    public void SendOnChannel2(View v) {

        String title = editTextTitle.getText().toString();
        String message = editTextMessage.getText().toString();

        android.app.Notification notification = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_sentiment_very_satisfied_black_24dp)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManager.notify(2, notification);
    }
}
