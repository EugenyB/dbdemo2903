package main;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
	    new Main().run2();
    }

    private void run() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbdemo2903", "eugeny", "123");
            PreparedStatement ps = conn.prepareStatement("insert into student (fio, rating) values (?, ?)");
            ps.setString(1, "Alekseev");
            ps.setInt(2, 50);
            ps.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void run2() {
        try {
            // 2
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbdemo2903", "eugeny", "123");
            // 3 a
            Statement statement = conn.createStatement();
            // 3 b
            ResultSet resultSet = statement.executeQuery("select * from student");
            // 4
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String fio = resultSet.getString("fio");
                int rating = resultSet.getInt("rating");
                System.out.println(id + " " + fio + " " + rating);
            }
            // 5
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
