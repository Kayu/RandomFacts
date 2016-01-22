package com.example.kayuho.randomfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class CrazyFactsActivity extends AppCompatActivity {
    String[] facts = {"crazy_facts1","crazy_facts2", "crazy_facts3", "crazy_facts4"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crazy_facts);
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
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(4);
        TextView textView = (TextView) findViewById(R.id.crazyfactsText);
        // String fact = facts[index];
        textView.setText(facts[index]);
        android.util.Log.i("DEBUG","index: " + index + ", fact: " + facts[index]);
    }
}
