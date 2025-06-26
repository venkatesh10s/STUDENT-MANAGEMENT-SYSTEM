import java.util.*;
import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;
    private String course;
    private Map<String, Boolean> attendance;
    private Map<String, Integer> grades;

    public Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.attendance = new HashMap<>();
        this.grades = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public void markAttendance(String date, boolean present) {
        attendance.put(date, present);
    }

    public void showAttendance() {
        if (attendance.isEmpty()) {
            System.out.println("No attendance recorded.");
            return;
        }
        for (String date : attendance.keySet()) {
            String status = attendance.get(date) ? "Present" : "Absent";
            System.out.println(date + " : " + status);
        }
    }

    public void addGrade(String subject, int marks) {
        grades.put(subject, marks);
    }

    public void showGrades() {
        if (grades.isEmpty()) {
            System.out.println("No grades available.");
            return;
        }
        for (String subject : grades.keySet()) {
            System.out.println(subject + " : " + grades.get(subject) + " marks");
        }
    }
}
