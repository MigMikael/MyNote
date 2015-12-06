package com.mig.cpsudev.mynote;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {

    Note newNote;
    Boolean priority;
    MyHelper dbHelper;
    SQLiteDatabase db;

    EditText editTextSubject;
    EditText editTextContent;
    CheckBox pri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        dbHelper = new MyHelper(this);
        db = dbHelper.getWritableDatabase();

        editTextSubject = (EditText)findViewById(R.id.editTextSubject);
        editTextContent = (EditText)findViewById(R.id.editTextContent);

        pri = (CheckBox) findViewById(R.id.checkBox);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        priority = pri.isChecked();
        String temp;
        if (priority)
            temp = "*";
        else
            temp = "-";
        newNote = new Note(editTextSubject.getText().toString(), editTextContent.getText().toString(), temp);
        dbHelper.addToDB(newNote,db);
        Toast.makeText(AddNoteActivity.this, "Add Complete", Toast.LENGTH_SHORT).show();
        finish();
        return super.onOptionsItemSelected(item);
    }
}
