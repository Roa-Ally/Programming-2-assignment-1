/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package util;

public class Grade {
    private int score;
    private String letterGrade;

    public Grade(int score){ // Sets score
        this.score = score;

    }
    public int getScore() { // Returns score
        return score;
    }
    public String getLetterGrade() { // This method gets the letter from the score input
        if (score >= 90){
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        }else{
            return "F";
        }
    }
}
