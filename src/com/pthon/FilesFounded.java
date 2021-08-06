package com.pthon;

public class FilesFounded {
    private static long foundedFiles = 0;

    public static long getFoundedFiles() {
        return foundedFiles;
    }

    public static void increment() {
        foundedFiles++;
    }
}
