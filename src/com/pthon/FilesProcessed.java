package com.pthon;

public class FilesProcessed {
    private static long filesProcessed = 0;

    public static long getFilesProcessed() {
        return filesProcessed;
    }

    public static void increment() {
        filesProcessed++;
    }

}
