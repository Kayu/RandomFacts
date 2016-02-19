package com.example.kayuho.randomfacts;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_quit = (Button) findViewById(R.id.button_quit);
        button_quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CrazyFactsActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String bg_color = getPrefs.getString("pref_color", "1");
        View mainLayout = findViewById(R.id.mainLayout);

        switch(bg_color){
            case "1":mainLayout.setBackgroundColor(getResources().getColor(R.color.white));
                break;
            case "2":mainLayout.setBackgroundColor(getResources().getColor(R.color.red));
                break;
            case "3":mainLayout.setBackgroundColor(getResources().getColor(R.color.blue));
                break;
            case "4":mainLayout.setBackgroundColor(getResources().getColor(R.color.green));
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        RelativeLayout main = (RelativeLayout) findViewById(R.id.mainLayout);
        switch(id) {
            case R.id.action_settings:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
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

    public void goToDatabase(View v){

        Intent intent = new Intent(MainActivity.this, DatabaseActivity.class);
        startActivity(intent);
    }

    public void goToGoogleMap(View v){
        Uri concordiaUri = Uri.parse("google.streetview:cbll = 39.5692, 97.6583");
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, concordiaUri);
        intent.setPackage("com.google.android.app.maps");
        startActivity(intent);
    }
}


