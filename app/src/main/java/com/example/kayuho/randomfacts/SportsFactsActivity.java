package com.example.kayuho.randomfacts;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SportsFactsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports_facts);

        updateTextView();

        Button button_anotherfacts = (Button) findViewById(R.id.button_anothersportsfacts);
        button_anotherfacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTextView();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String bg_color = getPrefs.getString("pref_color", "1");
        View mainLayout = findViewById(R.id.sportsLayout);

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

    public void updateTextView()
    {
        final TextView textView = (TextView) findViewById(R.id.sportfactstext);
        textView.setText( new SportFactsModel().getFacts());
        //android.util.Log.i("DEBUG", "index: " + index + ", fact: " + facts[index]);
    }
}
