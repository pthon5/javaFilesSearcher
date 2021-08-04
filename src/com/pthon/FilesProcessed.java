package com.pthon;

public class FilesProcessed {
    private static int filesProcessed = 0;

    public static int getFilesProcessed() {
        return filesProcessed;
    }

    public static void setFilesProcessed(int filesProcessed1) {
        filesProcessed = filesProcessed1;
    }

    public static void increment() {
        filesProcessed++;
    }

}
