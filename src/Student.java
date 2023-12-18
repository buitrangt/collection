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
