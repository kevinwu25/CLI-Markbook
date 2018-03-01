package com.company;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
        String names[];
        int studentNum[];
        int remove[];
        int minus = 0;
        
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

        System.out.println("What are their names? (first name, last name)");
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
            System.out.println("5 - Add/edit marks");
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
                int averageTotal = 0;
                for (int i = 1; i <= classSize; i++) {
                    int average = 0;
                    if (i < 10 && i != remove[i]) {
                        System.out.print("0" + i + ": " + names[i] + " ");
                        for (int j = 0; j < numMarks; j ++) {
                            if (j == numMarks - 1) {
                                average += marks[i - 1][j];
                                System.out.println(marks[i - 1][j] + " average: " + (average / numMarks));
                            } else {
                                average += marks[i - 1][j];
                                System.out.print(marks[i - 1][j] + " ");
                            }
                        }
                    } else if (i != remove[i]) {
                        System.out.print(i + ": " + names[i] + " ");
                        for (int j = 0; j < numMarks; j ++) {
                            if (j == numMarks - 1) {
                                average += marks[i - 1][j];
                                System.out.println(marks[i - 1][j] + " average: " + (average / numMarks));
                            } else {
                                average += marks[i - 1][j];
                                System.out.print(marks[i - 1][j] + " ");
                            }
                        }
                    }
                    averageTotal += average / numMarks;
                }
                int averageFinal = averageTotal / (classSize - minus);
                System.out.println("Class average: " + averageFinal);
                if (averageFinal >= 100 && averageFinal < 420 || averageFinal > 420) {
                    System.out.println("I think your students may be cheating.");
                } else if (averageFinal < 100 && averageFinal >= 90) {
                    System.out.println("Your class is awesome!");
                } else if (averageFinal < 90 && averageFinal >= 80) {
                    System.out.println("Your class is great!");
                } else if (averageFinal < 80 && averageFinal >= 70) {
                    System.out.println("Your class is doing okay.");
                } else if (averageFinal < 69 && averageFinal >= 60) {
                    System.out.println("Your class is struggling.");
                } else if (averageFinal < 60 && averageFinal >= 50) {
                    System.out.println("Your class is doing awful.");
                } else if (averageFinal < 50 && averageFinal >= 0) {
                    System.out.println("Your class is full of idiots!");
                } else if (averageFinal < 0) {
                    System.out.println("How is a negative average even possible?");
                } else if (averageFinal == 69) {
                    System.out.println("nice");
                } else if (averageFinal == 420) {
                    System.out.println("blaze it");
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
                System.out.println();
                System.out.println("Students at risk:");
                int x = 0;
                for (int i = 1; i <= classSize; i++) {
                    int average = 0;
                    int atRisk = 0;
                    if (i != remove[i]) {
                        for (int j = 0; j < numMarks; j ++) {
                            average += marks[i - 1][j];
                        }
                        atRisk = average / numMarks;
                    }
                    if (i != remove[i] && atRisk <= 65) {
                        x += 1;
                    }
                }
                if (x == 0) {
                    System.out.println("Horray! None of your students are at risk, you must be a great teacher :)");
                }
                for (int i = 1; i <= classSize; i++) {
                    int average = 0;
                    int atRisk = 0;
                    if (i != remove[i]) {
                        for (int j = 0; j < numMarks; j ++) {
                            average += marks[i - 1][j];
                        }
                        atRisk = average / numMarks;
                    }
                    if (i < 10 && i != remove[i] && atRisk <= 65) {
                        System.out.println("0" + i + ": " + names[i] + " average: " + atRisk);
                    } else if (i != remove[i] && atRisk <= 65) {
                        System.out.println(i + ": " + names[i] + " average: " + atRisk);
                    }
                }
            } else if (choice == 5) {
                System.out.println();
                System.out.println("Type the 2-digit number of the student who's marks you'd like to e nter: ");
                int student = input.nextInt();
                if (student != remove[student]) {
                    System.out.println(names[student] + "'s marks: ");
                    for (int i = 0; i < numMarks; i ++) {
                        marks[student - 1][i] = input.nextInt();
                    }
                } else { 
                    System.out.println(names[student] + " has been removed already. Don't you remember? You silly goose!");
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
                    minus += 1;
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
