package ru.geekbrains.android2.bibli_lesson2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView myTextView;
    EditText myEditText;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTextView = findViewById(R.id.myTextView);
        myEditText = (EditText) findViewById(R.id.myEditText);
        button1 = findViewById(R.id.button1);

        initWatcher();
        setOnBtnClick();
    }

    private void initWatcher() {
        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                myTextView.setText(myEditText.getText().toString());
                Toast.makeText(getApplicationContext(), "mnmmnmnm", Toast.LENGTH_SHORT).show();
            }
        };
        myEditText.addTextChangedListener(watcher);
    }

    private void setOnBtnClick() {
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myTextView.setText("lskfdjlk");
            }
        });
    }

}