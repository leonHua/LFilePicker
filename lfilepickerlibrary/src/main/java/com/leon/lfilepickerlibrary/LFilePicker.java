package com.leon.lfilepickerlibrary;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;

import com.leon.lfilepickerlibrary.model.ParamEntity;
import com.leon.lfilepickerlibrary.ui.LFilePickerActivity;

/**
 * 作者：Leon
 * 时间：2017/3/20 16:57
 */
public class LFilePicker {
    private Activity mActivity;
    private Fragment mFragment;
    private android.support.v4.app.Fragment mSupportFragment;
    private String mTitle;
    private String mTitleColor;
    private int theme = R.style.LFileTheme;
    private int mTitleStyle = R.style.LFileToolbarTextStyle;
    private String mBackgroundColor;
    private int mBackStyle;
    private int mRequestCode;
    private boolean mMutilyMode = true;
    private boolean mChooseMode = true;
    private String mAddText;
    private int mIconStyle;
    private String[] mFileTypes;
    private String mNotFoundFiles;
    private int mMaxNum;
    private String mStartPath;
    private boolean mIsGreater = true;//是否大于
    private long mFileSize;

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
     * 绑定Fragment
     *
     * @param fragment
     * @return
     */
    public LFilePicker withFragment(Fragment fragment) {
        this.mFragment = fragment;
        return this;
    }

    /**
     * 绑定v4包Fragment
     *
     * @param supportFragment
     * @return
     */
    public LFilePicker withSupportFragment(android.support.v4.app.Fragment supportFragment) {
        this.mSupportFragment = supportFragment;
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
    @Deprecated
    public LFilePicker withTitleColor(String color) {
        this.mTitleColor = color;
        return this;
    }

    /**
     * 设置主题
     *
     * @param theme
     * @return
     */
    public LFilePicker withTheme(@StyleRes int theme) {
        this.theme = theme;
        return this;
    }

    /**
     * 设置标题的颜色和字体大小
     *
     * @param style
     * @return
     */
    public LFilePicker withTitleStyle(@StyleRes int style) {
        this.mTitleStyle = style;
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

    /**
     * 请求码
     *
     * @param requestCode
     * @return
     */
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

    /**
     * 设置选择模式，默认为true,多选；false为单选
     *
     * @param isMutily
     * @return
     */
    public LFilePicker withMutilyMode(boolean isMutily) {
        this.mMutilyMode = isMutily;
        return this;
    }

    /**
     * 设置多选时按钮文字
     *
     * @param text
     * @return
     */
    public LFilePicker withAddText(String text) {
        this.mAddText = text;
        return this;
    }

    /**
     * 设置文件夹图标风格
     *
     * @param style
     * @return
     */
    public LFilePicker withIconStyle(int style) {
        this.mIconStyle = style;
        return this;
    }

    public LFilePicker withFileFilter(String[] arrs) {
        this.mFileTypes = arrs;
        return this;
    }

    /**
     * 没有选中文件时的提示信息
     *
     * @param notFoundFiles
     * @return
     */
    public LFilePicker withNotFoundBooks(String notFoundFiles) {
        this.mNotFoundFiles = notFoundFiles;
        return this;
    }

    /**
     * 设置最大选中数量
     *
     * @param num
     * @return
     */
    public LFilePicker withMaxNum(int num) {
        this.mMaxNum = num;
        return this;
    }

    /**
     * 设置初始显示路径
     *
     * @param path
     * @return
     */
    public LFilePicker withStartPath(String path) {
        this.mStartPath = path;
        return this;
    }

    /**
     * 设置选择模式，true为文件选择模式，false为文件夹选择模式，默认为true
     *
     * @param chooseMode
     * @return
     */
    public LFilePicker withChooseMode(boolean chooseMode) {
        this.mChooseMode = chooseMode;
        return this;
    }

    /**
     * 设置文件大小过滤方式：大于指定大小或者小于指定大小
     *
     * @param isGreater true：大于 ；false：小于，同时包含指定大小在内
     * @return
     */
    public LFilePicker withIsGreater(boolean isGreater) {
        this.mIsGreater = isGreater;
        return this;
    }

    /**
     * 设置过滤文件大小
     *
     * @param fileSize
     * @return
     */
    public LFilePicker withFileSize(long fileSize) {
        this.mFileSize = fileSize;
        return this;
    }

    public void start() {
        if (mActivity == null && mFragment == null && mSupportFragment == null) {
            throw new RuntimeException("You must pass Activity or Fragment by withActivity or withFragment or withSupportFragment method");
        }
        Intent intent = initIntent();
        Bundle bundle = getBundle();
        intent.putExtras(bundle);

        if (mActivity != null) {
            mActivity.startActivityForResult(intent, mRequestCode);
        } else if (mFragment != null) {
            mFragment.startActivityForResult(intent, mRequestCode);
        } else {
            mSupportFragment.startActivityForResult(intent, mRequestCode);
        }
    }


    private Intent initIntent() {
        Intent intent;
        if (mActivity != null) {
            intent = new Intent(mActivity, LFilePickerActivity.class);
        } else if (mFragment != null) {
            intent = new Intent(mFragment.getActivity(), LFilePickerActivity.class);
        } else {
            intent = new Intent(mSupportFragment.getActivity(), LFilePickerActivity.class);
        }
        return intent;
    }

    @NonNull
    private Bundle getBundle() {
        ParamEntity paramEntity = new ParamEntity();
        paramEntity.setTitle(mTitle);
        paramEntity.setTheme(theme);
        paramEntity.setTitleColor(mTitleColor);
        paramEntity.setTitleStyle(mTitleStyle);
        paramEntity.setBackgroundColor(mBackgroundColor);
        paramEntity.setBackIcon(mBackStyle);
        paramEntity.setMutilyMode(mMutilyMode);
        paramEntity.setAddText(mAddText);
        paramEntity.setIconStyle(mIconStyle);
        paramEntity.setFileTypes(mFileTypes);
        paramEntity.setNotFoundFiles(mNotFoundFiles);
        paramEntity.setMaxNum(mMaxNum);
        paramEntity.setChooseMode(mChooseMode);
        paramEntity.setPath(mStartPath);
        paramEntity.setFileSize(mFileSize);
        paramEntity.setGreater(mIsGreater);
        Bundle bundle = new Bundle();
        bundle.putSerializable("param", paramEntity);
        return bundle;
    }
}
