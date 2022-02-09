
package hotel.management.system;

import java.sql.*;

public class conn {
    
    Connection c;
    Statement s;
    
    public conn()
    {
    try
    {
    Class.forName("com.mysql.jdbc.Driver");
    c = DriverManager.getConnection("jdbc:mysql:///hms","root","Mansi@2000");
    s = c.createStatement();
    
    }
    catch(Exception e)
    {
    System.out.println(e);
    }
    
    
    }
    
}
