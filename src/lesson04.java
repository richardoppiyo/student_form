import java.sql.*;
import java.util.Vector;

public class lesson04 {

    Connection conn = null;

    public void connect() {
        String url = "jdbc:postgresql://localhost/school";
        String user = "postgres";
        String password = "baraza";

        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveData(String studentId, String studentName, String courseName, String grades) {
        String strSql = "INSERT INTO students (student_id, student_name, course_name, grades) "
                + " VALUES ('" + studentId
                + "', '" +  studentName
                + "', '" + courseName
                + "', '" + grades + "');";
        System.out.println(strSql);

        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(strSql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Vector readStudent() {
        Vector<Vector<String>> vData = new Vector<Vector<String>>();
        try  {
            String sqlStr = "SELECT student_id, student_name, course_name "
                    + "FROM students ORDER BY student_id";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlStr);
            while (rs.next()) {
                Vector<String> vRow = new Vector<String>();
                vRow.add(rs.getString("student_id"));
                vRow.add(rs.getString("student_name"));
                vRow.add(rs.getString("course_name"));

                System.out.println(rs.getString("student_id"));

                vData.add(vRow);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return vData;
    }

    public void close() {
        try {
            if(conn != null) conn.close();
            System.out.println("Closed the PostgreSQL server connection.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saySomething() {
        System.out.println("Something ...");
    }

}
