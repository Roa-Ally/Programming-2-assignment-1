/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package main;
import util.*;
import java.util.Scanner;

public class Main { // Main class that runs the program

    public static void main(String[] args) {

        Gradebook gradebook = new Gradebook(); // Creating a new instance of grade book that will add students to the arraylist listOfStudents

        System.out.println("Welcome to my grade Book!"); // Welcoming message to get user to input required information
        System.out.println("Please enter the information of the first student using the following format:");
        System.out.println("\" firstName lastName PID grade\". ");
        System.out.println("Press Enter when you are done.");
        boolean failedInput = false; // Setting variable to false

        while (true) { // If there is a failedInput = true it will call this message to ask the user to re-enter input
            if(failedInput) {
                System.out.println("Please re-enter the information using the following format:");
                System.out.println("\" firstName lastName PID grade\". ");
                System.out.println("Press Enter when you are done.");
            }
            Scanner scan = new Scanner(System.in); // Creating a Scanner instance to be able to scan inputs from the user
            String studentInfo = scan.nextLine(); // This is scanning the user input
            if (studentInfo.matches("DONE")) { // If input equals "DONE" this will end the loop
                break;
            }
            String[] spaces = studentInfo.split(" ");// This will split the input by spaces to separate each input after a " " and put them into an array
            if (spaces.length != 4) { // If there are more than four splits that means there was a whitespace in between the inputs which is not allowed
                System.out.println("Error no white spaces allowed");
                failedInput = true;
                continue; // White spaces are not allowed so it must scan again
            }
            String firstName = spaces[0]; // Assigning the array[0] into a string that hold the fist name
            if(!gradebook.setFirstName(firstName)) { // Calling the method that checks first name and if it doesn't meet the requirements restart loop
                failedInput = true;
                continue;
            }

            String lastName = spaces[1]; // Assigning the array[1] into a string that hold the last name
            if (!gradebook.setLastName(lastName)){ // Calling the method that checks last name and if it doesn't meet the requirements restart loop
                failedInput = true;
                continue;
            }

            int pid, score; // Labeling pid and score variables as integers
            try { // Converting the string input of array[2] and array[3] as integers
                pid = Integer.parseInt(spaces[2]);
                score = Integer.parseInt(spaces[3]);
            } catch (NumberFormatException ex) { // If the inputs are not numbers it will catch these inputs
                System.out.println("Error PID and Grade must be a number! Please try again");
                continue; // If the inputs are not numbers they need to scan again
            }

            if (!gradebook.checkPid(pid)){ // Calls the method to check PID and if it doesn't meet the requirements restart loop
                failedInput = true;
                continue;
            }
//
            if (!gradebook.setScore(score)){ // Calling the method that checks score and if it doesn't meet the requirements restart loop
                failedInput = true;
                continue;
            }

            Student student = new Student(firstName,lastName,pid, new Grade(score)); // Creating a new instance of student that holds all required student information
            gradebook.addStudent(student); // Using grade book instance to all student information to the method addStudent which will then add it to the arraylist listOfStudents


            System.out.println("Please enter the information of the next student using the same format."); // Message telling the user to input more student information until they are "DONE"
            System.out.println("If there is no more students please enter the keyword \"DONE\"");
            System.out.println("Press Enter when you are done.");

            failedInput = false;

        } // end of first loop
        System.out.println("Please enter a new command"); // Asking user to input new command

        while (true){  // This will loop taking inputs from the user
            Scanner scan = new Scanner(System.in); // Creating a Scanner instance to be able to scan inputs from the user
            String command = scan.nextLine(); // This is scanning the user input
            if (command.matches("quit")){  // If input equals "quit" this will end the loop
                break;
            }
            if (command.matches("min score")){ // If the input matches "min score" it will then calculate min score of all student input
                System.out.println("The minimum score is " + gradebook.calculateMin()); // Printing statement and calling the calculate minimum score method
                System.out.println("Please enter a new command"); // Must continue to ask for new command until input equals "quit"

            }else if (command.matches("max score")){ // If the input matches "max score" it will then calculate max score of all student input
                System.out.println("The maximum score is " + gradebook.calculateMax()); // Printing statement and calling the calculate maximum score method
                System.out.println("Please enter a new command");

            } else if (command.matches("min letter")) { // If the input matches "min letter" it will then calculate minimum letter of all student input
                System.out.println("The minimum letter grade is " + gradebook.minLetter()); // Printing statement and calling the calculate minimum letter method
                System.out.println("Please enter a new command");

            }else if (command.matches("max letter")){ // If the input matches "max letter" it will then calculate maximum letter of all student input
                System.out.println("The maximum letter grade is " + gradebook.maxLetter()); // Printing statement and calling the calculate maximum letter method
                System.out.println("Please enter a new command");

            }else if (command.matches("average score")){ // If the input matches "average score" it will then calculate average score of all student input
                System.out.println("the average score is " + gradebook.calculateAvg()); // Printing statement and calling the calculate average score method
                System.out.println("Please enter a new command");

            }else if (command.matches("average letter")){ // If the input matches "average letter" it will then calculate average letter of all student input
                System.out.println("The average letter is " + gradebook.calculateAverageLetter()); // Printing statement and calling the calculate average letter method
                System.out.println("Please enter a new command");

            } else if (command.matches("median score")) { // If the input matches "median score" it will then calculate median score of all student input
                System.out.println("The median score is " + gradebook.calculateMedian()); // Printing statement and calling the calculate median score method
                System.out.println("Please enter a new command");

            }else if (command.matches("median letter")){ // If the input matches "median letter" it will then calculate median letter of all student input
                System.out.println("The median letter grade is " + gradebook.calculateMedianLetter()); // Printing statement and calling the calculate median letter method
                System.out.println("Please enter a new command");

            } else if (command.matches("tab score")) { // If the input matches "tab score" it will then print out a list of all students
                gradebook.printAllStudents(); // Calling the print all student method
                System.out.println("Please enter a new command");

            } else if (command.matches("tab letters")) { // If the input matches "tab score" it will then print out a list of all students but instead of score it will print out a letter grade instead
                gradebook.printAllStudentsLetter();  // Calling the print all student letter method
                System.out.println("Please enter a new command");

            }else{ // If the input does not match any of the statements above it will then take the input and split it up after every " " and put it into an array to match future if else statements
                String[] parts = command.split(" "); // This will split the input by spaces to separate each input after a " " and put them into an array
                String command2 = parts[0]; // Assigning the array[0] into a string that hold the first part of the command
                int pid; // Labeling pid variable as integers

                try { // Converting the string value of pid and score into integers and checking if it is a number
                    pid = Integer.parseInt(parts[1]);
                } catch (NumberFormatException ex) {
                    System.out.println("Error PID and Grade must be a number! Please try again");
                    continue;
                }
                if (command2.matches("letter")){ // checking if array[0] equal "letter" if it does it will call the getLetter method to find the letter of the student with that pid
                    gradebook.getLetter(command2,pid);
                    System.out.println("Please enter a new command");

                } else if (command2.matches("name")) { // Checking if array[0] equal "name" if it does it will call the getName method to find the name of the student with that pid
                    gradebook.getName(command2,pid);
                    System.out.println("Please enter a new command");

                }else if (command2.matches("change")){ // Checking if array[0] equal "letter" if it does it will call the getLetter method to find the letter of the student with that pid but first it need to split the string again to now read three inputs instead of two
                    command2 = parts[0]; // Assigning the array[0] into a string that hold the first part of the command
                    int score;
                    try { // Converting the string value of pid and score into integers
                        pid = Integer.parseInt(parts[1]);
                        score = Integer.parseInt(parts[2]);
                    } catch (NumberFormatException ex) { // If input is not a number they need to try again
                        System.out.println("Error PID and Grade must be a number! Please try again");
                        continue;
                    }
                    gradebook.change(command2,pid,score); // Calling the change method to change the score input
                    System.out.println("Please enter a new command");
                }


            }




        }
    }

    }