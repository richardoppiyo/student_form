import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class lesson06 {
    private JTable table1;
    private JPanel pStudentList;
    private JScrollPane scrPane;

    public static void main(String[] args) {
        lesson06 l06 = new lesson06();
        l06.init(true);
    }

    public void init(boolean closeOnExit) {
        lesson04 l04 = new lesson04();
        l04.connect();

        Vector<String> studentTitles = new Vector<String>();
        studentTitles.add("Student ID");
        studentTitles.add("Student Name");
        studentTitles.add("Course Name");
        Vector<Vector<String>> vData = l04.readStudent();

        pStudentList = new JPanel(new BorderLayout());
        table1 = new JTable(vData, studentTitles);
        scrPane = new JScrollPane(table1);

        JLabel lb1Title = new JLabel("Student List");
        pStudentList.add(lb1Title, BorderLayout.PAGE_START);
        pStudentList.add(scrPane, BorderLayout.CENTER);

        JFrame frame = new JFrame("lesson06");
        frame.add(pStudentList, BorderLayout.CENTER);
        if(closeOnExit) frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setVisible(true);
    }
}
