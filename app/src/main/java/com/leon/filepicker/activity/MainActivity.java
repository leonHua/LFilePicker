package com.leon.filepicker.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.leon.filepicker.R;
import com.leon.lfilepickerlibrary.LFilePicker;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "FilePickerLeon";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openFilePicker(View view) {
        new LFilePicker().withActivity(this).start();
    }
}
