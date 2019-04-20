package com.team.termproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class SubscriptionListAdapter extends ArrayAdapter<Subscription> {

    private static final String TAG = "PersonListAdapter";

    private Context mContext;
    int mResource;

    /**
     * Default constructor for the SubscriptionListAdapter
     * @param context
     * @param resource
     * @param objects
     */
    public SubscriptionListAdapter(Context context, int resource, ArrayList<Subscription> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the subscription information
        String name = getItem(position).getName();
        Date payDate = getItem(position).getPayDate();
        String amount = getItem(position).getAmount();

        //Create the person object with the information
        Subscription subscription = new Subscription(name, payDate, amount);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvName = (TextView) convertView.findViewById(R.id.textView1);
        TextView tvPayDate = (TextView) convertView.findViewById(R.id.textView2);
        TextView tvAmount = (TextView) convertView.findViewById(R.id.textView3);

        tvName.setText(name);
        tvPayDate.setText(payDate.toString());
        tvAmount.setText(amount);

        return convertView;
    }
}
