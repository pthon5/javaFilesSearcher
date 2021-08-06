package com.pthon;

import javax.jws.soap.SOAPBinding;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Main {

    static List<File> fileList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        AppConfig.setPath(UserHelper.ask("Path: "));

        File rootPath = new File(AppConfig.getPath());

        if (UserHelper.ask("Case sensitive search? (y/n) ").toLowerCase(Locale.ROOT).equals("y")) {
            AppConfig.setCaseSensitive(true);
        }

        switch (UserHelper.ask("Search by extension (e) or file name (f)? ")) {
            case "e":
                AppConfig.setSearchExtension(true);
                AppConfig.setExtension(UserHelper.ask("Extension: "));
                break;
            case "f":
                AppConfig.setFilename(UserHelper.ask("File name: "));
                break;
        }



        //Create Printer
        PrinterLoading printerLoading = new PrinterLoading(fileList);

        //Create thread
        Thread printerLoadingThread = new Thread(printerLoading);

        //loading files
        printerLoadingThread.start();

        if (AppConfig.getSearchExtension()) {
            Parser.loadFilesByExtension(rootPath, fileList);
        } else {
            Parser.loadFilesByFilename(rootPath, fileList);
        }

        printerLoading.terminate();

        System.out.println(" Done.");


        if (fileList.size() == 0) {
            System.out.println("Files not found.");
        } else {
            System.out.println("Founded files: " + fileList.size());
            System.out.println("Write (w) or Show (s) files? ");

            OutputWorker outputWorker = new OutputWorker();

            switch (input.next().toLowerCase(Locale.ROOT)) {
                case "w":
                    String fileName = new Date() + ".txt";
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


