package com.example.kayuho.randomfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CrazyFactsActivity extends AppCompatActivity {
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
        final TextView textView = (TextView) findViewById(R.id.crazyfactsText);
        textView.setText( new CrazyFactsModel().getFacts() );
        //android.util.Log.i("DEBUG", "index: " + index + ", fact: " + facts[index]);
    }
}
