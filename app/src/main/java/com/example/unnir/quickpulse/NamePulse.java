package com.example.unnir.quickpulse;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by unnir on 12/20/2017.
 */

public class NamePulse extends Fragment {
    Calendar currentDateTime;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_create_pulse_namepulse, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText dateTextView = (EditText)view.findViewById(R.id.dateSelector);
        EditText timeTextView = (EditText)view.findViewById(R.id.timeSelector);

        SimpleDateFormat dateF = new SimpleDateFormat("EEE, d MMM yyyy", Locale.getDefault());
        SimpleDateFormat timeF = new SimpleDateFormat("hh:mm", Locale.getDefault());

        currentDateTime = Calendar.getInstance();
        currentDateTime.setTime(Calendar.getInstance().getTime());
        currentDateTime.add(Calendar.HOUR, 4);

        String time = timeF.format(currentDateTime.getTime());
        String date = dateF.format(currentDateTime.getTime());

        dateTextView.setText(date);
        timeTextView.setText(time);

        view.findViewById(R.id.navigaateToOptionsButton).setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            TextView inputTextView = (TextView)getView().findViewById(R.id.pulseNameTextView);
            if(TextUtils.isEmpty(inputTextView.getText()))
            {
                inputTextView.setError("You must give the pulse a name!");
            }
            else {
                DataStore.CurrentPulse.PulseName = inputTextView.getText();

                Fragment fragment = new AddOptions();
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

    public void SelectTime(View view) {

    }

    public void selectDate(View view) {

    }
}
