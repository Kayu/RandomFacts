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

public class CrazyFactsActivity extends AppCompatActivity {

    private SharedPreferences getPrefs;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        setContentView(R.layout.activity_crazy_facts);
        this.updateTextView();

        Button button_anotherfacts = (Button) findViewById(R.id.button_anothercrazyfacts);
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
        String bg_color = getPrefs.getString("pref_color", "1");
        View mainLayout = findViewById(R.id.crazyLayout);
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
        final TextView textView = (TextView) findViewById(R.id.crazyfactsText);
        String fact_type = getPrefs.getString("pref_facts",getResources().getString(R.string.crazy_facts));
        textView.setText( new CrazyFactsModel().getFacts(this,fact_type) );
        //android.util.Log.i("DEBUG", "index: " + index + ", fact: " + facts[index]);
    }
}
