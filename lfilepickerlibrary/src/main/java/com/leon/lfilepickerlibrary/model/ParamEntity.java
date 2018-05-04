package com.leon.lfilepickerlibrary.model;

import com.leon.lfilepickerlibrary.R;

import java.io.Serializable;

/**
 * 作者：Leon
 * 时间：2017/3/21 14:50
 */
public class ParamEntity implements Serializable {
    private String title;
    private String titleColor;
    private int titleStyle ;
    private int theme ;
    private String backgroundColor;
    private int backIcon;
    private boolean mutilyMode;
    private String addText;
    private int iconStyle;
    private String[] fileTypes;
    private String notFoundFiles;
    private int maxNum;
    private boolean chooseMode = true;
    private String path;
    private long fileSize;
    private boolean isGreater;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Deprecated
    public String getTitleColor() {
        return titleColor;
    }

    @Deprecated
    public void setTitleColor(String titleColor) {
        this.titleColor = titleColor;
    }

    public int getTheme() {
        return theme;
    }

    public void setTheme(int theme) {
        this.theme = theme;
    }

    public int getTitleStyle() {
        return titleStyle;
    }

    public void setTitleStyle(int titleStyle) {
        this.titleStyle = titleStyle;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public boolean isMutilyMode() {
        return mutilyMode;
    }

    public void setMutilyMode(boolean mutilyMode) {
        this.mutilyMode = mutilyMode;
    }

    public int getBackIcon() {
        return backIcon;
    }

    public void setBackIcon(int backIcon) {
        this.backIcon = backIcon;
    }

    public String getAddText() {
        return addText;
    }

    public void setAddText(String addText) {
        this.addText = addText;
    }

    public int getIconStyle() {
        return iconStyle;
    }

    public void setIconStyle(int iconStyle) {
        this.iconStyle = iconStyle;
    }

    public String[] getFileTypes() {
        return fileTypes;
    }

    public void setFileTypes(String[] fileTypes) {
        this.fileTypes = fileTypes;
    }

    public String getNotFoundFiles() {
        return notFoundFiles;
    }

    public void setNotFoundFiles(String notFoundFiles) {
        this.notFoundFiles = notFoundFiles;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public boolean isChooseMode() {
        return chooseMode;
    }

    public void setChooseMode(boolean chooseMode) {
        this.chooseMode = chooseMode;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public boolean isGreater() {
        return isGreater;
    }

    public void setGreater(boolean greater) {
        isGreater = greater;
    }
}
