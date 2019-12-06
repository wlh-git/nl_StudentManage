package mysql;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class mysql implements Serializable,conn {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Connection connection;
	private static Statement statement;
	
	public  mysql() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_nl_student","root","123456");
			statement = connection.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void insertData(String sql) {
		// TODO Auto-generated method stub
		try {
			statement.executeUpdate(sql);
			} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void delData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateData(String sql) {
		// TODO Auto-generated method stub
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet selectData(String sql) {
		// TODO Auto-generated method stub
		ResultSet res = null;
		try {
			ResultSet rs = statement.executeQuery(sql);
			res = rs;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		if(statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
