package com.mig.cpsudev.mynote;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class NoteActivity extends AppCompatActivity {

    MyHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
    }

    @Override
    protected void onResume() {
        super.onResume();
        dbHelper = new MyHelper(this);
        db = dbHelper.getWritableDatabase();

        Cursor cursor = readAllData();
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this,
                R.layout.note_list,
                cursor,
                new String[]{MyHelper.COL_PRIORITY, MyHelper.COL_TITLE},
                new int[]{R.id.textView1, R.id.textView2}
        );
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(NoteActivity.this, DetailActivity.class);
                i.putExtra("position", position);
                startActivity(i);
            }
        });
    }

    private Cursor readAllData() {
        String[] columns = {
                MyHelper.COL_ID,
                MyHelper.COL_TITLE,
                MyHelper.COL_DETAIL,
                MyHelper.COL_PRIORITY
        };
        Cursor cursor = db.query(MyHelper.TABLE_NAME, columns, null, null, null, null, null);

        return cursor;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.note_menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i = new Intent(NoteActivity.this, AddNoteActivity.class);
        startActivity(i);

        return super.onOptionsItemSelected(item);
    }
}
