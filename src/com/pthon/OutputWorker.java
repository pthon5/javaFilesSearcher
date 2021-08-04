package com.pthon;

import com.sun.istack.internal.NotNull;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OutputWorker {
    public void writeToFile(List<File> fileList,String name) {
        try {
            FileWriter fileWriter = new FileWriter(name, true);

            for (File f : fileList) {
                String path = f.getAbsolutePath() + "\n";
                fileWriter.write(path);
            }


            fileWriter.close();
        } catch (IOException e) {

        }
    }

    public void show(List<File> fileList) {
        for (File f : fileList) {
            System.out.println(f.getAbsolutePath());
        }
    }

}
