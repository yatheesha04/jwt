package com.javainuse.dao;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.javainuse.model.DAOUser;

@Service
public class UserDao {
	@Autowired
	private PasswordEncoder bcryptEncoder;
	//Create Employee Table in constructor.
    public UserDao() {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            try {
                Connection con = null;
                try {
                    con = DriverManager.getConnection("jdbc:hsqldb:file:database.dat;shutdown=true", "sa", "");
                    Statement stmt = con.createStatement();
                    stmt.executeUpdate(
                        "CREATE TABLE  final(id VARCHAR(20) , username VARCHAR(50), password VARCHAR(50) )");
                    System.out.println("Created table Employee");
                }
                finally {
                    if (con != null)
                        con.close();
                }
            }
            catch (SQLException e) {
                System.out.println(e);
                
            }

        }
        catch (ClassNotFoundException e) {
        	System.out.println("Exception Occured"+" "+e);
        }

    }

   

    public void addNewEmployee(DAOUser employee) {
        try {
            Connection con = null;
            PreparedStatement insertEmployee = null;
            try {
                con = DriverManager.getConnection("jdbc:hsqldb:file:database.dat;shutdown=true", "sa", "");
                insertEmployee =
                    con.prepareStatement("insert into final (id, username, password) values (?, ?, ?)");
                insertEmployee.setLong(1, employee.getId());
                insertEmployee.setString(2, employee.getUsername());
                insertEmployee.setString(3, bcryptEncoder.encode(employee.getPassword()));
                insertEmployee.executeUpdate();
                System.out.println("Created new Employee"+ "  " +"jijiji"+bcryptEncoder.encode(employee.getPassword()));
            }
            finally {
                if (con != null)
                    con.close();
            }
        }
        catch (SQLException e) {
            System.out.println("Exception Occured"+" "+e);
            
        }

    }

	public DAOUser getUser(String username) throws SQLException {
		 Connection con = null;
		con = DriverManager.getConnection("jdbc:hsqldb:file:database.dat;shutdown=true", "sa", "");
		String sql = "SELECT * FROM final";
		 
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery(sql);
		 
		int count = 0;
		 
		while (result.next()){
		    String name = result.getString(2);
		    String pass = result.getString(3);
		    if(name.compareTo(username)==0) {
		    	DAOUser d= new DAOUser(result.getLong(1), name, pass);
		    	System.out.println(d);
		    	return d;
		    }
		 
		    
		}
		return null;
		// TODO Auto-generated method stub
		
	}

 

}