package com.example.fiazm.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends FragmentActivity implements QuestionOne.ReceiveCount, QuestionTwo.ReceiveCount, QuestionThre.ReceiveCount, QuestionFour.ReceiveCount
        , QuestionFive.ReceiveCount, QuestionSix.ReceiveCount, QuestionSev.ReceiveCount, QuestionEight.ReceiveCount, QuestionNine.ReceiveCount, QuestionTen.ReceiveCount {
    TextView question;
    Button button;
    Button exit;
    Button load;
    android.support.v4.app.FragmentTransaction fragmentTransaction;
    int count = 0;
    int numberRight = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question = findViewById(R.id.which_question);
        question.setTextColor(Color.WHITE);
        button = findViewById(R.id.button);
        exit = findViewById(R.id.exitButton);
        load = findViewById(R.id.load);
        final android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        if(count == 0) {
            fragmentTransaction.add(R.id.fragment_main, new QuestionOne());
            fragmentTransaction.commit();
        }
        
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count == 1) {
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_main, new QuestionTwo());
                    fragmentTransaction.commit();
                } else if(count == 2) {
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_main, new QuestionThre());
                    fragmentTransaction.commit();
                } else if(count == 3) {
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_main, new QuestionFour());
                    fragmentTransaction.commit();
                } else if(count == 4) {
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_main, new QuestionFive());
                    fragmentTransaction.commit();
                } else if(count == 5) {
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_main, new QuestionSix());
                    fragmentTransaction.commit();
                } else if(count == 6) {
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_main, new QuestionSev());
                    fragmentTransaction.commit();
                } else if(count == 7) {
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_main, new QuestionEight());
                    fragmentTransaction.commit();
                } else if(count == 8) {
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_main, new QuestionNine());
                    fragmentTransaction.commit();
                } else if(count == 9) {
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_main, new QuestionTen());
                    fragmentTransaction.commit();
                } else if(count == 10) {
                    question.setText("Score: "  + (numberRight * 10) + "%");
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_main, new Ending());
                    fragmentTransaction.commit();
                    button.setText("Restart");
                    count = 11;
                } else if(count == 11) {
                    Intent intent = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    public void receive(int i , int add) {
        count = i;
        numberRight += add;
    }

    public void loadData(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        count = sharedPreferences.getInt("count", 0);
        numberRight = sharedPreferences.getInt("score", 0);
    }

    public void saveData(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("count", count);
        editor.putInt("score", numberRight);
        editor.apply();
        finish();
    }

}
