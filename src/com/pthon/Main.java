package com.pthon;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Main {

    static List<File> fileList = new ArrayList<File>();

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner input = new Scanner(System.in);

        System.out.print("Path: ");
        AppConfig.setPath(input.next());

        File root = new File(AppConfig.getPath());

        System.out.print("Extension: ");
        AppConfig.setExtension(input.next());


        //Create Printer
        PrinterLoading printerLoading = new PrinterLoading(fileList);

        //Create thread
        Thread printerLoadingThread = new Thread(printerLoading);

        //loading files
        printerLoadingThread.start();
        Parser.loadFiles(root, fileList);
        printerLoading.terminate();

        System.out.println(" Done.");


        if (fileList.size() == 0) {
            System.out.println("Files not found.");
        } else {
            System.out.println("Founded files: " + fileList.size());
            System.out.println("Write (w) or Show (s) files?");

            OutputWorker outputWorker = new OutputWorker();

            switch (input.next().toLowerCase(Locale.ROOT)) {
                case "w":
                    String fileName = new Date().toString() + ".txt";
                    fileName = fileName.replace(" ", "_");
                    fileName = fileName.replace(":", ".");
                    outputWorker.writeToFile(fileList, fileName);
                    System.out.println("Done. Output filename: " + fileName);
                    break;
                case "s":
                    outputWorker.show(fileList);
                    break;
            }
        }



    }

}


