package pcHome;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import functions.Base;
import functions.DBConnect;

public class test extends Base
{
	private static final String Name = null;
	private static final String Email = null;
	private static final String Password = null;
	private static final String Gender = null;
	private static final String DoB = null;

	public static void main(String[] args) throws IOException, SQLException
	{
		DBConnect conObj = new DBConnect();
		ArrayList<String> arr = conObj.DBConn(Name, Email, Password, Gender, DoB);
		String name = arr.get(0);
		String email = arr.get(1);
		String password = arr.get(2);
		System.out.println(name+email+password);
	}
}
