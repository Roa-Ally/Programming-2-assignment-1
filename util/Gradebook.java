/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package util;

import java.util.*;

public class Gradebook {
    private ArrayList<Student> listOfStudents; // Array List that holds student information

	public Gradebook(){
		listOfStudents = new ArrayList<>();
	}

	public void addStudent(Student student){ // Method that add student info into the Array List
		listOfStudents.add(student);

	}
	public boolean setFirstName(String firstName) { // Method that checks first name requirements
		if (Character.isLowerCase(firstName.charAt(0))) { // Checking if first name starts with a lowercase
			System.out.println("Error firstName cannot begin with a lowercase letter! Please try again");
			return false; // returns false triggering the if statement restarting the loop
		}
		for (int i = 0; i < firstName.length(); i++) { // a for loop that will go through the first name to make sure it meets the requirements
			if (Character.isDigit(firstName.charAt(i))) { // Checking if first name contains any digits
				System.out.println("Error firstName cannot contain digits! Please try again");
				return false;

			}
		}
		return true; // doesn't trigger the if statement allowing code to continue
	}

	public boolean setLastName(String lastName){ // Method that checks last name requirements
		if (Character.isLowerCase(lastName.charAt(0))) { // Checking if first name starts with a lowercase
			System.out.println("Error firstName cannot begin with a lowercase letter! Please try again");
			return false;
		}
		for (int i = 0; i < lastName.length(); i++) { // a for loop that will go through the first name to make sure it meets the requirements
			if (Character.isDigit(lastName.charAt(i))) { // Checking if first name contains any digits
				System.out.println("Error firstName cannot contain digits! Please try again");
				return false;

			}
		}
		return true;
	}
	public boolean checkPid(int pid){ // Method that checks PID requirement
		String str = Integer.toString(pid); // converting pid to a string to make sure it meets the requirements
		int size = str.length();
		if(size!=7){ // pid has to be seven digits long if it's less than seven digits long the inputted a leading zero and need to scan again if it larger than seven they inputted the wrong format and need to try again
			System.out.println("Error PID must be seven digits long and cannot start with 0! Please try again");
			return false;// if pid is not exactly seven input needs to be scanned again
		} else
			return true;
	}

	public boolean setScore(int score){ // Method that check Score requirement
		if ((score < 0) || (score > 100)){ // Checking if score is less than zero or greater than 100
			System.out.println("Error Grade must be a non-negative number that does not exceed 100! Please try again");
			return false; // If score is less than 0 or greater than 100 input needs to be scanned again

		}else
			return true;
	}
    public double calculateAvg() { // Calculate average of the student score input
	double sum = 0;
	for(Student s: listOfStudents)
	    sum += s.getGrade().getScore();
	return sum / listOfStudents.size();
    }
    public float calculateMedian() { // Calculate the median of the student score input
		int i = 0, n = listOfStudents.size();
		int[] scores = new int[n];
		for(Student s: listOfStudents)
			scores[i++] = s.getGrade().getScore();
		Arrays.sort(scores);
		if (n % 2 == 0)
			return (scores[n / 2] + scores[n / 2 - 1]) / 2.0f;
		else
			return scores[n / 2];
    }
	public float calculateMin(){ // Calculates the minimum of the student score input
		int i = 0, n = listOfStudents.size();
		int[] scores = new int[n];
		for(Student s: listOfStudents)
			scores[i++] = s.getGrade().getScore();
		Arrays.sort(scores);
		return scores[0];
	}
	public float calculateMax(){ // Calculates the maximum of the student score input
		int i = 0, n = listOfStudents.size();
		int[] scores = new int[n];
		for(Student s: listOfStudents)
			scores[i++] = s.getGrade().getScore();
		Arrays.sort(scores);
		return scores[scores.length -1];

	}
	public String minLetter(){ // Calculate the minimum letter based of the student score input
		int i = 0, n = listOfStudents.size();
		String [] letterG = new String[n];
		for (Student s: listOfStudents)
			letterG[i++] = s.getGrade().getLetterGrade();
		Arrays.sort(letterG);
		return letterG[letterG.length-1];
	}
	public String maxLetter(){ // Calculate the maximum letter based of the student score input
		int i = 0, n = listOfStudents.size();
		String [] letterG = new String[n];
		for (Student s: listOfStudents)
			letterG[i++] = s.getGrade().getLetterGrade();
		Arrays.sort(letterG);
		return letterG[0];

	}
	public void getLetter(String command2, int pid){ // takes string and int input to find letter grade that matches PID input
		String letterG = " ";
		for (Student s: listOfStudents){ // going through the array list that holds student info
			if (s.getPid() == pid ){ // finding the pid that matches in input
				letterG = s.getGrade().getLetterGrade(); // Getting the letter associated with that PID
				System.out.println("The letter for the student with the PID: " + pid + " is " + letterG); // Printing out letter grade

			}else
				System.out.println("Invalid PID input! Please try again"); // if there is not a pid match that means there was an input error on the users part
		}
	}
	public void getName(String command2, int pid){ // takes string and int input to find name that matches PID input
		String name = " ";
		for (Student s: listOfStudents){
			if (s.getPid() == pid){
				System.out.println("The full name of the student with the PID: " + pid + " is " + s.getFirstName() + " " + s.getLastName()); // Printing out first and last name after it matches PID
			}else {
				System.out.println("Invalid PID Input! Please try again");
			}
		}
	}

	public void change(String command2, int pid, int score){ // takes string and two int input to change the score of the student that matches that PID
		int nScore = 0;
		for (Student s: listOfStudents){
			if ((score < 0) || (score > 100)){ // Checking if score is less than zero or greater than 100
				System.out.println("Error Grade must be a non-negative number that does not exceed 100! Please try again");

			} else if (s.getPid() == pid){
				nScore = s.getGrade().getScore(); // Getting score associated with PID
				nScore = score; // setting old score equal to new score
				s.setGrade(score); // Calling setGrade method to set the new score as the score in the Array List
				System.out.println("The new grade of the student with the pid " + pid + " is " + score); // Printing out new score to user
			}else {
				System.out.println("Invalid PID input! Please try again");
			}
		}
	}

	public String calculateMedianLetter(){ // Calculating median letter grade by calling calculate median and then creating a new instance in Grade with that score to then call the get letter grade method
		double medianScore = this.calculateMedian();
		Grade gd = new Grade((int)Math.round(medianScore));
		return gd.getLetterGrade();

	}
	public String calculateAverageLetter(){ // Calculating median letter grade by calling calculate average and then creating a new instance in Grade with that score to then call the get letter grade method
		double average = this.calculateAvg();
		Grade gd = new Grade((int)average);
		return gd.getLetterGrade();

	}
	public void printAllStudentsLetter(){ // Prints all student information with letter grade
		System.out.printf("%s\t%s\t%s\t%s\n","First Name","Last Name","PID","Grade");
		for (Student s: listOfStudents)
			System.out.printf("%s\t%s\t%d\t%s\n", s.getFirstName(), s.getLastName(), s.getPid(), s.getGrade().getLetterGrade());
	}

    public void printAllStudents() { // Prints all student information with score
		System.out.printf("%s\t%s\t%s\t%s\n","First Name","Last Name","PID","Grade");
	for(Student s: listOfStudents)
	    System.out.printf("%s\t%s\t%d\t%d\n", s.getFirstName(), s.getLastName(), s.getPid(), s.getGrade().getScore());
    }
}
