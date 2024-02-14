package project;

import java.sql.Connection;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        DbFunctions db = new DbFunctions();
        Connection conn = db.connect_to_db("finance", "postgres","12345");
        db.createTable(conn,"MoneySpent");
        //db.insert_row(conn,"MoneySpent","food",12500);
        //db.insert_row(conn,"MoneySpent","clothes",21000);
        //db.insert_row(conn,"MoneySpent","petrol",9000);
        //db.update_spent(conn,"MoneySpent","9000","11000");
        //db.delete_row_by_category(conn,"MoneySpent","clothes");
        //db.delete_row_by_id(conn,"MoneySpent",1);
        //db.read_data(conn,"MoneySpent");
        //db.delete_table(conn,"MoneySpent");


    }

}