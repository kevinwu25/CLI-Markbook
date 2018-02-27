package com.company;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
        String names[];
        int studentNum[];

        System.out.print("What's your name? ");
        String teacher = input.nextLine();

        System.out.print("Hi " + teacher + ", how many students do you have? ");
        int classSize = Integer.parseInt(input.nextLine());
        names = new String[classSize];
        studentNum = new int[classSize];

        System.out.print("What grade are they in? ");
        int gradYear = 2030 - input.nextInt();

        System.out.println("What are their names?");
        input.nextLine();
        for (int i = 0; i < classSize; i++) {
            if (i < 10) {
                System.out.print("0" + (i + 1) + ": ");
                names[i] = input.nextLine();
            } else {
                System.out.print((i + 1) + ": ");
                names[i] = input.nextLine();
            }
        }

        Arrays.sort(names);

        System.out.println("What are their student numbers?");

        for (int i = 0; i < classSize; i++) {
            if (i < 10) {
                System.out.print("0" + (i + 1) + ": " + names[i] + " ");
                studentNum[i] = input.nextInt();
            } else {
                System.out.println((i + 1) + ": " + names[i] + " ");
                studentNum[i] = input.nextInt();
            }
        }

        boolean menu = true;
        while (menu == true) {
            // menu to choose actions
            System.out.println("");
            System.out.println("What would you like to do now?");
            System.out.println("1 - view class list and marks");
            System.out.println("2 - view class averages");
            System.out.println("3 - view logins");
            System.out.println("4 - check for at-risk students");
            System.out.println("5 - add marks");
            System.out.println("6 - remove students");
            System.out.println("7 - quit");

            if (input.nextInt() == 1) {
               
            } else if (input.nextInt() == 2) {
                
            } else if (input.nextInt() == 3) {
                
            } else if (input.nextInt() == 4) {
                
            } else if (input.nextInt() == 5) {
                
            } else if (input.nextInt() == 6) {
                
            } else if (input.nextInt() == 7) {
                
            } else {
                System.out.println();
            }
        }
    }
}
