import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "0000";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/zoo_management_system";

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

        while (true) {
            System.out.println("\n--- Zoo Management System ---");
            System.out.println("1. Show all animals");
            System.out.println("2. Update animal's age");
            System.out.println("3. Add a new animal");
            System.out.println("4. Delete an animal");
            System.out.println("5. Show all zookeepers");
            System.out.println("6. Add a new zookeeper");
            System.out.println("7. Show all zoos");
            System.out.println("8. Add a new zoo");
            System.out.println("9. Exit");
            int command = scanner.nextInt();

            if (command == 1) {
                Statement statement = connection.createStatement();
                String SQL_SELECT = "SELECT * FROM Animal";
                ResultSet rs = statement.executeQuery(SQL_SELECT);

                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("animal_id") + " Name: " + rs.getString("name") + " Species: " + rs.getString("species") + " Age: " + rs.getInt("age"));
                }
            }
            else if (command == 2) {
                System.out.print("Enter animal ID to update age: ");
                int id = scanner.nextInt();
                System.out.print("Enter new age: ");
                int newAge = scanner.nextInt();

                String SQL_UPDATE = "UPDATE Animal SET age = ? WHERE animal_id = ?";
                PreparedStatement pstmt = connection.prepareStatement(SQL_UPDATE);
                pstmt.setInt(1, newAge);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();
                System.out.println("Animal's age updated successfully!");
            }
            else if (command == 3) {
                System.out.print("Enter animal name: ");
                String name = scanner.next();
                System.out.print("Enter animal species: ");
                String species = scanner.next();
                System.out.print("Enter animal age: ");
                int age = scanner.nextInt();

                String SQL_INSERT = "INSERT INTO Animal(name, species, age) VALUES (?, ?, ?)";
                PreparedStatement pstmt = connection.prepareStatement(SQL_INSERT);
                pstmt.setString(1, name);
                pstmt.setString(2, species);
                pstmt.setInt(3, age);
                pstmt.executeUpdate();
                System.out.println("Animal added successfully!");
            }
            else if (command == 4) {
                System.out.print("Enter animal ID to delete: ");
                int id = scanner.nextInt();

                String SQL_DELETE = "DELETE FROM Animal WHERE animal_id = ?";
                PreparedStatement pstmt = connection.prepareStatement(SQL_DELETE);
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
                System.out.println("Animal deleted successfully!");
            }
            else if (command == 5) {
                Statement statement = connection.createStatement();
                String SQL_SELECT = "SELECT * FROM Zookeeper";
                ResultSet rs = statement.executeQuery(SQL_SELECT);

                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("zookeeper_id") + " Name: " + rs.getString("name") + " Experience Years: " + rs.getInt("experience_years"));
                }
            }
            else if (command == 6) {
                System.out.print("Enter zookeeper name: ");
                String name = scanner.next();
                System.out.print("Enter zookeeper experience years: ");
                int experienceYears = scanner.nextInt();

                String SQL_INSERT = "INSERT INTO Zookeeper(name, experience_years) VALUES (?, ?)";
                PreparedStatement pstmt = connection.prepareStatement(SQL_INSERT);
                pstmt.setString(1, name);
                pstmt.setInt(2, experienceYears);
                pstmt.executeUpdate();
                System.out.println("Zookeeper added successfully!");
            }
            else if (command == 7) {
                Statement statement = connection.createStatement();
                String SQL_SELECT = "SELECT * FROM Zoo";
                ResultSet rs = statement.executeQuery(SQL_SELECT);

                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("zoo_id") + " Name: " + rs.getString("name") + " Location: " + rs.getString("location"));
                }
            }
            else if (command == 8) {
                System.out.print("Enter zoo name: ");
                String name = scanner.next();
                System.out.print("Enter zoo location: ");
                String location = scanner.next();

                String SQL_INSERT = "INSERT INTO Zoo(name, location) VALUES (?, ?)";
                PreparedStatement pstmt = connection.prepareStatement(SQL_INSERT);
                pstmt.setString(1, name);
                pstmt.setString(2, location);
                pstmt.executeUpdate();
                System.out.println("Zoo added successfully!");
            }
            else if (command == 9) {
                connection.close();
                System.out.println("Exiting...");
                break;
            }
        }
    }
}
