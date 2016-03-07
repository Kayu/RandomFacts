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

    //onCreate is called when user create this avtivity for the first time
    protected void onCreate(Bundle savedInstanceState) {
        // calls the parent class(AppCompatActivity) onCreate method
        super.onCreate(savedInstanceState);

        //get the preference from the setting activity
        getPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        //set the layout of this activity
        setContentView(R.layout.activity_crazy_facts);

        //call the updateTextView method which displays a random fact msg.
        this.updateTextView();

        //Get the crazy fact button by its id
        Button button_anotherfacts = (Button) findViewById(R.id.button_anothercrazyfacts);

        //when the crazy fact buton is clicked, this method will be activated
        button_anotherfacts.setOnClickListener(new View.OnClickListener() {
            @Override
            // calls the updateViewText method
            public void onClick(View v) {
                updateTextView();
            }
        });
    }

    // When this activity exit the onPause state, it will change the backgroud color depending of the setting activity.
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

    //this creates the setting overflow menu
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
        //get the textView by id
        final TextView textView = (TextView) findViewById(R.id.crazyfactsText);
        //get the preference type of fact from the setting activity
        String fact_type = getPrefs.getString("pref_facts",getResources().getString(R.string.crazy_facts));
        //update the textView by delegating the task to the Model.
        textView.setText( new CrazyFactsModel().getFacts(this,fact_type) );
        //android.util.Log.i("DEBUG", "index: " + index + ", fact: " + facts[index]);
    }
}
