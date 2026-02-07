import javax.swing.*;
import java.awt.*;
import java.awt.ActiveEvent.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener.*;

public class StudentCalc extends JFrame implements ActionListener {
    JLabel studentName, yearLevel, optionalActs;
    JTextField name;
    ButtonGroup rbs = new ButtonGroup();
    JRadioButton year1, year2, year3, year4;
    JCheckBox sportsClub, musicClub, artsClub;
    JButton calculate, close;

    public StudentCalc() {
        setLayout(new GridLayout(13, 1));;
        setSize(545, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Student Activity Fee Calculator");
        setLocationRelativeTo(null);
        // Student Name
        studentName = new JLabel();
        studentName.setText("Student Name:");
        name = new JTextField(10);

        // Year Level
        yearLevel = new JLabel();
        yearLevel.setText("Year Level:");
        year1 = new JRadioButton("1st year (₱500)");
        year2 = new JRadioButton("2nd year (₱600)");
        year3 = new JRadioButton("3rd year (₱700)");
        year4 = new JRadioButton("4th year (₱800)");

        rbs.add(year1);
        rbs.add(year2);
        rbs.add(year3);
        rbs.add(year4);

        // Optional Activities 
        optionalActs = new JLabel("Optional Activities: ");
        sportsClub = new JCheckBox("Sports Club (₱150)");
        musicClub = new JCheckBox("Music Club (₱200)");
        artsClub = new JCheckBox("Arts Club (₱180)");

        // buttons
        calculate = new JButton("Calculate Fee");
        calculate.addActionListener(this);

        close = new JButton("Close");
        close.addActionListener(this);

        add(studentName);
        add(name);
        add(yearLevel);
        add(year1);
        add(year2);
        add(year3);
        add(year4);
        add(optionalActs);
        add(sportsClub);
        add(musicClub);
        add(artsClub);
        add(calculate);
        add(close);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculate) {
            String student = name.getText().trim();
            String yearLevel;
            StringBuilder activities = new StringBuilder();
            double totalFee;

            if (student.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Student name is required.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (year1.isSelected()) {
                    yearLevel = "1st Year";
                    totalFee = 500;
                } else if (year2.isSelected()) {
                    yearLevel = "2nd Year";
                    totalFee = 600;
                } else if (year3.isSelected()) {
                    yearLevel = "3rd Year";
                    totalFee = 700;
                } else {
                    yearLevel = "4th Year";
                    totalFee = 800;
                }

                if (!sportsClub.isSelected() && !musicClub.isSelected() && !artsClub.isSelected()) {
                    activities.append("none");
                } else {
                    if (sportsClub.isSelected()) {
                        activities.append(" Sports Club");
                        totalFee += 150;
                    } if (musicClub.isSelected()) {
                        if (!activities.isEmpty()) activities.append(",");
                        activities.append(" Music Club");
                        totalFee += 200;
                    } if (artsClub.isSelected()){
                        if (!activities.isEmpty()) activities.append(",");
                        activities.append(" Arts Club");
                        totalFee += 180;
                    }
                }
                String summation = "Student Name: "+student+
                                "\nYear Level: "+yearLevel+
                                "\nActivities:"+activities+
                                "\nTotal Fee: "+totalFee;
                JOptionPane.showMessageDialog(this, summation, "Fee Details", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == close) {
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        new StudentCalc();
    }
}