package com.leon.filepicker.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.leon.filepicker.R;
import com.leon.lfilepickerlibrary.LFilePicker;
import com.leon.lfilepickerlibrary.utils.Constant;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "FilePickerLeon";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openFromActivity(View view) {
        new LFilePicker()
                .withActivity(this)
                .withRequestCode(Consant.mRequestCodeFromActivity)
                .withTitle("TXT选择")
                .withBackIcon(Constant.BACKICON_STYLETWO)
                .start();
    }

    public void openFragmentActivity(View view) {
        startActivity(new Intent(this, FragmengActivity.class));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == Consant.mRequestCodeFromActivity) {
                List<String> list = data.getStringArrayListExtra("paths");
                for (String s : list) {
                    Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
