package com.company;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
            // All arrays
	    String names[];
        int studentNum[];

        System.out.print("What's your name? ");
        String teacher = input.nextLine();

        System.out.print("Hi " + teacher + ", how many students do you have? ");
        int classSize = Integer.parseInt(input.nextLine());
        names = new String[classSize];
        studentNum = new int[classSize];

        System.out.println("What are their names?");
        for (int i = 0; i < classSize; i++) {
            names[i] = input.nextLine();
        }

        Arrays.sort(names);

        System.out.println("Here's the class list, what are their student numbers? (please input according to alphabetical order)");
        for (int i = 0; i < classSize; i++) {
            if (i < 10) {
                System.out.print("0" + (i + 1) + ": " + names[i] + " ");
                studentNum[i] = input.nextInt();
            } else {
                System.out.println((i + 1) + ": " + names[i] + " ");
                studentNum[i] = input.nextInt();
            }
        }

       System.out.println("");
    }
}
