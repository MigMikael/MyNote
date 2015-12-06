package com.mig.cpsudev.mynote;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView) findViewById(R.id.textView);
        if (textView.getText().length() <= 6){
            Button one = (Button) findViewById(R.id.button1);
            one.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String prevText = textView.getText().toString();
                    textView.setText(prevText+"1");
                }
            });
            Button two = (Button) findViewById(R.id.button2);
            two.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String prevText = textView.getText().toString();
                    textView.setText(prevText+"2");
                }
            });
            Button three = (Button) findViewById(R.id.button3);
            three.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String prevText = textView.getText().toString();
                    textView.setText(prevText + "3");
                }
            });
            Button four = (Button) findViewById(R.id.button4);
            four.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String prevText = textView.getText().toString();
                    textView.setText(prevText+"4");
                }
            });
            Button five = (Button) findViewById(R.id.button5);
            five.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String prevText = textView.getText().toString();
                    textView.setText(prevText+"5");
                }
            });
            Button six = (Button) findViewById(R.id.button6);
            six.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String prevText = textView.getText().toString();
                    textView.setText(prevText+"6");
                }
            });
            Button seven = (Button) findViewById(R.id.button7);
            seven.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String prevText = textView.getText().toString();
                    textView.setText(prevText+"7");
                }
            });
            Button eight = (Button) findViewById(R.id.button8);
            eight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String prevText = textView.getText().toString();
                    textView.setText(prevText+"8");
                }
            });
            Button nine = (Button) findViewById(R.id.button9);
            nine.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String prevText = textView.getText().toString();
                    textView.setText(prevText+"9");
                }
            });
            Button zero = (Button) findViewById(R.id.button0);
            zero.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String prevText = textView.getText().toString();
                    textView.setText(prevText+"0");
                }
            });
            Button clear = (Button) findViewById(R.id.button_clear);
            clear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView.setText("");
                }
            });
            Button login = (Button) findViewById(R.id.button_login);
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String text = textView.getText().toString();
                    if (text.equals("123456")){
                        Intent i = new Intent(MainActivity.this, NoteActivity.class);
                        startActivity(i);
                    }else {
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("Login Fail")
                                .setMessage("Incorrect Password")
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        textView.setText("");
                                    }
                                }).show();
                    }
                }
            });
        }


    }
}
