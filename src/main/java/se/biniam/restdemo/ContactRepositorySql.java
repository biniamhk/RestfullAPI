package se.biniam.restdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContactRepositorySql  {
	Connection con=null;
	
	
	public ContactRepositorySql()  {
		
	String url="jdbc:sqlserver://localhost:1433;Databasename=everyloop";
	String username="biniam";
	String password="Biniam2011";
	
	try {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		con=DriverManager.getConnection(url,username,password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
public List<Contact> getContact(){
	List<Contact> contacts=new ArrayList<>();
	
	String sql="select * from ContactSql";
	try {
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()) {
			
			Contact contact=new Contact();
			contact.setId(rs.getInt(1));
			contact.setName(rs.getString(2));
			contact.setPoint(rs.getInt(3));
			
			contacts.add(contact);
					}
	} catch (SQLException e) {
		System.out.println(e);
	}
		
		return contacts;	
}

public Contact getContact(int id) {

Contact contact=new Contact();

	String sql="select * from ContactSql where id="+id;
	try {
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		if(rs.next()) {
		
			contact.setId(rs.getInt(1));
			contact.setName(rs.getString(2));
			contact.setPoint(rs.getInt(3));
					}
	} catch (SQLException e) {
		System.out.println(e);
	}
				return contact;
	}

public void create(Contact c) {
	
	String sql="insert into ContactSql values(?,?,?)";
	try {
		PreparedStatement pst=con.prepareStatement(sql);
	pst.executeUpdate(sql);
		pst.setInt(1,c.getId());
		pst.setString(2,c.getName());
		pst.setInt(3, c.getPoint());
		
	} 
	catch (SQLException e) {
		System.out.println(e);
	}
	
	
}

public void update(Contact c) {
	
	String sql="update  ContactSql set name=?,point=? where id=?";

		
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			
			pst.setInt(1,c.getId());
			pst.setString(2,c.getName());
			pst.setInt(3, c.getPoint());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}

	

}

