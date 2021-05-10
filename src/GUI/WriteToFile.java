package GUI;

import java.sql.*;
import java.io.*;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.bobaDAO;

public class WriteToFile {
	
	bobaDAO bobaDAO = new bobaDAO();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try
		    {
			 	System.out.println("Data Ready!");
		        Class.forName("com.mysql.jdbc.Driver");
		    }
		    catch(Exception e)
		    {
		        e.printStackTrace();
		    }
		    final String DB_URL ="jdbc:mysql://localhost:3306/bobacool?useLegacyDatetimeCode=false&serverTimezone=UTC";
		    Connection conn = null;
		    Statement stat  = null;
		    ResultSet rs = null;
		    try
		    {
		    	System.out.println("Data printed!");
		        conn = DriverManager.getConnection(DB_URL,"root","");
		        stat = conn.createStatement();
		        rs = stat.executeQuery("select * from boba");
		        FileWriter fw = new FileWriter("data.txt");
		        BufferedWriter bw = new BufferedWriter(fw);
		        String line ="";
		        while(rs.next())
		        {
		            line = rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4);
		            bw.write(line);
		            bw.newLine();
		        }
		        bw.close();
		        fw.close();
		    }
		    catch(Exception e)
		    {
		        e.printStackTrace();
		    }
		    finally
		    {
		        try
		        {
		            conn.close();
		            rs.close();
		            stat.close();
		        }
		        catch(Exception e)
		        {
		            e.printStackTrace();
		        }
		    }
		
	}

}
