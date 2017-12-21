package com.example.unnir.quickpulse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class VoteActivity extends AppCompatActivity {
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);

        TextView voteTitle = (TextView)findViewById(R.id.voteTitle);
        voteTitle.setText(DataStore.CurrentPulse.PulseName);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, DataStore.CurrentPulse.Options);

        ListView listView = (ListView)findViewById(R.id.voteOptionsList);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        DataStore.CurrentPulse = null;
    }
}
