public class StudentGrading {
    public static void main(String[] args) {
        String student1 = "Alice";
        int math1 = 85;
        int science1 = 90;
        int english1 = 78;
        double average1 = (math1 + science1 + english1) / 3.0;
        String grade1;
        if (average1 >= 90) {
            grade1 = "A";
        } else if (average1 >= 80) {
            grade1 = "B";
        } else if (average1 >= 70) {
            grade1 = "C";
        } else {
            grade1 = "D";
        }
        System.out.println("Student: " + student1);
        System.out.println("Average: " + average1);
        System.out.println("Grade: " + grade1);
        System.out.println("-----------------------");

        String student2 = "Bob";
        int math2 = 72;
        int science2 = 68;
        int english2 = 74;
        double average2 = (math2 + science2 + english2) / 3.0;
        String grade2;
        if (average2 >= 90) {
            grade2 = "A";
        } else if (average2 >= 80) {
            grade2 = "B";
        } else if (average2 >= 70) {
            grade2 = "C";
        } else {
            grade2 = "D";
        }
        System.out.println("Student: " + student2);
        System.out.println("Average: " + average2);
        System.out.println("Grade: " + grade2);
        System.out.println("-----------------------");

        String student3 = "Charlie";
        int math3 = 95;
        int science3 = 88;
        int english3 = 91;
        double average3 = (math3 + science3 + english3) / 3.0;
        String grade3;
        if (average3 >= 90) {
            grade3 = "A";
        } else if (average3 >= 80) {
            grade3 = "B";
        } else if (average3 >= 70) {
            grade3 = "C";
        } else {
            grade3 = "D";
        }
        System.out.println("Student: " + student3);
        System.out.println("Average: " + average3);
        System.out.println("Grade: " + grade3);
        System.out.println("-----------------------");

        // ... imagine more students repeated like above
    }
}
