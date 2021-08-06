package com.pthon;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class Parser {

    //KMP functions
    private static int[] prefixFunction(String s) {
        int[] p = new int[s.length()];
        int k = 0;
        for (int i = 1; i < s.length(); i++) {
            while (k > 0 && s.charAt(k) != s.charAt(i))
                k = p[k - 1];
            if (s.charAt(k) == s.charAt(i))
                ++k;
            p[i] = k;
        }
        return p;
    }

    private static Boolean KMPCheck(String s, String pattern) {
        int m = pattern.length();
        if (m == 0)
            return false;
        int[] p = prefixFunction(pattern);
        for (int i = 0, k = 0; i < s.length(); i++)
            for (; ; k = p[k - 1]) {
                if (pattern.charAt(k) == s.charAt(i)) {
                    if (++k == m)
                        return true;
                    break;
                }
                if (k == 0)
                    break;
            }
        return false;
    }

    public static void loadFilesByExtension(File path, List<File> fileList) {
        if (path.isDirectory() &&  !Files.isSymbolicLink(path.getAbsoluteFile().toPath())) {
            try {
                for (File s : Objects.requireNonNull(path.listFiles())) {
                    if (s.isDirectory()) {
                        loadFilesByExtension(s, fileList);
                    } else {
                        FilesProcessed.increment();

                        if (AppConfig.getCaseSensitive()) {
                            if (s.getName().toLowerCase(Locale.ROOT).endsWith(AppConfig.getExtension())) {
                                fileList.add(s);
                                FilesFounded.increment();
                            }
                        } else {
                            if (s.getName().toLowerCase(Locale.ROOT).endsWith(AppConfig.getExtension().toLowerCase(Locale.ROOT))) {
                                fileList.add(s);
                                FilesFounded.increment();
                            }
                        }

                    }
                }
            } catch (NullPointerException e) {

            }
        }
    }

    public static void loadFilesByFilename(File path, List<File> fileList) {
        if (path.isDirectory() &&  !Files.isSymbolicLink(path.getAbsoluteFile().toPath())) {
            try {
                for (File s : Objects.requireNonNull(path.listFiles())) {
                    if (s.isDirectory()) {
                        loadFilesByFilename(s, fileList);
                    } else {
                        FilesProcessed.increment();

                        if (AppConfig.getCaseSensitive()) {
                            if (KMPCheck(s.getName(), AppConfig.getFilename())) {
                                fileList.add(s);
                                FilesFounded.increment();
                            }
                        } else {
                            if (KMPCheck(s.getName(), AppConfig.getFilename().toLowerCase(Locale.ROOT))) {
                                fileList.add(s);
                                FilesFounded.increment();
                            }
                        }


                    }
                }
            } catch (NullPointerException e) {
            }
        }
    }
}
