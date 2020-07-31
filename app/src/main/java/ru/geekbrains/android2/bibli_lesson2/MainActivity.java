package ru.geekbrains.android2.bibli_lesson2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import rx.Observable;
import rx.Observer;
import rx.Subscription;


public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = "MainActivity";

    TextView myTextView;
    EditText myEditText;
    String textFromEditView;

    private Observable<String> observable;
    private Observer<String> observer;
    private Subscription mSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTextView = findViewById(R.id.myTextView);
        myEditText = findViewById(R.id.myEditText);

        initObservable();
        initObserver();
        setOnNewSymbol();

        mSubscription = observable.subscribe(observer);
    }

    private void initObservable() {
        observable = Observable.just(textFromEditView);
    }

    private void initObserver() {
        observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                Log.v(LOG_TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.v(LOG_TAG, "onError = " + e);
            }

            @Override
            public void onNext(String s) {
                printNextSymbol (textFromEditView);
                Log.v(LOG_TAG, "onNext = " + s);
            }
        };
    }

    private void setOnNewSymbol() {
        myEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                textFromEditView = myEditText.getText().toString();
                mSubscription = observable.subscribe(observer);
                return false;
            }
        });
    }

    private void printNextSymbol(String s) {
        myTextView.setText(s);
    }
}