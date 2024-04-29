package StudentGradeCalculatorconsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Jframestudentgradecalc extends JFrame {

    private JLabel nameLabel, regNoLabel, titleLabel;
    private JTextField nameField, regNoField;
    private JLabel[] subjectLabels;
    private JTextField[] marksFields;
    private JButton calculateButton;
    private JTextArea resultArea;

    public Jframestudentgradecalc() {
        setTitle("Student Grade Calculator");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Title label
        titleLabel = new JLabel("Student Grade Calculator");
        titleLabel.setBounds(150, 10, 300, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.BLUE);
        add(titleLabel);

        nameLabel = new JLabel("Student Name:");
        nameLabel.setBounds(50, 60, 150, 20);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(200, 60, 200, 25);
        add(nameField);

        regNoLabel = new JLabel("Register No:");
        regNoLabel.setBounds(50, 100, 150, 20);
        add(regNoLabel);

        regNoField = new JTextField();
        regNoField.setBounds(200, 100, 100, 25);
        add(regNoField);

        String[] subjects = {"English", "Maths", "Physics", "Chemistry", "Biology", "Computer Science"};
        subjectLabels = new JLabel[subjects.length];
        marksFields = new JTextField[subjects.length];

        int y = 150;
        for (int i = 0; i < subjects.length; i++) {
            subjectLabels[i] = new JLabel(subjects[i] + ":");
            subjectLabels[i].setBounds(50, y, 150, 20);
            add(subjectLabels[i]);

            marksFields[i] = new JTextField();
            marksFields[i].setBounds(200, y, 50, 25);
            add(marksFields[i]);

            y += 35;
        }

        calculateButton = new JButton("Calculate Grade");
        calculateButton.setBounds(200, y + 20, 150, 30);
        calculateButton.setBackground(Color.GREEN);
        calculateButton.setForeground(Color.WHITE);
        add(calculateButton);

        resultArea = new JTextArea();
        resultArea.setBounds(50, y + 70, 400, 200);
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Arial", Font.PLAIN, 14));
        add(resultArea);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateGrade();
            }
        });
    }

    private void calculateGrade() {
        String studName = nameField.getText();
        String studRegno = regNoField.getText();
        int[] marks = new int[subjectLabels.length];

        for (int i = 0; i < subjectLabels.length; i++) {
            try {
                marks[i] = Integer.parseInt(marksFields[i].getText());
                if (marks[i] < 0 || marks[i] > 100) {
                    JOptionPane.showMessageDialog(this, "The marks for " + subjectLabels[i].getText() + " are not in range.");
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid input for marks in " + subjectLabels[i].getText());
                return;
            }
        }

        int studentTotal = calculateStudentTotal(marks);
        double studentAverage = calculateStudentAverage(studentTotal, subjectLabels.length);
        char studentGrade = calculateStudentGrade(studentAverage);

        String result = "";
        if (studentGrade == 'F') {
            result = "Sorry, " + studName + " you have Failed\n";
        } else {
            result = "Congratulations, " + studName + " you have passed with Grade " + studentGrade + "\n";
        }
        result += "Subject\tMarks\n";
        for (int i = 0; i < subjectLabels.length; i++) {
            result += subjectLabels[i].getText().split(":")[0] + "\t" + marks[i] + "\n";
        }
        result += "Total Marks: " + studentTotal + "\n";
        result += "Average Marks: " + studentAverage + "%\n";
        resultArea.setText(result);
    }

    private int calculateStudentTotal(int[] marks) {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return sum;
    }

    private double calculateStudentAverage(int total, int length) {
        return (double) total / length;
    }

    private char calculateStudentGrade(double average) {
        if (average >= 95) {
            return 'O';
        } else if (average >= 90) {
            return 'A';
        } else if (average >= 80) {
            return 'B';
        } else if (average >= 70) {
            return 'C';
        } else if (average >= 60) {
            return 'D';
        } else if (average >= 50) {
            return 'E';
        } else {
            return 'F';
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Jframestudentgradecalc().setVisible(true);
            }
        });
    }
}

