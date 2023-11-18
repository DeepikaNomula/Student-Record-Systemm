import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Student {
    private String studentId;
    private String name;
    private Map<String, Integer> academicPerformance; // CourseName -> Grade
    private int attendance;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.academicPerformance = new HashMap<>();
        this.attendance = 0;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void addGrade(String course, int grade) {
        academicPerformance.put(course, grade);
    }

    public int getGrade(String course) {
        return academicPerformance.getOrDefault(course, -1);
    }

    public void markAttendance() {
        attendance++;
    }

    public int getAttendance() {
        return attendance;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId + "\nName: " + name +
                "\nAcademic Performance: " + academicPerformance +
                "\nAttendance: " + attendance + "\n";
    }
}

public class StudentRecordSystem {
    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Add Student\n2. Add Grade\n3. Mark Attendance\n4. Display Student Records\n5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addGrade();
                    break;
                case 3:
                    markAttendance();
                    break;
                case 4:
                    displayRecords();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private static void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Student ID: ");
        String studentId = scanner.next();
        System.out.print("Enter Name: ");
        String name = scanner.next();

        Student student = new Student(studentId, name);
        students.add(student);
        System.out.println("Student added successfully.");
    }

    private static void addGrade() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Student ID: ");
        String studentId = scanner.next();

        Student student = findStudent(studentId);
        if (student != null) {
            System.out.print("Enter Course Name: ");
            String course = scanner.next();
            System.out.print("Enter Grade: ");
            int grade = scanner.nextInt();
            student.addGrade(course, grade);
            System.out.println("Grade added successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void markAttendance() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Student ID: ");
        String studentId = scanner.next();

        Student student = findStudent(studentId);
        if (student != null) {
            student.markAttendance();
            System.out.println("Attendance marked successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void displayRecords() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static Student findStudent(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }
}
