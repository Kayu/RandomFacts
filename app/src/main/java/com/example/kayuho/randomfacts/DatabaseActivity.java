package com.example.kayuho.randomfacts;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class DatabaseActivity extends AppCompatActivity {
    FactsDBHelper MyDB;
    EditText editFact;
    Button btnAdd, btnDisplay, btnDeleteAll, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        MyDB = new FactsDBHelper(this);

        editFact = (EditText)findViewById(R.id.editFacts);
        btnAdd = (Button)findViewById(R.id.button_add);
        btnDisplay = (Button)findViewById(R.id.button_display);
        btnDeleteAll = (Button)findViewById(R.id.delete_all_button);
        btnReset = (Button)findViewById(R.id.button_reset);
        addFact();
        viewAll();
        deleteAll();
        resetTable();
    }

    public void addFact(){
        btnAdd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = MyDB.insert(editFact.getText().toString());

                        if (isInserted = true)
                            Toast.makeText(DatabaseActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(DatabaseActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void viewAll(){
        btnDisplay.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor data = MyDB.getAllData();
                        if(data.getCount() == 0){
                            showMessage("Error","No Data Found");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while(data.moveToNext()){
                            buffer.append("ID: "+ data.getString(0)+"\n");
                            buffer.append("Fact: "+ data.getString(1)+"\n\n");
                        }
                        showMessage("Data", buffer.toString());
                    }
                }
        );
    }

    public void deleteAll(){
        btnDeleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isDeleted = MyDB.deleteAll();

                if (isDeleted = true)
                    Toast.makeText(DatabaseActivity.this, "All Data Deleted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(DatabaseActivity.this, "Error while deleting data", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void resetTable(){
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
