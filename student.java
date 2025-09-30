Review Comments based on Guidelines:

Line Number: 1
Actual Code: ```public class StudentGrading {```
Topic: Naming Conventions
Guideline: Class names should start with an uppercase letter.
Review Comment: The class name `StudentGrading` adheres to the naming conventions. However, consider making it more descriptive, such as `StudentGradingSystem`, to better reflect its purpose.
Corrected Code: ```public class StudentGradingSystem {```
Explanation: A more descriptive name improves readability and understanding of the code's purpose.
Confidence Score: 0.9

Line Number: 2-40
Actual Code: ```Repeated blocks of code for each student with similar logic```
Topic: Modular Code
Guideline: Break down large methods into smaller, reusable methods that each perform a specific task.
Review Comment: The code for calculating grades and printing results is repeated for each student. This violates the principle of modularity and results in redundancy. Extract this logic into reusable methods.
Corrected Code:
```java
public class StudentGradingSystem {
    public static void main(String[] args) {
        processStudent("Alice", 85, 90, 78);
        processStudent("Bob", 72, 68, 74);
        processStudent("Charlie", 95, 88, 91);
    }

    private static void processStudent(String name, int math, int science, int english) {
        double average = calculateAverage(math, science, english);
        String grade = determineGrade(average);
        printResults(name, average, grade);
    }

    private static double calculateAverage(int math, int science, int english) {
        return (math + science + english) / 3.0;
    }

    private static String determineGrade(double average) {
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else {
            return "D";
        }
    }

    private static void printResults(String name, double average, String grade) {
        System.out.println("Student: " + name);
        System.out.println("Average: " + average);
        System.out.println("Grade: " + grade);
        System.out.println("-----------------------");
    }
}
```
Explanation: Extracting the logic into methods improves modularity, readability, and maintainability. It also eliminates redundancy and makes the code easier to extend for additional students.
Confidence Score: 1.0

Review comments based on NFR aspects:

Performance/Efficiency Review Comments: The repeated calculation of averages and grades for each student can be optimized by using reusable methods, as shown in the corrected code. This reduces redundancy and improves performance.

Dead/Unused Code Review Comments: The comment `// ... imagine more students repeated like above` indicates potential dead code if the logic for additional students is not implemented. Removing or replacing this comment with a dynamic solution is recommended.

Inefficient Code Constructs Review Comments: Repeated blocks of code for each student are inefficient. Using methods for calculations and printing results reduces redundancy and improves efficiency.

Modular Code Review Comments: The code is monolithic and lacks modularity. Extracting the logic into separate methods for calculating averages, determining grades, and printing results improves modularity and adheres to the Single Responsibility Principle.

Refactored Code:
```
public class StudentGradingSystem {
    public static void main(String[] args) {
        processStudent("Alice", 85, 90, 78);
        processStudent("Bob", 72, 68, 74);
        processStudent("Charlie", 95, 88, 91);
    }

    private static void processStudent(String name, int math, int science, int english) {
        double average = calculateAverage(math, science, english);
        String grade = determineGrade(average);
        printResults(name, average, grade);
    }

    private static double calculateAverage(int math, int science, int english) {
        return (math + science + english) / 3.0;
    }

    private static String determineGrade(double average) {
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else {
            return "D";
        }
    }

    private static void printResults(String name, double average, String grade) {
        System.out.println("Student: " + name);
        System.out.println("Average: " + average);
        System.out.println("Grade: " + grade);
        System.out.println("-----------------------");
    }
}
```

This refactored code addresses all issues mentioned in the review comments and adheres to the guidelines provided.