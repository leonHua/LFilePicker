package com.leon.lfilepickerlibrary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.leon.lfilepickerlibrary.model.ParamEntity;
import com.leon.lfilepickerlibrary.ui.LFilePickerActivity;

/**
 * 作者：Leon
 * 时间：2017/3/20 16:57
 */
public class LFilePicker {
    private Activity mActivity;
    private String mTitle;
    private String mTitleColor;
    private String mBackgroundColor;
    private int mBackStyle;
    private int mRequestCode;
    private boolean mMutilyMode = true;

    /**
     * 绑定Activity
     *
     * @param activity
     * @return
     */
    public LFilePicker withActivity(Activity activity) {
        this.mActivity = activity;
        return this;
    }

    /**
     * 设置主标题
     *
     * @param title
     * @return
     */
    public LFilePicker withTitle(String title) {
        this.mTitle = title;
        return this;
    }

    /**
     * 设置辩题颜色
     *
     * @param color
     * @return
     */
    public LFilePicker withTitleColor(String color) {
        this.mTitleColor = color;
        return this;
    }

    /**
     * 设置背景色
     *
     * @param color
     * @return
     */
    public LFilePicker withBackgroundColor(String color) {
        this.mBackgroundColor = color;
        return this;
    }

    public LFilePicker withRequestCode(int requestCode) {
        this.mRequestCode = requestCode;
        return this;
    }

    /**
     * 设置返回图标
     *
     * @param backStyle
     * @return
     */
    public LFilePicker withBackIcon(int backStyle) {
        this.mBackStyle = 0;//默认样式
        this.mBackStyle = backStyle;
        return this;
    }

    public LFilePicker withMutilyMode(boolean isMutily) {
        this.mMutilyMode = isMutily;
        return this;
    }

    public void start() {
        Intent intent = new Intent(mActivity, LFilePickerActivity.class);
        ParamEntity paramEntity = new ParamEntity();
        paramEntity.setTitle(mTitle);
        paramEntity.setTitleColor(mTitleColor);
        paramEntity.setBackgroundColor(mBackgroundColor);
        paramEntity.setBackIcon(mBackStyle);
        paramEntity.setMutilyMode(mMutilyMode);
        Bundle bundle = new Bundle();
        bundle.putSerializable("param", paramEntity);
        intent.putExtras(bundle);
        mActivity.startActivityForResult(intent, mRequestCode);
    }
}
