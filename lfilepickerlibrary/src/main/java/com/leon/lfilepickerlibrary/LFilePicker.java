package com.leon.lfilepickerlibrary;

import android.app.Activity;
import android.content.Intent;

import com.leon.lfilepickerlibrary.ui.LFilePickerActivity;

/**
 * 作者：Leon
 * 时间：2017/3/20 16:57
 */
public class LFilePicker {
    private Activity mActivity;
    private String mTitle;

    public LFilePicker withActivity(Activity activity) {
        this.mActivity = activity;
        return this;
    }

    public LFilePicker withTitle(String title) {
        this.mTitle = title;
        return this;
    }

    public void start() {
        mActivity.startActivity(new Intent(mActivity, LFilePickerActivity.class));
    }
}
