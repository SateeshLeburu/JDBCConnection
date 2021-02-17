package com.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.JSONObject;

public class MYSQLconnectionTest {


	static String[] names = { "Sateesh", "Rohit", "Sandeep" };
	static String dbname;
	static ArrayList<Object> dbnamelist = new ArrayList<Object>();
	static ArrayList<Object> dbnamelistsal = new ArrayList<Object>();
	static int i, j, dbsal;

	public static void main(String args[]) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demodb", "UserName", "Passcode");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select Emp_Name, Salary from employee");

			while (rs.next()) {
				dbname = rs.getString("Emp_Name");
				dbsal = rs.getInt("Salary");
				dbnamelist.add(dbname);
				dbnamelistsal.add(dbsal);
			}
			for (i = 0, j = 0; i < dbnamelist.size() && j < names.length; i++, j++) {
				System.out.println(dbnamelist.get(i) + " as " + names[j]);
			}

			JSONObject j = new JSONObject();			
				j.put("Name", dbnamelist);
				
			JSONObject js = new JSONObject();
				js.put("Salary", dbnamelistsal);

				System.out.println(j);
				System.out.println(js);
			

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
