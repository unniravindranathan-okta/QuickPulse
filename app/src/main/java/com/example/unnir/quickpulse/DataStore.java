package com.example.unnir.quickpulse;

import java.util.ArrayList;

/**
 * Created by unnir on 12/21/2017.
 */
public class DataStore {
    public static ArrayList<Pulse> Pulses = new ArrayList<Pulse>();
    public static Pulse CurrentPulse = null;
    public static boolean HasBeenInitializedWithSampleData = false;

    public DataStore()
    {
        populateSampleData();
    }

    public static void populateSampleData()
    {
        Pulse p1 = new Pulse();
        p1.PulseName = "Who will win the 2016 U.S. Presidential election?";
        p1.Options.add("Hillary Clinton");
        p1.Options.add("Donald J. Trump");
        p1.Options.add("I hope neither wins!");
        p1.Options.add("I could not care less!");
        p1.Friends.add("unnir@outlook.com");
        p1.Friends.add("unni@wharton.upenn.edu");
        p1.Friends.add("unnikrishnan.ravindranathan@gmail.com");
        DataStore.Pulses.add(p1);

        Pulse p2 = new Pulse();
        p2.PulseName = "Which company will be the first to hit USD 1 Trillion maket cap?";
        p2.Options.add("Amazon");
        p2.Options.add("Microsoft");
        p2.Options.add("Google");
        p2.Options.add("Apple");
        p2.Options.add("FaceBook");
        p2.Friends.add("unnir@outlook.com");
        p2.Friends.add("unni@wharton.upenn.edu");
        p2.Friends.add("unnikrishnan.ravindranathan@gmail.com");
        DataStore.Pulses.add(p2);
    }
}