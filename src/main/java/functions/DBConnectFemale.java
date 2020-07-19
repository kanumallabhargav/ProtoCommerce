package functions;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class DBConnectFemale 
{
	public ArrayList<String> DBConn(String Name, String Email, String Password) throws IOException, SQLException
{
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/Data.properties");
	Properties prop = new Properties();
	prop.load(fis);
	
	//get everything from .properties file
	String databaseName=prop.getProperty("dbname");
	String SQLQuery = prop.getProperty("SQLQuery2");
	String host = prop.getProperty("hostName");
	String portNumber = (String) prop.get("portNumber");
	String DBPassword = prop.getProperty("DBPassword");
	String DBID = prop.getProperty("DBID");
	String serverType = prop.getProperty("serverType");
	
	//connect to the Database
	Connection con = DriverManager.getConnection(serverType +host+":"+portNumber+"/"+databaseName, DBID, DBPassword);
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery(SQLQuery);
	
	//Retrieve the values
	rs.next();
	Name = rs.getString("Name");	
	Email = rs.getString("Email");
	Password = rs.getString("Password");
	
	//Put them into an arrayList
	//Because we have multiple strings to be returned
	ArrayList<String> values = new ArrayList<String>();
	values.add(Name);
	values.add(Email);
	values.add(Password);
	
	//return the arrayList
	return values;
}
}
