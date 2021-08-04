package com.pthon;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Locale;

public class Parser {
    public static void loadFiles(File path, List<File> fileList) {
        if (path.isDirectory() &&  !Files.isSymbolicLink(path.getAbsoluteFile().toPath())) {
            try {
                for (File s : path.listFiles()) {
                    if (s.isDirectory()) {
                        loadFiles(s, fileList);
                    } else {
                        FilesProcessed.increment();

                        if (s.getName().toLowerCase(Locale.ROOT).endsWith(AppConfig.getExtension())) {
                            fileList.add(s);
                        }
                    }
                }
            } catch (NullPointerException e) {

            }
        }
    }
}
