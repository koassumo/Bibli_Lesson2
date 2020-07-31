package ru.geekbrains.android2.bibli_lesson2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView myTextView;
    EditText myEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTextView = findViewById(R.id.myTextView);
        myEditText = findViewById(R.id.myEditText);

        setOnKeyEnterAfterType();
    }

    private void setOnKeyEnterAfterType() {
        myEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                String tx = myEditText.getText().toString();
                myTextView.setText(tx);
                return false;
            }
        });
    }
}