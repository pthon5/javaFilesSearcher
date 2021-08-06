package com.pthon;

import java.util.Scanner;

public class UserHelper {
    public static String ask(String question) {
        System.out.print(question);
        return new Scanner(System.in).next();
    }
}
