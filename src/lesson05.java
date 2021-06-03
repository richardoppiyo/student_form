import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lesson05 {
    private JPanel jStudents;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton saveButton;
    private JButton readButton;
    private JTextArea textArea1;

    lesson04 l04;

    public lesson05() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("I am clicked");

                String studentId = textField1.getText();
                String studentName = textField2.getText();
                String courseName = textField3.getText();
                String grades = textArea1.getText();

                l04 = new lesson04();
                l04.connect();
                l04.saveData(studentId, studentName, courseName, grades);
            }
        });
        readButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lesson06 l06 = new lesson06();
                l06.init(false);
            }
        });
    }

    public static void main(String[] args) {
        lesson05 l05 = new lesson05();
        l05.init();
    }

    public void init() {

        JFrame frame = new JFrame("lesson05");
        frame.setContentPane(new lesson05().jStudents);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
