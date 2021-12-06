import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JComboBox;



public class DBHelp {

	public static Connection conn= null;
	public static MyModel model = null;
	public static PreparedStatement statement = null;
	public static ResultSet resultSet = null;
	
	static void fillComboSerachRegions(JComboBox<String> combo) {
		conn = getConnection();
		String sql="SELECT REGION_ID,REGION_NAME FROM REGIONS";
		try {
			statement = conn.prepareStatement(sql);
			resultSet = statement.executeQuery();
			combo.removeAllItems();
			while(resultSet.next()) {
				String item = resultSet.getObject(1).toString()+" "+resultSet.getObject(2).toString();
				combo.addItem(item);
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void fillComboSerachReservoirs(JComboBox<String> combo) {
		conn = getConnection();
		String sql="SELECT RESERVOIR_ID,RESERVOIR_NAME FROM RESERVOIRS";
		try {
			statement = conn.prepareStatement(sql);
			resultSet = statement.executeQuery();
			combo.removeAllItems();
			while(resultSet.next()) {
				String item = resultSet.getObject(1).toString()+" "+resultSet.getObject(2).toString();
				combo.addItem(item);
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void fillComboSerachResponsiblePerson(JComboBox<String> combo) {
		conn = getConnection();
		String sql="SELECT RESPONSIBLE_PERSON_ID,RESPONSIBLE_PERSON_FNAME FROM RESPONSIBLE_PERSONS";
		try {
			statement = conn.prepareStatement(sql);
			resultSet = statement.executeQuery();
			combo.removeAllItems();
			while(resultSet.next()) {
				String item = resultSet.getObject(1).toString()+" "+resultSet.getObject(2).toString();
				combo.addItem(item);
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void fillComboRegions(JComboBox<String> combo) {
		conn = getConnection();
		String sql="SELECT REGION_NAME FROM REGIONS";
		try {
			statement = conn.prepareStatement(sql);
			resultSet = statement.executeQuery();
			combo.removeAllItems();
			while(resultSet.next()) {
				String item = resultSet.getObject(1).toString();
				combo.addItem(item);
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void fillComboResponsiblePersons(JComboBox<String> combo) {
		conn = getConnection();
		String sql="SELECT RESPONSIBLE_PERSON_FNAME,RESPONSIBLE_PERSON_LNAME FROM RESPONSIBLE_PERSONS";
		try {
			statement = conn.prepareStatement(sql);
			resultSet = statement.executeQuery();
			combo.removeAllItems();
			while(resultSet.next()) {
				String item = resultSet.getObject(1).toString()+" "+resultSet.getObject(2).toString();
				combo.addItem(item);
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	static void fillComboResponsiblePersonsReservoirs(JComboBox<String> combo) {
		conn = getConnection();
		String sql="SELECT R.RESERVOIR_ID, R.RESERVOIR_NAME, R.RESERVOIR_AREA, R.RESERVOIR_DEPTH, P.REGION_NAME, O.RESPONSIBLE_PERSON_FNAME\\r\\n\"\r\n"
				+ "				+ \"FROM RESERVOIRS R JOIN REGIONS P ON R.RESERVOIR_ID=P.REGION_ID\\r\\n\"\r\n"
				+ "				+ \"		  JOIN RESPONSIBLE_PERSONS O ON R.RESPONSIBLE_PERSON_ID=O.RESPONSIBLE_PERSON_ID";
		try {
			statement = conn.prepareStatement(sql);
			resultSet = statement.executeQuery();
			combo.removeAllItems();
			while(resultSet.next()) {
				String item = resultSet.getObject(1).toString()+" "+resultSet.getObject(2).toString();
				combo.addItem(item);
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static Connection getConnection() {
		String connection="",user="",pass="";
		try {
			Class.forName("org.h2.Driver");
			java.io.File file = new java.io.File("C:\\Users\\User\\eclipse-workspace\\RegisterOfReservoirs_1901321068\\ConfigurationFile\\configure.txt");
			java.util.Scanner scanner = new Scanner(file);
			
			while(scanner.hasNextLine()) {
				connection=scanner.nextLine().trim();
				user=scanner.nextLine().trim();
				pass=scanner.nextLine().trim();
			}
			conn = DriverManager.getConnection(connection,user,pass);
			scanner.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return conn;
	}
	public static MyModel getAllData(String tableName) {
		conn = getConnection();
		String sql="SELECT * FROM " + tableName;
		try {
			
			statement = conn.prepareStatement(sql);
			resultSet = statement.executeQuery();
			model = new MyModel(resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return model;
	}
	
	public static MyModel getAllData() {
		conn = getConnection();
		String sql="SELECT R.RESERVOIR_ID, R.RESERVOIR_NAME, R.RESERVOIR_AREA, R.RESERVOIR_DEPTH, P.REGION_NAME, O.RESPONSIBLE_PERSON_FNAME\r\n"
				+ "FROM RESERVOIRS R JOIN REGIONS P ON R.RESERVOIR_ID=P.REGION_ID\r\n"
				+ "		  JOIN RESPONSIBLE_PERSONS O ON R.RESPONSIBLE_PERSON_ID=O.RESPONSIBLE_PERSON_ID";
		try {
			
			statement = conn.prepareStatement(sql);
			resultSet = statement.executeQuery();
			model = new MyModel(resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return model;
	}
	
	
	
	
}
