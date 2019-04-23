package com.team.termproject;

import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.sql.Date;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        ListView mListView = (ListView) findViewById(R.id.listView);


        SubscriptionListAdapter adapter = new SubscriptionListAdapter(this, R.layout.adapter_view_layout, returnList());
        mListView.setAdapter(adapter);
    }

    //set up toolbar menu button
    private void setupToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.listViewToolbar);
        setSupportActionBar(toolbar);
    }


    public ArrayList<Subscription> returnList(){
        // List items

        Date netflixDate = new Date(119, 4, 9);
        Subscription netflix = new Subscription("Netflix", netflixDate, "$9.99", "drawable://" + R.drawable.netflix_icon);

        Date spotifyDate = new Date(119, 4, 13);
        Subscription spotify = new Subscription("Spotify", netflixDate, "$4.99", "drawable://" + R.drawable.spotify_icon);

        Date cheggDate = new Date(119, 4, 12);
        Subscription chegg = new Subscription("Chegg", cheggDate, "$14.99", "drawable://" + R.drawable.chegg_icon);

        Date huluDate = new Date(119, 4, 17);
        Subscription hulu = new Subscription("Hulu", huluDate, "$12.99", "drawable://" + R.drawable.hulu_icon);

        Date humbleBundleDate = new Date(119, 4, 11);
        Subscription humbleBundle = new Subscription("Humble Bundle", humbleBundleDate, "$12.00", "drawable://" + R.drawable.humble_bundle_icon);

        //Add the subscription objects to the list
        ArrayList<Subscription> subList = new ArrayList<>();

        subList.add(netflix);
        subList.add(spotify);
        subList.add(chegg);
        subList.add(hulu);
        subList.add(humbleBundle);
        subList.add(netflix);
        subList.add(spotify);
        subList.add(chegg);
        subList.add(hulu);
        subList.add(humbleBundle);
        subList.add(netflix);
        subList.add(spotify);
        subList.add(chegg);
        subList.add(hulu);
        subList.add(humbleBundle);
        subList.add(netflix);
        subList.add(spotify);
        subList.add(chegg);
        subList.add(hulu);
        subList.add(humbleBundle);
        subList.add(netflix);
        subList.add(spotify);
        subList.add(chegg);
        subList.add(hulu);
        subList.add(humbleBundle);
        subList.add(netflix);
        subList.add(spotify);
        subList.add(chegg);
        subList.add(hulu);
        subList.add(humbleBundle);
        subList.add(netflix);
        subList.add(spotify);
        subList.add(chegg);
        subList.add(hulu);
        subList.add(humbleBundle);
        subList.add(netflix);
        subList.add(spotify);
        subList.add(chegg);
        subList.add(hulu);
        subList.add(humbleBundle);

        return subList;
    }
}
