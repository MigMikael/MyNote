package com.mig.cpsudev.mynote;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    MyHelper dbHelper;
    SQLiteDatabase db;

    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        dbHelper = new MyHelper(this);
        db = dbHelper.getWritableDatabase();

        Intent i = getIntent();
        position = i.getIntExtra("position", 0);
        Toast.makeText(this, String.valueOf(position), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Note newNote = dbHelper.getData(position, db);

        TextView title = (TextView) findViewById(R.id.title);
        TextView detail = (TextView) findViewById(R.id.detail);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        title.setText(newNote.getTitle());
        detail.setText(newNote.getDetail());
        if (newNote.getPriority().equals("*")) {
            imageView.setImageResource(R.drawable.star);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.detail_menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.delete) {
            dbHelper.deleteData(position, db);
            Toast.makeText(this, "Delete Complete", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Intent i = new Intent(DetailActivity.this, EditActivity.class);
            i.putExtra("position", position);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
