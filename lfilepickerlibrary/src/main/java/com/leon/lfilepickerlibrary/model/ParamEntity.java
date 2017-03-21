package com.leon.lfilepickerlibrary.model;

import java.io.Serializable;

/**
 * 作者：Leon
 * 时间：2017/3/21 14:50
 */
public class ParamEntity implements Serializable{
    private String title;
    private String titleColor;
    private String backgroundColor;
    private int backIcon;
    private boolean mutilyMode;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(String titleColor) {
        this.titleColor = titleColor;
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

}
