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

import java.io.InputStream;

public class EditActivity extends AppCompatActivity {

    EditText editTextSubject;
    EditText editTextContent;
    CheckBox pri;

    MyHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Intent i = getIntent();
        int position = i.getIntExtra("position", 0);

        dbHelper = new MyHelper(this);
        db = dbHelper.getWritableDatabase();

        Note newNote = dbHelper.getData(position, db);
        dbHelper.deleteData(position, db);

        editTextSubject = (EditText) findViewById(R.id.editTextSubject);
        editTextContent = (EditText) findViewById(R.id.editTextContent);
        pri = (CheckBox) findViewById(R.id.checkBox);

        editTextSubject.setText(newNote.getTitle());
        editTextContent.setText(newNote.getDetail());
        if (newNote.getPriority().equals("*")) {
            pri.setChecked(true);
        } else
            pri.setChecked(false);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String temp;
        if (pri.isChecked()) {
            temp = "*";
        } else
            temp = "-";
        Note tempNote = new Note(editTextSubject.getText().toString(), editTextContent.getText().toString(), temp);
        dbHelper.addToDB(tempNote, db);
        Toast.makeText(this, "Edit Complete", Toast.LENGTH_SHORT).show();
        finish();
        return super.onOptionsItemSelected(item);
    }
}
