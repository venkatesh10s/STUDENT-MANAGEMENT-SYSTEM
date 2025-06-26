import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        int ch;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Delete Student");
            System.out.println("5. Mark Attendance");
            System.out.println("6. View Attendance");
            System.out.println("7. Add Grades");
            System.out.println("8. View Grades");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();
                    manager.addStudent(new Student(id, name, course));
                    System.out.println("Student added.");
                    break;

                case 2:
                    List<Student> list = manager.getAllStudents();
                    for (Student s : list) {
                        System.out.println(s.getId() + " - " + s.getName() + " - " + s.getCourse());
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    int sid = sc.nextInt();
                    Student found = manager.getStudentById(sid);
                    if (found != null)
                        System.out.println(found.getId() + " - " + found.getName() + " - " + found.getCourse());
                    else
                        System.out.println("Student not found.");
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();
                    if (manager.removeStudent(did))
                        System.out.println("Student deleted.");
                    else
                        System.out.println("Student not found.");
                    break;

                case 5:
                    System.out.print("Enter ID to mark attendance: ");
                    int aid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Date (dd-mm-yyyy): ");
                    String date = sc.nextLine();
                    System.out.print("Is Present? (true/false): ");
                    boolean present = sc.nextBoolean();
                    manager.markAttendance(aid, date, present);
                    break;

                case 6:
                    System.out.print("Enter ID to view attendance: ");
                    int aid2 = sc.nextInt();
                    manager.showAttendance(aid2);
                    break;

                case 7:
                    System.out.print("Enter ID to add grade: ");
                    int gid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Subject: ");
                    String subject = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();
                    manager.addGrade(gid, subject, marks);
                    break;

                case 8:
                    System.out.print("Enter ID to view grades: ");
                    int gid2 = sc.nextInt();
                    manager.showGrades(gid2);
                    break;

                case 9:
                    System.out.println("Exiting system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (ch != 9);

        sc.close();
    }
}
