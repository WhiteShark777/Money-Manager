package project;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DbFunctions db = new DbFunctions();
        Connection conn = db.connect_to_db("finance", "postgres","12345");


        Scanner scanner = new Scanner(System.in);
        db = new DbFunctions();
        conn = db.connect_to_db("finance", "postgres", "12345");

        if (conn != null) {
            System.out.println("Connection Established");

            while (true) {
                System.out.println("Enter command: (create, insert, read, update, delete, exit)");
                String command = scanner.nextLine();

                if (command.equals("create")) {
                    System.out.println("Enter table name:");
                    String tableName = scanner.nextLine();
                    db.createTable(conn, tableName);
                } else if (command.equals("insert")) {
                    System.out.println("Enter table name:");
                    String tableName = scanner.nextLine();
                    System.out.println("Enter category:");
                    String category = scanner.nextLine();
                    System.out.println("Enter spent:");
                    int spent = Integer.parseInt(scanner.nextLine());
                    db.insert_row(conn, tableName, category, spent);
                } else if (command.equals("read")) {
                    System.out.println("Enter table name:");
                    String tableName = scanner.nextLine();
                    db.read_data(conn, tableName);
                } else if (command.equals("update")) {
                    System.out.println("Enter table name:");
                    String tableName = scanner.nextLine();
                    System.out.println("Enter old spent:");
                    String oldSpent = scanner.nextLine();
                    System.out.println("Enter new spent:");
                    String newSpent = scanner.nextLine();
                    db.update_spent(conn, tableName, oldSpent, newSpent);
                } else if (command.equals("delete")) {
                    System.out.println("Enter table name:");
                    String tableName = scanner.nextLine();
                    System.out.println("Delete by category or id? (category/id)");
                    String deleteBy = scanner.nextLine();
                    if (deleteBy.equals("category")) {
                        System.out.println("Enter category:");
                        String category = scanner.nextLine();
                        db.delete_row_by_category(conn, tableName, category);
                    } else if (deleteBy.equals("id")) {
                        System.out.println("Enter id:");
                        int id = Integer.parseInt(scanner.nextLine());
                        db.delete_row_by_id(conn, tableName, id);
                    }
                } else if (command.equals("exit")) {
                    break;
                } else {
                    System.out.println("Invalid command.");
                }
            }

            scanner.close();
        } else {
            System.out.println("Connection Failed");
        }
    }
}
