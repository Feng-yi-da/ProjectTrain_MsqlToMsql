package sdu.fullTextSearch.connetionDb;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		ConnectionDbTo connectionDbTo = new ConnectionDbTo();
		ConnectionDbFrom connectionDbFrom = new ConnectionDbFrom();
		
		if (connectionDbFrom.getconnection()!=null) {
//			ResultSet resultSet = connectionDbTo.getAll("website");
			ResultSet resultSet = connectionDbFrom.getAll("website");
			while (resultSet.next()) {
				String data = "";
				for (int i = 1; i < resultSet.getMetaData().getColumnCount(); i++) {
					if (resultSet.getString(i) != null) {
						data += resultSet.getString(i).replace("\"", "\\\"") + "\",\"";
					} else {
						data += resultSet.getString(i) + "\",\"";
					}
				}
				System.out.println(data);
			}
		}
		
		if (connectionDbTo.getconnection()!=null) {
			ResultSet resultSet = connectionDbTo.getAll("website");
//			ResultSet resultSet = connectionDbFrom.getAll("website");
			while (resultSet.next()) {
				String data = "";
				for (int i = 1; i < resultSet.getMetaData().getColumnCount(); i++) {
					if (resultSet.getString(i) != null) {
						data += resultSet.getString(i).replace("\"", "\\\"") + "\",\"";
					} else {
						data += resultSet.getString(i) + "\",\"";
					}
				}
				System.out.println(data);
			}
		}

	}

}
