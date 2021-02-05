package com.cse21;


import java.util.Arrays;
import java.util.Scanner;

class Lab01 {
    public static void printTime(int hour, int minute, double second){
        System.out.println("1");
    return;
    }
    public static void printTime(int hour, int minute, String period){
        System.out.println("2");


        return;
    }
    public static void printTime(int hour, int minute){
        System.out.println("3");
        return;
    }

    public static void main(String[] args) {
        double second = 9.26f;
        int time = 25;
        int minute = 18;
        printTime(time, minute, second);
        if (time == 25) {
            System.out.println("ok");
        }
    }


}