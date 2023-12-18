import java.util.ArrayList;
import java.util.HashSet;

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
