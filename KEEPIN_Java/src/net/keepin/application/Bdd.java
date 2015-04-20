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
<<<<<<< HEAD
			String url = "jdbc:mysql://172.16.100.180/Demo";
			connDb = DriverManager.getConnection("jdbc:mysql://192.168.56.101/Keepin", "root", "toor");
			
=======

			String url = "jdbc:mysql://172.16.100.120/Keepin1";
			connDb = DriverManager.getConnection(url, "root", "toor");
>>>>>>> 1f4bee16f75cd0e9fab36ac98683afceb706c339

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
<<<<<<< HEAD
	
=======
>>>>>>> 1f4bee16f75cd0e9fab36ac98683afceb706c339

	public static int executeUpdate(String pSQLUpdate) {
		// A utiliser pour toutes les requêtes de type INSERT, DELETE et UPDATE
		Statement stmt = null;
		int retVal = 0;
		try {
			stmt = connDb.createStatement();
			retVal = stmt.executeUpdate(pSQLUpdate);
<<<<<<< HEAD

=======
>>>>>>> 1f4bee16f75cd0e9fab36ac98683afceb706c339
		} catch (SQLException e) {
			stmt = null;
		}

		return retVal;
<<<<<<< HEAD


	}

	
	
=======
	}


>>>>>>> 1f4bee16f75cd0e9fab36ac98683afceb706c339
	public static String hashMd5(String strToHash) {
		String retVal = new String ("");
		if(strToHash.equals("")){
			retVal = "";
		}else{
			String SQLQuery = "SELECT MD5('"+strToHash+"') as hash";
			ResultSet rs = executeQuery(SQLQuery);
			try {
				rs.next();
				retVal = rs.getString("hash");
				rs.close();
			} catch (Exception e) {
				retVal = "";
			}
		}
		return retVal;
	}

<<<<<<< HEAD

=======
>>>>>>> 1f4bee16f75cd0e9fab36ac98683afceb706c339
}
