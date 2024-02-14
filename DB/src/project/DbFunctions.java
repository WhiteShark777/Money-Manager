package project;

import java.sql.*;

public class DbFunctions {
    public Connection connect_to_db(String dbname,String user,String pass){
        Connection conn=null;
        try{
            Class.forName("org.postgresql.Driver");
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname,user,pass);
            if(conn!=null){
                System.out.println("Connection Established");
            }
            else{
                System.out.println("Connection Failed");
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return conn;
    }
    public void createTable(Connection conn,String table_name){
        Statement statement;
        try{
            String query = "create table " + table_name + "(id SERIAL,category varchar(200),spent INT,primary key(id))";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Created");

        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void  insert_row(Connection conn,String table_name,String category, int spent){
        Statement statement;
        try {
            String query = String.format("insert into %s(category,spent) values('%s','%d');",table_name,category,spent);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row Inserted");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void read_data(Connection conn,String table_name){
        Statement statement;
        ResultSet rs = null;

        try {
            String query = String.format("select * from %s",table_name);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()){
                System.out.print(rs.getString("id") + " ");
                System.out.print(rs.getString("category") + " ");
                System.out.println(rs.getString("spent") + " ");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void  update_spent(Connection conn,String table_name, String old_spent, String new_spent){
        Statement statement;
        try {
            String query  = String.format("update %s set spent = '%s' where spent = '%s'",table_name,new_spent,old_spent);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Updated");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void delete_row_by_category(Connection conn,String table_name,String category){
        Statement statement;
        try {
            String query = String.format("delete from %s where category = '%s'",table_name,category);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Deleted");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void delete_row_by_id(Connection conn,String table_name,int id){
        Statement statement;
        try {
            String query = String.format("delete from %s where id = '%d'",table_name,id);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Deleted");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void delete_table(Connection conn,String table_name){
        Statement statement;
        try {
            String query = String.format("drop table %s",table_name);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Deleted");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
