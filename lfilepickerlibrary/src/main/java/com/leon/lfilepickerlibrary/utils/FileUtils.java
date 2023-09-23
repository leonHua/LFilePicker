package com.leon.lfilepickerlibrary.utils;

import android.util.Log;

import java.io.File;
import java.io.FileFilter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Dimorinny on 24.10.15.
 */
public class FileUtils {
    public static List<File> getFileListByDirPath(String path, FileFilter filter) {
        File directory = new File(path);
        File[] files = directory.listFiles(filter);
        List<File> result = new ArrayList<>();
        if (files == null) {
            return new ArrayList<>();
        }

        for (int i = 0; i < files.length; i++) {
            result.add(files[i]);
        }
        Collections.sort(result, new FileComparator());
        return result;
    }

    public static String cutLastSegmentOfPath(String path) {
        return path.substring(0, path.lastIndexOf("/"));
    }

    public static String getReadableFileSize(long size) {
        if (size <= 0) return "0";
        final String[] units = new String[]{"B", "KB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return new DecimalFormat("#").format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }

    /**
     * 获取文件长度
     *
     * @param file 文件
     * @return 文件长度
     */
    public static long getFileLength(final File file) {
        if (!isFile(file)) return -1;
        return file.length();
    }

    /**
     * 判断是否是文件
     *
     * @param file 文件
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isFile(final File file) {
        return file != null && file.exists() && file.isFile();
    }

    /**
     * 根据地址获取当前地址下的所有目录和文件，并且排序,同时过滤掉不符合大小要求的文件
     *
     * @param path
     * @return List<File>
     */
    public static List<File> getFileList(String path, FileFilter filter, boolean isGreater, long targetSize) {
        List<File> list = FileUtils.getFileListByDirPath(path, filter);
        for (int i = 0; i < list.size(); i++) {
            File f = list.get(i);
            if (f.isFile()) {
                long size = FileUtils.getFileLength(f);
                if (isGreater) {
                    if (size < targetSize) {
                        list.remove(i);
                        i--; // 删除后我们调整索引
                    }
                } else {
                    if (size > targetSize) {
                        list.remove(i);
                        i--; // 删除后我们调整索引
                    }
                }
            }
        }
        return list;
    }
}
