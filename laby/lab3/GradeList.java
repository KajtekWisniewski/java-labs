package programowanieof.laby.lab3;

import java.util.ArrayList;
import java.util.Collections;

public class GradeList {

    private ArrayList<Double> grades = new ArrayList<Double>();

    public void addGrade(double grade) {
        grades.add(grade);
    }

    private double calculateSum(double sum) {
    for (double num : grades) { 
        sum += num; 
        }
    return sum;
    }

    public double calculateAverage() {
        return calculateSum(0) / grades.size();
    }

    public double findMaximum() {
        return Collections.max(grades);
    }

    public double findMinimum() {
        return Collections.min(grades);
    }

    public boolean checkEmptiness() {
        return grades.isEmpty();
    }
}
