package com.example.unnir.quickpulse;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AddFriends extends Fragment {
    /** Declaring an ArrayAdapter to set items to ListView */
    ArrayAdapter<String> adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_create_pulse_add_friends, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, DataStore.CurrentPulse.Friends);

        ListView listView = (ListView)view.findViewById(R.id.friendsList);
        listView.setAdapter(adapter);

        view.findViewById(R.id.addFriendButton).setOnClickListener(onClickListener);
        view.findViewById(R.id.sendPulseButton).setOnClickListener(onSendPulse);
    }

    public final static boolean isValidEmail(CharSequence target) {
        if (target == null)
            return false;

        return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            TextView inputTextView = (TextView)getView().findViewById(R.id.friendEmail);
            if(TextUtils.isEmpty(inputTextView.getText()))
            {
                inputTextView.setError("Email address cannot be empty!");
            }
            else if(!isValidEmail(inputTextView.getText())) {
                inputTextView.setError("Email address is not valid!");
            }
            else {
                DataStore.CurrentPulse.Friends.add(inputTextView.getText().toString());
                adapter.notifyDataSetChanged();
                inputTextView.setText("");
                inputTextView.setError(null);
            }
        }
    };

    private View.OnClickListener onSendPulse = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            TextView inputTextView = (TextView)getView().findViewById(R.id.friendEmail);
            if(DataStore.CurrentPulse.Friends.size() == 0)
            {
                inputTextView.setError("You must specify at least one email address!");
            }
            else {
                DataStore.Pulses.add(DataStore.CurrentPulse);
                DataStore.CurrentPulse = null;
                getActivity().finish();
            }
        }
    };
}
