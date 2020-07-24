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

public class DBConnect 
{
	public ArrayList<String> DBConn(String Name, String Email, String Password, String Gender, String DoB) throws IOException, SQLException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/Data.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		//get everything from .properties file
		String databaseName = prop.getProperty("dbname");
		String genderType = prop.getProperty("gender");
		String SQLQuery_male = prop.getProperty("SQLQuery1");
		String SQLQuery_female = prop.getProperty("SQLQuery2");
		String host = prop.getProperty("hostName");
		String portNumber = (String) prop.get("portNumber");
		String DBPassword = prop.getProperty("DBPassword");
		String DBID = prop.getProperty("DBID");
		String serverType = prop.getProperty("serverType");
		
		//connect to the Database
		Connection con = DriverManager.getConnection(serverType +host+":"+portNumber+"/"+databaseName, DBID, DBPassword);
		Statement st = con.createStatement();
		if(genderType.equalsIgnoreCase("male"))
		{
		ResultSet rs = st.executeQuery(SQLQuery_male);
		
		//Retrieve the values
		rs.next();
		Name = rs.getString("Name");	
		Email = rs.getString("Email");
		Password = rs.getString("Password");
		Gender = rs.getString("Gender");
		DoB = rs.getString("DoB");
		}
		if(genderType.equalsIgnoreCase("female"))
		{
			ResultSet rs = st.executeQuery(SQLQuery_female);
			
			//Retrieve the values
			rs.next();
			Name = rs.getString("Name");	
			Email = rs.getString("Email");
			Password = rs.getString("Password");
			Gender = rs.getString("Gender");
			DoB = rs.getString("DoB");
		}
		//Put them into an arrayList
		//Because we have multiple strings to be returned
		ArrayList<String> values = new ArrayList<String>();
		values.add(Name);
		values.add(Email);
		values.add(Password);
		values.add(Gender);
		values.add(DoB);
		
		//return the arrayList
		return values;
	}
}
