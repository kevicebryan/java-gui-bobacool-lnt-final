package dao;

import java.sql.*;
import java.util.Vector;

import database.ConnectDatabase;

public class bobaDAO extends Thread {
	
	Connection connection;
	
	public bobaDAO() {
		try {
			initConnection();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	private void initConnection() throws  SQLException{
		connection = ConnectDatabase.connect();
		if(connection == null) {
			throw new SQLException("Connection");
		}
	}
	
	public Vector<Vector<String>> getCustomerData() {
		Vector<Vector<String>> data = new Vector<>();
		try {
			Statement stmt = connection.createStatement();
			String sql = "select * from boba";	
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Vector<String> rows = new Vector<>();
				rows.add(rs.getString(1));
				rows.add(rs.getString(2));
				rows.add(rs.getString(3));
				rows.add(rs.getString(4));
				data.add(rows);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public void	insertData(String id, String nama, String harga, String stok) {
		try {
			Statement stmt = connection.createStatement();
			String sql = "Insert into boba values('"+id+"', '"+nama+"', '"+harga+"', '"+stok+"')";
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
//	private String generateNewID() {
//		String id = "";
//		String newId ="";
//		try {
//			Statement stmt = connection.createStatement();
//			String sql = "SELECT id from boba ORDER BY id DESC LIMIT 1";
//			ResultSet rs = stmt.executeQuery(sql);
//			while(rs.next()) {
//				id = rs.getString(1);
//			}
//			int latestId = Integer.parseInt(id.replaceAll("[^0-9]",""));
//			newId = "BO" + String.format("%03d",latestId + 1);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return newId;
//	}
	
	public void updateData(String id, String nama, String harga, String stok) {
		try {
			Statement stmt = connection.createStatement();
			String sql = "UPDATE boba SET id='"+ id + "', nama='"+ nama +"', harga='"+ harga+
					"', stok='"+ stok;
			System.out.println(sql);
			stmt.executeUpdate(sql);
		}catch(SQLException e ) {
			e.printStackTrace();
		}
	}
	
	public void deleteData(String id) {
		try {
			Statement stmt = connection.createStatement();
			String sql = "DELETE FROM boba where id='"+id+"'";
			System.out.println(sql);
			stmt.executeUpdate(sql);
		}catch(SQLException e ) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		System.out.println("Thread is Running");
	}
}
