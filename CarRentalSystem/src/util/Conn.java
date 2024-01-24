package util;

import java.sql.*;

public class Conn
{
Connection c;
public Statement s;
    public Conn()
      {
    	try
    	{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		c=DriverManager.getConnection("jdbc:mysql:///carrentalsystem","root","2179@Manoj");
    		s=c.createStatement();
    		System.out.println("connected");
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		System.out.println("Unable to connect database");
    	}
	
      }

	}

