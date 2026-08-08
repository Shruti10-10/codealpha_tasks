import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Student {
    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentGradeTrackerGUI extends JFrame implements ActionListener {

    JTextField nameField, gradeField;
    JTextArea outputArea;
    JButton addButton, reportButton;

    ArrayList<Student> students = new ArrayList<>();

    StudentGradeTrackerGUI() {

        setTitle("Student Grade Tracker");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Student Name:"));
        nameField = new JTextField(15);
        add(nameField);

        add(new JLabel("Grade:"));
        gradeField = new JTextField(10);
        add(gradeField);

        addButton = new JButton("Add Student");
        reportButton = new JButton("Show Report");

        add(addButton);
        add(reportButton);

        outputArea = new JTextArea(18, 40);
        outputArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(outputArea);
        add(scrollPane);

        addButton.addActionListener(this);
        reportButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addButton) {

            String name = nameField.getText();

            if (name.isEmpty() || gradeField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please enter all fields.");
                return;
            }

            try {
                double grade = Double.parseDouble(gradeField.getText());

                students.add(new Student(name, grade));

                JOptionPane.showMessageDialog(this,
                        "Student Added Successfully!");

                nameField.setText("");
                gradeField.setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Enter a valid numeric grade.");
            }
        }

        if (e.getSource() == reportButton) {

            if (students.size() == 0) {
                outputArea.setText("No student data available.");
                return;
            }

            double total = 0;
            double highest = students.get(0).grade;
            double lowest = students.get(0).grade;

            String highestStudent = students.get(0).name;
            String lowestStudent = students.get(0).name;

            StringBuilder report = new StringBuilder();

            report.append("===== STUDENT SUMMARY REPORT =====\n\n");

            for (Student s : students) {

                report.append("Name: ")
                      .append(s.name)
                      .append("   Grade: ")
                      .append(s.grade)
                      .append("\n");

                total += s.grade;

                if (s.grade > highest) {
                    highest = s.grade;
                    highestStudent = s.name;
                }

                if (s.grade < lowest) {
                    lowest = s.grade;
                    lowestStudent = s.name;
                }
            }

            double average = total / students.size();

            report.append("\n---------------------------------\n");

            report.append("Average Grade : ")
                  .append(String.format("%.2f", average))
                  .append("\n");

            report.append("Highest Grade : ")
                  .append(highest)
                  .append(" (")
                  .append(highestStudent)
                  .append(")\n");

            report.append("Lowest Grade : ")
                  .append(lowest)
                  .append(" (")
                  .append(lowestStudent)
                  .append(")\n");

            outputArea.setText(report.toString());
        }
    }

    public static void main(String[] args) {
        new StudentGradeTrackerGUI();
    }
}
