package com.leon.filepicker.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.leon.filepicker.R;
import com.leon.lfilepickerlibrary.LFilePicker;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "FilePickerLeon";
    private int mRequestCode = 1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openFilePicker(View view) {
        new LFilePicker()
                .withActivity(this)
                .withRequestCode(mRequestCode)
                .withTitle("TXT选择")
                .start();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == mRequestCode || resultCode == RESULT_OK) {
            List<String> list = data.getStringArrayListExtra("paths");
            for (String s : list) {
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
            }

        }
    }
}
