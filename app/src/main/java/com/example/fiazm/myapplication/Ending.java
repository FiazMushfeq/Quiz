package com.example.fiazm.myapplication;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Ending extends Fragment {
    TextView textView;

    public Ending() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_ending, container, false);
        textView = fragmentView.findViewById(R.id.question_text);
        textView.setText("You are finally done! Congrats for taking the quiz!");
        textView.setTextColor(Color.WHITE);
        return  fragmentView;
    }

}
