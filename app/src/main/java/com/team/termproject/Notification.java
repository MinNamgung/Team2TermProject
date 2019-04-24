package com.team.termproject;

import android.app.NotificationManager;
import android.app.NotificationChannel;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Build.VERSION_CODES;
import android.view.View;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.EditText;



import java.lang.Object;

import static com.team.termproject.App.CHANNEL_1_ID;
import static com.team.termproject.App.CHANNEL_2_ID;

public class Notification extends AppCompatActivity {

    private NotificationManagerCompat notificationManager;
    private EditText editTextTitle;
    private EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        notificationManager = NotificationManagerCompat.from(this);

        editTextTitle = findViewById(R.id.notificationTT);
        editTextMessage = findViewById(R.id.notificationmsg);
    }


    public void SendOnChannel1(View view) {

        String title = editTextTitle.getText().toString();
        String message = editTextTitle.getText().toString();

        android.app.Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_date)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManager.notify(1, notification);

    }

    public void SendOnChannel2(View view) {

        String title = editTextTitle.getText().toString();
        String message = editTextTitle.getText().toString();

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
