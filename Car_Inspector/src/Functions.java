import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Functions {
	public static int[] userCheck(String UserName, String UserPassword) throws Exception {
		return (selectDatabase(UserName, UserPassword));
	}

// connect To Database
	public static Connection connectDatabase() throws Exception {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/testdb";
			String username = "root";
			String password = "mysql1";
			Class.forName(driver);

			Connection conn = DriverManager.getConnection(url, username, password);
			return conn;
		} catch (Exception e) {
			System.out.println("Connection Error");
			System.out.println(e);
		}

		return null;
	}

// select from Database
	public static int[] selectDatabase(String UserName, String UserPassword) throws Exception {
		try {
			// connect To Database
			Connection con = connectDatabase();
			// define query
			PreparedStatement statement = con
					.prepareStatement("SELECT * FROM Employees where UserName = \"" + UserName.trim() + "\" ;");

			ResultSet result = statement.executeQuery();

			int PersonID;
			String UserPasswordDB;
			String AccountStatusDB;
			int ConnectAttemptsDB;
			Timestamp BlockingTimeDB;
			int diff = 0;
			int waitTime = 20;

			// assign all fields from database
			if (result.next()) {
				PersonID = result.getInt("PersonID");
				// String UserNameDB = result.getString("UserName");
				UserPasswordDB = result.getString("UserPassword");
				AccountStatusDB = result.getString("AccountStatus");
				ConnectAttemptsDB = result.getInt("ConnectAttempts");
				BlockingTimeDB = result.getTimestamp("BlockingTime");
				if (BlockingTimeDB != null) {
					diff = (int) (((new Timestamp(System.currentTimeMillis()).getTime()) - (BlockingTimeDB.getTime()))
							/ 1000);
					if (diff > waitTime) {
						// create the java mysql to unlock the account
						String queryUpd1 = "Update Employees set AccountStatus = ?, ConnectAttempts = ?, BlockingTime = ? where PersonID = ? ;";
						PreparedStatement preparedStmt = con.prepareStatement(queryUpd1);
						AccountStatusDB = "O";
						ConnectAttemptsDB = 0;
						BlockingTimeDB = null;
						preparedStmt.setString(1, AccountStatusDB);
						preparedStmt.setInt(2, ConnectAttemptsDB);
						preparedStmt.setTimestamp(3, BlockingTimeDB);
						preparedStmt.setInt(4, PersonID);
						// execute the java update query
						preparedStmt.executeUpdate();
						// if too many attempts --> block the account
					}
				}
				// check if the account is blocked
				if (AccountStatusDB.equals("B")) {
					return new int[] { 3, waitTime - diff };
				}
				// check if the password is correct
				if (!UserPassword.equals(UserPasswordDB)) {
					// create the java mysql to increment the number of failed connection attempts
					String queryUpd1 = "Update Employees set ConnectAttempts = ? where PersonID = ? ;";
					PreparedStatement preparedStmt = con.prepareStatement(queryUpd1);
					preparedStmt.setInt(1, (ConnectAttemptsDB + 1));
					preparedStmt.setInt(2, PersonID);
					// execute the java update query
					preparedStmt.executeUpdate();
					// if too many attempts --> block the account
					if ((ConnectAttemptsDB + 1) >= 5) {
						// create the java mysql to block the account
						String queryUpd2 = "Update Employees set AccountStatus = ? , BlockingTime = ? where PersonID = ? ;";
						PreparedStatement preparedStmt2 = con.prepareStatement(queryUpd2);
						preparedStmt2.setString(1, "B");
						preparedStmt2.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
						preparedStmt2.setInt(3, PersonID);
						// execute the java update query
						preparedStmt2.executeUpdate();
					}
					// check if the account is blocked
					if (AccountStatusDB.equals("B")) {
						return new int[] { 3, waitTime - diff };
					}
					return new int[] { 2, (ConnectAttemptsDB + 1) };
				}
			} else {
				return new int[] { 1, 0 };
			}
			return new int[] { 0, 0 };

		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Selection Error");
		}
		return new int[] { 0, 0 };

	}

