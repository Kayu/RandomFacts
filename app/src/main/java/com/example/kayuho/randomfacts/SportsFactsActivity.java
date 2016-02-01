package com.example.kayuho.randomfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SportsFactsActivity extends AppCompatActivity {
    String[] facts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports_facts);
        facts = getResources().getStringArray(R.array.sports_facts_array);

        updateTextView();

        Button button_anotherfacts = (Button) findViewById(R.id.button_anothersportsfacts);
        button_anotherfacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTextView();
            }
        });
    }

    public void updateTextView()
    {
        updateTextView update = new updateTextView();
        final TextView textView = (TextView) findViewById(R.id.sportfactstext);
        textView.setText( update.getnewFacts(facts) );
        //android.util.Log.i("DEBUG", "index: " + index + ", fact: " + facts[index]);
    }
}
