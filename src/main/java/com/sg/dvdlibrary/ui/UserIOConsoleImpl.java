package com.sg.dvdlibrary.ui;

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    @Override
    public int readInt(String prompt, int min, int max) {

        int userInt = 0;
        do {
            System.out.println(prompt);
            Scanner scanner = new Scanner(System.in);
            userInt += Integer.parseInt(scanner.nextLine());

        }while(userInt < min && userInt > max);
        return userInt;

    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);
        return Double.parseDouble(scanner.nextLine());
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        boolean correctDouble = false;
        double userDouble;
        do {
            System.out.println(prompt);
            Scanner scanner = new Scanner(System.in);
            userDouble = Double.parseDouble(scanner.nextLine());

            correctDouble = userDouble >= min && userDouble <= max;

        } while(correctDouble);
        return userDouble;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);
        return Float.parseFloat(scanner.nextLine());
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        boolean correctFloat = false;
        float userFloat;
        do {
            System.out.println(prompt);
            Scanner scanner = new Scanner(System.in);
            userFloat = Float.parseFloat(scanner.nextLine());

            correctFloat = userFloat >= min && userFloat <= max;

        } while(correctFloat);
        return userFloat;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);
        return Long.parseLong(scanner.nextLine());
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        boolean correctLong = false;
        long userLong;
        do {
            System.out.println(prompt);
            Scanner scanner = new Scanner(System.in);
            userLong = Long.parseLong(scanner.nextLine());

            correctLong = userLong >= min && userLong <= max;

        } while(correctLong);
        return userLong;
    }

}
