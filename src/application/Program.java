package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = DB.getConnection();
			
			st = conn.createStatement();
			
			rs = st.executeQuery("SELECT p.productname, p.price, c.categoryname FROM products p INNER JOIN category c ON p.categoryid = c.categoryid WHERE p.categoryid = 2 ORDER BY price DESC");
			
			while (rs.next()) {
				System.out.println(rs.getString("productname") + ", " + rs.getFloat("price") + ", " + rs.getString("categoryname"));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}
		
		

	}

}
