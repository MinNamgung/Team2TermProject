package com.team.termproject;


import android.app.Notification;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.Button;

import static com.team.termproject.App.CHANNEL_1_ID;
import static com.team.termproject.App.CHANNEL_2_ID;


public class NotificationClass extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;
    private Button button, button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        notificationManager = NotificationManagerCompat.from(this);

        button = (Button) findViewById(R.id.notifBtn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOnChannel1(v);
            }
        });

        button2 = (Button) findViewById(R.id.notifBtn2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOnChannel2(v);
            }
        });



    }

    public void sendOnChannel1(View v){
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.piggyloco)
                .setContentTitle("Upcoming Payment")
                .setContentText("Payment for Netflix due in 2 days!")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .build();

        notificationManager.notify(null,1, notification);
    }



    public void sendOnChannel2(View v){
        Notification notification2 = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.piggyloco)
                .setContentTitle("Upcoming Payment")
                .setContentText("Payment for Netflix due in 2 days!")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .build();

        notificationManager.notify(null,1, notification2);

    }







}
