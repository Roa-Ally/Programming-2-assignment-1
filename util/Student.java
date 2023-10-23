/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package util;

public class Student {
    private String firstName;
    private String lastName;
    private int pid;
    private Grade grade;
    public Student(String firstName, String lastName, int pid, Grade grade){ //Constructor that sets student information
        this.firstName = firstName;
        this.lastName = lastName;
        this.pid = pid;
        this.grade = grade;
    }
    public  void setGrade(int score){ // This method changes the score in the change method
        this.grade = new Grade(score);
    }
    public String getFirstName() { // Returns first name
        return firstName;
    }
    public String getLastName() { // Returns last name
        return lastName;
    }
    public int getPid() { //  Return PID
        return pid;
    }
    public Grade getGrade() { // Returns grade
        return grade;
    }
}
