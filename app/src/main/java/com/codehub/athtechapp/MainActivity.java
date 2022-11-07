package com.codehub.athtechapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        Button button = findViewById(R.id.main_btn_blue);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("App", "The user pressed the button!!!");
            }
        });

        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
//                Toast.makeText(MainActivity.this, "User pressed the button", Toast.LENGTH_LONG).show();
                Snackbar.make(v, "User pressed the button", 5000).show();
                return false;
            }
        });

        TextView textView = findViewById(R.id.main_txt_title);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Textview clicked!!!", 2500).show();
            }
        });

        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, "Long clicked event!!!", Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        EditText editText = findViewById(R.id.main_edit_input);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("APP", s + String.valueOf(start) + String.valueOf(count) + String.valueOf(after));
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("APP", s + String.valueOf(start) + String.valueOf(count) + String.valueOf(before));

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("APP", s.toString());

            }
        });
        editText.getText().toString();
        editText.setText("Vassilis");
    }
}
