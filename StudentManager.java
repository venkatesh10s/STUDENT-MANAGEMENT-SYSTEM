import java.util.*;
import java.io.*;

public class StudentManager {
    private List<Student> studentList;
    private final String fileName = "students.txt";

    public StudentManager() {
        studentList = new ArrayList<>();
        loadData();
    }

    public void addStudent(Student s) {
        studentList.add(s);
        saveData();
    }

    public List<Student> getAllStudents() {
        return studentList;
    }

    public Student getStudentById(int id) {
        for (Student s : studentList) {
            if (s.getId() == id)
                return s;
        }
        return null;
    }

    public boolean removeStudent(int id) {
        Student s = getStudentById(id);
        if (s != null) {
            studentList.remove(s);
            saveData();
            return true;
        }
        return false;
    }

    public void markAttendance(int id, String date, boolean present) {
        Student s = getStudentById(id);
        if (s != null) {
            s.markAttendance(date, present);
            saveData();
            System.out.println("Attendance marked.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void showAttendance(int id) {
        Student s = getStudentById(id);
        if (s != null) {
            s.showAttendance();
        } else {
            System.out.println("Student not found.");
        }
    }

    public void addGrade(int id, String subject, int marks) {
        Student s = getStudentById(id);
        if (s != null) {
            s.addGrade(subject, marks);
            saveData();
            System.out.println("Grade added.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void showGrades(int id) {
        Student s = getStudentById(id);
        if (s != null) {
            s.showGrades();
        } else {
            System.out.println("Student not found.");
        }
    }

    private void saveData() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(studentList);
            out.close();
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    @SuppressWarnings("unchecked")
    private void loadData() {
        File f = new File(fileName);
        if (!f.exists()) return;

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            studentList = (List<Student>) in.readObject();
            in.close();
        } catch (Exception e) {
            System.out.println("Error loading data.");
        }
    }
}
