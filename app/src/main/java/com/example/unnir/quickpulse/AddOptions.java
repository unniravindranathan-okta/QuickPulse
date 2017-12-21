package com.example.unnir.quickpulse;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AddOptions extends Fragment {
    /** Declaring an ArrayAdapter to set items to ListView */
    ArrayAdapter<String> adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_create_pulse_add_options, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, DataStore.CurrentPulse.Options);

        ListView listView = (ListView)view.findViewById(R.id.optionsList);
        listView.setAdapter(adapter);

        view.findViewById(R.id.addOptionButton).setOnClickListener(onClickListener);
        view.findViewById(R.id.addFriendButton).setOnClickListener(inviteFriendsListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            TextView inputTextView = (TextView)getView().findViewById(R.id.optionText);
            if(TextUtils.isEmpty(inputTextView.getText()))
            {
                inputTextView.setError("Option text cannot be empty!");
            }
            else {
                DataStore.CurrentPulse.Options.add(inputTextView.getText().toString());
                adapter.notifyDataSetChanged();
                inputTextView.setText("");
                inputTextView.setError(null);
            }
        }
    };

    private View.OnClickListener inviteFriendsListener = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            TextView inputTextView = (TextView)getView().findViewById(R.id.optionText);
            if(DataStore.CurrentPulse.Options.size() < 2)
            {
                inputTextView.setError("You must specify at least two options!");
            }
            else {
                Fragment fragment = new AddFriends();
                if(fragment != null) {
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.createpulsescreenarea, fragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        }
    };
}
