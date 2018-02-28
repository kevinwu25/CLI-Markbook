package com.company;
import java.util.Scanner;
import java.util.Arrays;

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
        int gradYear = 30 - input.nextInt();

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

        System.out.println();
        System.out.println("What are their student numbers?");

        for (int i = 0; i < classSize; i++) {
            if (i < 10) {
                System.out.print("0" + (i + 1) + ": " + names[i] + " ");
                studentNum[i] = input.nextInt();
            } else {
                System.out.print((i + 1) + ": " + names[i] + " ");
                studentNum[i] = input.nextInt();
            }
        }

        boolean menu = true;
        while (menu == true) {
            // menu to choose actions
            System.out.println();
            System.out.println("What would you like to do? (Enter \"1\", \"2\", \"3\"... etc.)");
            System.out.println("1 - view class list and IDs");
            System.out.println("2 - view class averages");
            System.out.println("3 - view logins");
            System.out.println("4 - check for at-risk students");
            System.out.println("5 - add marks");
            System.out.println("6 - remove students");
            System.out.println("7 - quit");
            
            int choice = input.nextInt();
            
            if (choice == 1) {
                System.out.println();
                for (int i = 0; i < classSize; i++) {
                    if (i < 10) {
                        System.out.println("0" + (i + 1) + ": " + names[i] + " " + studentNum[i]);
                    } else {
                        System.out.println((i + 1) + ": " + names[i] + " "+ studentNum[i]);
                    }
                }
            } else if (choice == 2) {
                
            } else if (choice == 3) {
                System.out.println();
                System.out.println("first name, last name, email, password");
                for (int i = 0; i < classSize; i++) {
                    String email = names[i].substring(0, 1).toLowerCase() + names[i].substring(1, (names[i].indexOf(" "))) + "." + names[i].substring(names[i].indexOf(" ") + 1, names[i].indexOf(" ") + 2).toLowerCase()+ names[i].substring(names[i].indexOf(" ") + 2) + gradYear + "@ycdsbk12.ca";
                    String password = names[i].substring(0, 1).toUpperCase() + names[i].substring(names[i].indexOf(" ") + 1, names[i].indexOf(" ") + 2).toLowerCase() + studentNum[i];
                    if (i < 10) {
                        System.out.println("0" + (i + 1) + ": " + names[i] + " " + email + " " + password);
                    } else {
                        System.out.println((i + 1) + ": " + names[i] + " " + email + " " + password);
                    }
                }
                
            } else if (choice == 4) {
                
            } else if (choice == 5) {
                
            } else if (choice == 6) {
                
            } else if (choice == 7) {
                menu = false;
            } else {
                System.out.println("error: please select one of the below options");
            }
        }
    }
}