//Insert in CarInspector Database
	public static int insertCarInspector(String[] InputForInsert) throws Exception {
		try {
			String OwnerLastName = InputForInsert[0];
			String OwnerFirstName = InputForInsert[1];
			String OwnerAddress = InputForInsert[2];
			String OwnerCarType = InputForInsert[3];
			String TotalToPay = InputForInsert[4];
			String Payed = InputForInsert[5];
			// connect To Database
			Connection con = connectDatabase();
			// define query
			PreparedStatement statement = con.prepareStatement(
					"INSERT INTO `testdb`.`CarInspector`(`OwnerLastName`, `OwnerFirstName`, `OwnerAddress`, `OwnerCarType`, `TotalToPay`, `Payed`, `DateCre`) VALUES (\""
							+ OwnerLastName.trim() + "\",\"" + OwnerFirstName.trim() + "\",\"" + OwnerAddress.trim()
							+ "\",\"" + OwnerCarType.trim() + "\",\"" + TotalToPay.trim() + "\",\"" + Payed.trim()
							+ "\",CURRENT_TIMESTAMP) ;");
			int result = statement.executeUpdate();
			return result;

		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Selection Error");
		}
		return 0;
	}

//Search CarId in database
	public static String[] SearchCarId(String CarId) throws Exception {

		String[] SelectDatabase = new String[7];

		try {
			// connect To Database
			Connection con = connectDatabase();
			// define query
			PreparedStatement statement = con
					.prepareStatement("SELECT * FROM `testdb`.`CarInspector` where CarID = \"" + CarId.trim() + "\" ;");

			ResultSet result = statement.executeQuery();

			String OwnerLastName;
			String OwnerFirstName;
			String OwnerAddress;
			String OwnerCarType;
			Double TotalToPay;
			Double Payed;

			// assign all fields from database
			if (result.next()) {
				SelectDatabase[0] = "0";
				SelectDatabase[1] = result.getString("OwnerLastName");
				SelectDatabase[2] = result.getString("OwnerFirstName");
				SelectDatabase[3] = result.getString("OwnerAddress");
				SelectDatabase[4] = result.getString("OwnerCarType");
				SelectDatabase[5] = result.getString("TotalToPay");
				SelectDatabase[6] = result.getString("Payed");
			} else {
				SelectDatabase[0] = "1";
			}

		} catch (Exception e) {
			SelectDatabase[0] = "9";
			System.out.println(e);
			System.out.println("Selection Error");
		}
		return SelectDatabase;
	}

//Update CarId in database	

	public static int UpdateCarInspector(UpdateCar.CustomInputField[] updateFields) {

		String OwnerLastName = updateFields[0].getText().trim();
		String OwnerFirstName = updateFields[1].getText().trim();
		String OwnerAddress = updateFields[2].getText().trim();
		String OwnerCarType = updateFields[3].getText().trim();
		Double TotalToPay = Double.parseDouble(updateFields[4].getText().trim());
		Double Payed = Double.parseDouble(updateFields[5].getText().trim());
		int CarId = Integer.parseInt(updateFields[6].getText().trim());

		try {
			// connect To Database
			Connection con = connectDatabase();
			// define query
			String queryUpd2 = "UPDATE `testdb`.`CarInspector` SET OwnerLastName = ? , OwnerFirstName = ? , OwnerAddress = ? , OwnerCarType = ? , TotalToPay = ? , Payed = ? Where CarId = ? ;";
			PreparedStatement preparedStmt = con.prepareStatement(queryUpd2);
			preparedStmt.setString(1, OwnerLastName);
			preparedStmt.setString(2, OwnerFirstName);
			preparedStmt.setString(3, OwnerAddress);
			preparedStmt.setString(4, OwnerCarType);
			preparedStmt.setDouble(5, TotalToPay);
			preparedStmt.setDouble(6, Payed);
			preparedStmt.setInt(7, CarId);	
			// execute the java update query
			int result = preparedStmt.executeUpdate();

			if (result == 1 ) {
				return 0;
			} else {
				System.out.println(result);
				return 9;
			}

		} catch (Exception e) {
			System.out.println(e);
			return 9;
		}

	}
	
//Delete CarId from database	
	

	public static int DeleteCarInspector(DeleteCar.CustomInputField customInputField) {
		int CarId = Integer.parseInt(customInputField.getText().trim());

		try {
			// connect To Database
			Connection con = connectDatabase();
			// define query
			String queryDel = "DELETE FROM `testdb`.`CarInspector` WHERE CarId = ?;";
			PreparedStatement preparedStmt = con.prepareStatement(queryDel);
			preparedStmt.setInt(1, CarId);	
			// execute the java update query
			int result = preparedStmt.executeUpdate();

			if (result == 1 ) {
				return 0;
			} else {
				return 9;
			}

		} catch (Exception e) {
			return 9;
		}

	}

}
