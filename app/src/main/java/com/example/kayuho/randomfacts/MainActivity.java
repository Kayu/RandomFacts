package com.example.kayuho.randomfacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_quit = (Button) findViewById(R.id.button_quit);
        button_quit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }

    public void goToCrazyFacts(View v){
        android.util.Log.i("DEBUG", "It would be nice if you guys were all Android experts");

        Intent intent = new Intent(MainActivity.this, CrazyFactsActivity.class);
        startActivity(intent);
    }

    public void goToSportsFacts(View v){
        android.util.Log.i("DEBUG", "You wish!!!");

        Intent intent = new Intent(MainActivity.this, SportsFactsActivity.class);
        startActivity(intent);
    }


}


