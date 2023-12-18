import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Student {
    private String studentId;
    private String name;
    private String gender;
    private String dateOfBirth;
    private String address;
    private String contactNumber;
    private HashSet<String> courses;
    private HashMap<String, Double> grades;

    public Student(String studentId, String name, String gender, String dateOfBirth, String address, String contactNumber) {
        this.studentId = studentId;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.contactNumber = contactNumber;
        this.courses = new HashSet<>();
        this.grades = new HashMap<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public HashSet<String> getCourses() {
        return courses;
    }

    public HashMap<String, Double> getGrades() {
        return grades;
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students;

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayStudents() {
        for (Student student : students) {
            System.out.println("Student ID: " + student.getStudentId());
            System.out.println("Name: " + student.getName());
            System.out.println("Gender: " + student.getGender());
            System.out.println("Date of Birth: " + student.getDateOfBirth());
            System.out.println("Address: " + student.getAddress());
            System.out.println("Contact Number: " + student.getContactNumber());
            System.out.println("Courses: " + student.getCourses());
            System.out.println("Grades: " + student.getGrades());
            System.out.println("------------------------------");
        }
    }

    public void addGrade(String studentId, String course, double grade) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                student.getCourses().add(course);
                student.getGrades().put(course, grade);
            }
        }
    }

    public void displayStudentGrades(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                System.out.println("Grades for Student ID " + studentId + ": " + student.getGrades());
            }
        }
    }

    public double calculateAverageGrade(String studentId) {
        double totalGrade = 0;
        int numOfCourses = 0;

        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                for (double grade : student.getGrades().values()) {
                    totalGrade += grade;
                    numOfCourses++;
                }
            }
        }

        return numOfCourses > 0 ? totalGrade / numOfCourses : 0;
    }

    public void displayHighestScorer() {
        String highestScorerId = "";
        double highestScore = Double.MIN_VALUE;

        for (Student student : students) {
            double studentTotalScore = student.getGrades().values().stream().mapToDouble(Double::doubleValue).sum();
            if (studentTotalScore > highestScore) {
                highestScore = studentTotalScore;
                highestScorerId = student.getStudentId();
            }
        }

        System.out.println("Student with the highest score is Student ID " + highestScorerId + " with a total score of " + highestScore);
    }

    public HashSet<String> findCommonCourses(ArrayList<Student> studentArray) {
        if (studentArray.isEmpty()) {
            return new HashSet<>();
        }

        HashSet<String> commonCourses = new HashSet<>(studentArray.get(0).getCourses());

        for (Student student : studentArray) {
            commonCourses.retainAll(student.getCourses());
        }

        return commonCourses;
    }
}

public class Main {
    public static void main(String[] args) {

        Student student1 = new Student("1001", "Trang", "Female", "01/01/2003", "ha dong", "123-456-7890");
        Student student2 = new Student("1002", "Lụa", "Female", "02/02/2004", "ha dong", "987-654-3210");
        Student student3 = new Student("1003", "Nam", "Male", "03/03/2004", "ha noi", "111-222-3333");


        StudentManagementSystem studentManagementSystem = new StudentManagementSystem();


        studentManagementSystem.addStudent(student1);
        studentManagementSystem.addStudent(student2);
        studentManagementSystem.addStudent(student3);

        System.out.println("List of Students:");
        studentManagementSystem.displayStudents();


        studentManagementSystem.addGrade("1001", "Math", 85.0);
        studentManagementSystem.addGrade("1001", "English", 90.5);
        studentManagementSystem.addGrade("1002", "Math", 78.5);
        studentManagementSystem.addGrade("1002", "History", 88.0);
        studentManagementSystem.addGrade("1003", "Math", 92.5);
        studentManagementSystem.addGrade("1003", "Science", 87.0);


        studentManagementSystem.displayStudentGrades("1001");


        System.out.println("Average grade for Student ID 1001: " + studentManagementSystem.calculateAverageGrade("1001"));

        studentManagementSystem.displayHighestScorer();

        ArrayList<Student> studentArray = new ArrayList<>();
        studentArray.add(student1);
        studentArray.add(student2);


        HashSet<String> commonCourses = studentManagementSystem.findCommonCourses(studentArray);
        System.out.println("Common courses among students in the array: " + commonCourses);
    }
}
