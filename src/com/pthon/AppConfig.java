package com.pthon;

public class AppConfig {
    private static String path;
    private static String extension;

    public static String getPath() {
        return path;
    }

    public static void setPath(String path) {
        AppConfig.path = path;
    }

    public static String getExtension() {
        return extension;
    }

    public static void setExtension(String extension) {
        AppConfig.extension = extension;
    }
}
