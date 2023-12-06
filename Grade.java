// Author: Shubam Mahi - Chima Ukachukwu (Group Project)

import java.util.Scanner;

public class Grade {
    private double homework;
    private double quiz;

    public Grade() {
        homework = 0;
        quiz = 0;
    }

    public String getLetterGrade(double finalPercentage) {
        if (finalPercentage >= 90) {
            return "A";
        } else if (finalPercentage >= 80) {
            return "B";
        } else if (finalPercentage >= 70) {
            return "C";
        } else if (finalPercentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public void calculateHomework(int... homeworkPercentages) {
        homework = calculateAverage(homeworkPercentages) * 100 / 8;
    }

    public void calculateQuiz(int... quizPercentages) {
        quiz = calculateAverage(quizPercentages) * 100 / 5;
    }

    private double calculateAverage(int... values) {
        double sum = 0;
        for (int value : values) {
            sum += value;
        }
        return (double) sum / values.length;
    }

    public double calculateFinalGrade(int exam1, int exam2, int project) {
        double homeworkWeight = 0.15;
        double quizWeight = 0.05;
        double exam1Weight = 0.25;
        double exam2Weight = 0.30;
        double projectWeight = 0.25;

        return (homework * homeworkWeight) + (quiz * quizWeight) + (exam1 * exam1Weight)
                + (exam2 * exam2Weight) + (project * projectWeight);
    }

    public static void main(String[] args) {
        System.out.println("Name: Shubham Mahi - Chima Ukachukwu (Final Group Project)");

        Scanner scan = new Scanner(System.in);

        int[] homeworkPercentages = new int[8];
        int[] quizPercentages = new int[5];

        for (int i = 0; i < 8; i++) {
            System.out.println("Percent in homework " + (i + 1) + " : ");
            homeworkPercentages[i] = scan.nextInt();
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("Percent in quiz " + (i + 1) + " : ");
            quizPercentages[i] = scan.nextInt();
        }

        System.out.println("Mid term percentage : ");
        int exam1 = scan.nextInt();
        System.out.println("Final term percentage : ");
        int exam2 = scan.nextInt();
        System.out.println("Project percentage : ");
        int project = scan.nextInt();

        Grade grade = new Grade();
        grade.calculateHomework(homeworkPercentages);
        grade.calculateQuiz(quizPercentages);

        double finalPercentage = grade.calculateFinalGrade(exam1, exam2, project);
        String letterGrade = grade.getLetterGrade(finalPercentage);

        System.out.print(" \nFinal Percentage is: " + finalPercentage);
        System.out.println("\nLetter Grade: " + letterGrade);
    }
}
