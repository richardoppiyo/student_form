import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class lesson07 {
    private JTable table1;
    private JPanel pStudentList;
    private JScrollPane scrPane;


    public static void main(String[] args) {
        lesson07 l07 = new lesson07();
        l07.init();
    }

    public void init() {
        lesson04 l04 = new lesson04();
        l04.connect();

        Vector<String> studentTitles = new Vector<String>();
        studentTitles.add("Student ID");
        studentTitles.add("Student Name");
        studentTitles.add("Course Name");
        Vector<Vector<String>> vData = l04.readStudent();

        table1 = new JTable(vData, studentTitles);
        scrPane.setViewportView(table1);

        JFrame frame = new JFrame("lesson07");
        frame.setContentPane(new lesson07().pStudentList);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setVisible(true);
    }
}
