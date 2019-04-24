package com.team.termproject;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class App extends Application {

    public static final String CHANNEL_1_ID = "channel1";
    public static final String CHANNEL_2_ID = "channel2";

    public void onCreate() {
        super.onCreate();

        creatNotificationChannels();
    }

    private void creatNotificationChannels() {
        int importance = NotificationManager.IMPORTANCE_HIGH;
        int importance2 = NotificationManager.IMPORTANCE_LOW;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel1 = new NotificationChannel(CHANNEL_1_ID, "channel 1", importance);
            channel1.setDescription("This is Channel 1");

            NotificationChannel channel2 = new NotificationChannel(CHANNEL_2_ID, "channel 2", importance2);
            channel2.setDescription("This is Channel 2");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);
        }


    }
}
