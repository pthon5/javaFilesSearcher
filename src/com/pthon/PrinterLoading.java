package com.pthon;

import java.io.File;
import java.util.List;

public class PrinterLoading implements Runnable {

    private List<File> fileList;
    private volatile Boolean runnable = true;

    public void terminate() {
        this.runnable = false;
    }


    PrinterLoading(List<File> fileList) {
        this.fileList = fileList;
    }

    @Override
    public void run() {
        while (runnable) {
            System.out.print("\rLoading files... " + FilesProcessed.getFilesProcessed() + " Founded files: " + FilesFounded.getFoundedFiles());
            System.out.flush();

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {

            }
        }

    }
}
