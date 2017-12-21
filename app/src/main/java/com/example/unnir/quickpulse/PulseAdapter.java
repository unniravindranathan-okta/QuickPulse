package com.example.unnir.quickpulse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by unnir on 12/21/2017.
 */
public class PulseAdapter extends ArrayAdapter<Pulse> {

    private ArrayList<Pulse> items;

    public PulseAdapter(Context context, int textViewResourceId, ArrayList<Pulse> items) {
        super(context, textViewResourceId, items);
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            v = LayoutInflater.from(getContext()).inflate(R.layout.pulse_custom_list_view, null);
        }
        Pulse pulse = items.get(position);
        if (pulse != null) {
            TextView pulseNameText = (TextView) v.findViewById(R.id.listView_PulseName);
            TextView pulseAuthorText = (TextView) v.findViewById(R.id.listView_PulseAuthor);
            TextView pulseStatusText = (TextView) v.findViewById(R.id.listView_PulseStatus);
            if (pulseNameText != null) {
                pulseNameText.setText(pulse.PulseName);                            }
            if(pulseAuthorText != null){
                pulseAuthorText.setText("unnir@microsoft.com");
            }
            if(pulseStatusText != null){
                pulseStatusText.setText("Active");
            }
        }
        return v;
    }
}
