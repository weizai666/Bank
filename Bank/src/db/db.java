package db;
import java.sql.*;
public class db {
private Connection dbConn;
private Statement stateMent;
public db()
{
	String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=pay";
	String userName="sa";
	String userPwd="sa";
	try
	{
		Class.forName(driverName);
		dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
		System.out.println("Connection Successful!");
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage()+"failed");
	}
}
public int excuteUpdate(String sql) throws SQLException
{
	stateMent=(dbConn.createStatement());
	return stateMent.executeUpdate(sql);
}
public ResultSet excuteQuery(String sql) throws SQLException
{
	stateMent=dbConn.createStatement();
	return stateMent.executeQuery(sql);
}
public void closeConn() throws SQLException
{
	stateMent.close();
	dbConn.close();
}
public PreparedStatement PreparedStatement(String sql) throws SQLException
{
	return dbConn.prepareStatement(sql);
}
}
