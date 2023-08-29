import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Student {
    private String name;
    private int roll;
    private String grade;

    public Student(String name, int roll, String grade) {
        this.name = name;
        this.roll = roll;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRoll() {
        return roll;
    }

    public String getGrade() {
        return grade;
    }

    public String toString() {
        return "Name: " + name + ", Roll: " + roll + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student searchStudent(int roll) {
        for (Student student : students) {
            if (student.getRoll() == roll) {
                return student;
            }
        }
        return null;
    }

    public void removeStudent(int roll) {
        students.removeIf(student -> student.getRoll() == roll);
    }

    public ArrayList<Student> getAllStudents() {
        return students;
    }
}

public class StudentManagementApp {
    private static StudentManagementSystem system = new StudentManagementSystem();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JButton addStudentButton = new JButton("Add New Student");
        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        JButton editStudentButton = new JButton("Edit Student Details");
        editStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editStudent();
            }
        });

        JButton searchStudentButton = new JButton("Search Enrolled Student");
        searchStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchStudent();
            }
        });

        JButton displayStudentsButton = new JButton("Display Student Details");
        displayStudentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayStudents();
            }
        });

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panel.add(addStudentButton);
        panel.add(editStudentButton);
        panel.add(searchStudentButton);
        panel.add(displayStudentsButton);
        panel.add(exitButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private static void addStudent() {
        String name = JOptionPane.showInputDialog("Enter student name:");
        int roll = Integer.parseInt(JOptionPane.showInputDialog("Enter roll number:"));
        String grade = JOptionPane.showInputDialog("Enter grade:");

        Student student = new Student(name, roll, grade);
        system.addStudent(student);
        JOptionPane.showMessageDialog(null, "Student added successfully!");
    }

    private static void editStudent() {
        int roll = Integer.parseInt(JOptionPane.showInputDialog("Enter roll number of the student to edit:"));
        Student student = system.searchStudent(roll);

        if (student != null) {
            String newName = JOptionPane.showInputDialog("Enter new name (current: " + student.getName() + "):");
            String newGrade = JOptionPane.showInputDialog("Enter new grade (current: " + student.getGrade() + "):");

            student = new Student(newName, roll, newGrade);
            system.removeStudent(roll);
            system.addStudent(student);
            JOptionPane.showMessageDialog(null, "Student information updated successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Student not found.");
        }
    }

    private static void searchStudent() {
        int roll = Integer.parseInt(JOptionPane.showInputDialog("Enter roll number of the student to search:"));
        Student student = system.searchStudent(roll);

        if (student != null) {
            JOptionPane.showMessageDialog(null, student.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Student not found.");
        }
    }

    private static void displayStudents() {
        StringBuilder sb = new StringBuilder();
        for (Student student : system.getAllStudents()) {
            sb.append(student.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}

