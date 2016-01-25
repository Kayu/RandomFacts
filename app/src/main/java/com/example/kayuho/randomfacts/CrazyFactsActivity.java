package com.example.kayuho.randomfacts;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.Random;

public class CrazyFactsActivity extends AppCompatActivity {
    String[] facts;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crazy_facts);
        facts = getResources().getStringArray(R.array.crazy_facts_array);
        updateTextView();

        Button button_anotherfacts = (Button) findViewById(R.id.button_anothercrazyfacts);
        button_anotherfacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTextView();
            }
        });
    }

    public void updateTextView()
    {
        Random rand = new Random();
        int index = rand.nextInt(4);
        TextView textView = (TextView) findViewById(R.id.crazyfactsText);
        textView.setText(facts[index]);
        //android.util.Log.i("DEBUG", "index: " + index + ", fact: " + facts[index]);
    }
}
