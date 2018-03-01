package com.company;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
        String names[];
        int studentNum[];
        int remove[];
        
        System.out.print("What's your name? ");
        String teacher = input.nextLine();

        System.out.print("Hi " + teacher + ", how many students do you have? ");
        int classSize = Integer.parseInt(input.nextLine());
        names = new String[(classSize + 1)];
        studentNum = new int[classSize + 1];
        remove = new int[classSize + 1];
        
        names[0] = " ";
        studentNum[0] = 000;
        remove[0] = 0;

        System.out.print("What grade are they in? ");
        int gradYear = 30 - input.nextInt();

        System.out.println("What are their names?");
        input.nextLine();
        for (int i = 1; i <= classSize; i++) {
            if (i < 10) {
                System.out.print("0" + i + ": ");
                names[i] = input.nextLine();
            } else {
                System.out.print(i + ": ");
                names[i] = input.nextLine();
            }
        }

        Arrays.sort(names);

        System.out.println();
        System.out.println("What are their student numbers?");

        for (int i = 1; i <= classSize; i++) {
            if (i < 10) {
                System.out.print("0" + i + ": " + names[i] + " ");
                studentNum[i] = input.nextInt();
            } else {
                System.out.print(i + ": " + names[i] + " ");
                studentNum[i] = input.nextInt();
            }
        }
        
        System.out.println();
        System.out.print("Finally, how many marks will be submitted in your course? ");
        int numMarks = input.nextInt();
        
        int[][] marks = new int[classSize + 1][numMarks];

        boolean menu = true;
        while (menu == true) {
            // menu to choose actions
            System.out.println();
            System.out.println("What would you like to do? (Enter \"1\", \"2\", \"3\"... etc.)");
            System.out.println("1 - View class list and IDs");
            System.out.println("2 - View class averages");
            System.out.println("3 - View logins");
            System.out.println("4 - Check for at-risk students");
            System.out.println("5 - Add marks");
            System.out.println("6 - Remove students");
            System.out.println("7 - Quit");
            
            int choice = input.nextInt();
            
            if (choice == 1) {
                System.out.println();
                for (int i = 1; i <= classSize; i++) {
                    if (i < 10 && i != remove[i]) {
                        System.out.println("0" + i + ": " + names[i] + " " + studentNum[i]);
                    } else if (i != remove[i]) {
                        System.out.println(i + ": " + names[i] + " "+ studentNum[i]);
                    }
                }
            } else if (choice == 2) {
                System.out.println();
                for (int i = 1; i <= classSize; i++) {
                    if (i < 10 && i != remove[i]) {
                        System.out.print("0" + i + ": " + names[i] + " ");
                        for (int j = 0; j < numMarks; j ++) {
                            if (j == numMarks - 1) {
                                System.out.println(marks[i - 1][j]);
                            } else {
                                System.out.print(marks[i - 1][j] + " ");
                            }
                        }
                    } else if (i != remove[i]) {
                        System.out.print(i + ": " + names[i] + " ");
                        for (int j = 0; j < numMarks; j ++) {
                            if (j == numMarks - 1) {
                                System.out.println(marks[i - 1][j]);
                            } else {
                                System.out.print(marks[i - 1][j] + " ");
                            }
                        }
                    }
                } 
            } else if (choice == 3) {
                System.out.println();
                System.out.println("first name, last name, email, password");
                for (int i = 1; i <= classSize; i++) {
                    String email = names[i].substring(0, 1).toLowerCase() + names[i].substring(1, (names[i].indexOf(" "))) + "." + names[i].substring(names[i].indexOf(" ") + 1, names[i].indexOf(" ") + 2).toLowerCase()+ names[i].substring(names[i].indexOf(" ") + 2) + gradYear + "@ycdsbk12.ca";
                    String password = names[i].substring(0, 1).toUpperCase() + names[i].substring(names[i].indexOf(" ") + 1, names[i].indexOf(" ") + 2).toLowerCase() + studentNum[i];
                    if (i < 10 && i != remove[i]) {
                        System.out.println("0" + i + ": " + names[i] + " " + email + " " + password);
                    } else if (i != remove[i]) {
                        System.out.println(i + ": " + names[i] + " " + email + " " + password);
                    }
		}
            } else if (choice == 4) {
                
            } else if (choice == 5) {
                System.out.println();
                System.out.println("Type the 2-digit number of the student who's marks you'd like to enter: ");
                int student = input.nextInt();
                System.out.println(names[student] + "'s marks: ");
                for (int i = 0; i < numMarks; i ++) {
                    marks[student - 1][i] = input.nextInt();
                }
            } else if (choice == 6) {
                System.out.println();
                for (int i = 1; i <= classSize; i++) {
                    if (i < 10 && i != remove[i]) {
                        System.out.println("0" + i + ": " + names[i]);
                    } else if (i != remove[i]) {
                        System.out.println(i + ": " + names[i]);
                    }
                }
                System.out.println("Which student whould you like to remove? (type the 2-digit number to the left of their name)");
                for (int i = 1; i < 2; i ++) {
                    int delete = input.nextInt();
                    remove[delete] = delete;
                    System.out.println(names[delete] + " has been removed from the class list.");
                }
            } else if (choice == 7) {
                System.out.println("Are you sure you want to quit? Press 1 to quit or 2 to go back to the menu");
                int quit = input.nextInt();
                if (quit == 1) {
                    menu = false;
                } else if (quit == 2) {
                    menu = true;
                }
            } else {
                System.out.println("error: please select one of the below options");
            }
        }
    }
}
