package com.leon.filepicker.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.leon.filepicker.R;

import java.util.List;

public class FragmengActivity extends AppCompatActivity {
    RelativeLayout mRootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmeng);
        mRootLayout = (RelativeLayout) findViewById(R.id.rootlayout);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        FileFragment fileFragment = FileFragment.newInstance();
        transaction.replace(R.id.rootlayout, fileFragment);
        transaction.commit();


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}
