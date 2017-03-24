package com.leon.lfilepickerlibrary.filter;

import java.io.File;
import java.io.FileFilter;

/**
 * 作者：Leon
 * 时间：2017/3/24 13:43
 */
public class LFileFilter implements FileFilter {
    private String[] mTypes;

    public LFileFilter(String[] types) {
        this.mTypes = types;
    }

    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return true;
        }
        if (mTypes != null && mTypes.length > 0) {
            for (int i = 0; i < mTypes.length; i++) {
                if (file.getName().endsWith(mTypes[i].toLowerCase()) || file.getName().endsWith(mTypes[i].toUpperCase())) {
                    return true;
                }
            }
        }else {
            return true;
        }
        return false;
    }
}
