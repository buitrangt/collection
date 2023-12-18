import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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
