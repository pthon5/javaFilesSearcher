package com.pthon;

public class AppConfig {
    private static String path;
    private static String extension;
    private static String filename;
    private static Boolean searchExtension = false;
    private static Boolean caseSensitive = false;

    public static Boolean getCaseSensitive() {
        return caseSensitive;
    }

    public static void setCaseSensitive(Boolean caseSensitive) {
        AppConfig.caseSensitive = caseSensitive;
    }

    public static String getFilename() {
        return filename;
    }

    public static void setFilename(String filename) {
        AppConfig.filename = filename;
    }

    public static Boolean getSearchExtension() {
        return searchExtension;
    }

    public static void setSearchExtension(Boolean searchExtension) {
        AppConfig.searchExtension = searchExtension;
    }

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
