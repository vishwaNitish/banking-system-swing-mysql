package src;

import java.sql.*;

/*for JDBC connectivity there are 5 steps that are
   (1.Register the Driver
   (2.Create Connection
   (3.create Statement
   (4.Execute Query
   (5.Close Connection*/
public class Conn {
  Connection c;
  Statement s;

  public Conn() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Shilpa@8187");
      s = c.createStatement();

    } catch (Exception e) {
      System.out.println(e);
    }
  }

}