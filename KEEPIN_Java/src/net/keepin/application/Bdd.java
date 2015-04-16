package net.keepin.application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Bdd {
	private static Connection connDb;
	public static void openConnexion(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://172.16.100.180/Demo";
			connDb = DriverManager.getConnection("jdbc:mysql://192.168.56.101/Keepin", "root", "toor");
			if (connDb != null){
				System.out.println("DataBase connectée");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		}

	}

	public static void closeConnexion(){
		try {
			connDb.close();
			System.out.println("DataBase déconnectée");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ResultSet executeQuery(String pSqlQuery){
		Statement stmt = null;
		ResultSet retVal = null;
		try {
			stmt = connDb.createStatement();
			retVal = stmt.executeQuery(pSqlQuery);
		} catch (SQLException e) {
			stmt = null;
		}

		return retVal;
	}
	
	public static int executeUpdate(String psqlQuery2){
		Statement stmt = null;
		int retVal = 0 ;
		try {
			stmt = connDb.createStatement();
			retVal = stmt.executeUpdate(psqlQuery2);
		} catch (SQLException e) {
			stmt = null;
		}

		return retVal;

	}

}
