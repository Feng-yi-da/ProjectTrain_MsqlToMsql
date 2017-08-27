package sdu.fullTextSearch.insertFromDb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertNewData {

	public ResultSet SelectNewDate(Connection connectionFrom, Connection connectionTo, String tableNameFrom,
			String tableNameTo) {
		if (connectionFrom != null && connectionTo != null) {
			String sql = "select * " + "from  " + tableNameTo + " order by id DESC  ,id  desc limit 1;";
			try {
				Statement statementTo = connectionTo.createStatement();
				ResultSet resultSetTo = statementTo.executeQuery(sql);
				if (resultSetTo.last()) {
					resultSetTo.beforeFirst();
				}
				Statement statementFrom = connectionFrom.createStatement();
				ResultSet resultSetFrom = statementFrom.executeQuery(sql);
				if (resultSetFrom.last()) {
					resultSetFrom.beforeFirst();
				}
				if (resultSetTo.next() && resultSetFrom.next()) {
					// �ж��Ƿ����δͬ��������
					int idLastTO = resultSetTo.getInt(1);
					int idLastFrom = resultSetFrom.getInt(1);
					if (idLastTO < idLastFrom) {
						sql = "select * " + "from  " + tableNameFrom + " where id > " + idLastTO + " ; ";
						ResultSet resultSetNewData = statementFrom.executeQuery(sql);
						return resultSetNewData;
					} else {
						System.err.println("����������");
						return null;
					}
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.err.println("���ݿ�����ʧ��");
		}

		return null;
	}

	public boolean Insert(Connection connection, ResultSet resultSet, String tableNameTo) {
		if (connection != null) {
			if (resultSet != null) {
				try {
					resultSet.last();
					int tatoll = resultSet.getRow();
					int num = 0;
					resultSet.beforeFirst();
					Statement statement = null;
					while (resultSet.next()) {
						num++;
						String data = "";
						for (int i = 1; i < resultSet.getMetaData().getColumnCount(); i++) {
							if (resultSet.getString(i) != null) {

								data += resultSet.getString(i).replace("\"", "\\\"") + "\",\"";
								// System.out.println(resultSet.getString(i).replaceAll("\"",
								// "\\\""));
							} else {
								data += resultSet.getString(i) + "\",\"";
							}
						}
						data += resultSet.getString(resultSet.getMetaData().getColumnCount()) + "";
						String insert = "insert into " + tableNameTo + " VALUES  ( \"" + data + "\") ;";
						// System.out.println(insert);
						statement = connection.createStatement();
						statement.executeUpdate(insert);
						System.out.println("�� ��" + tatoll + " �����" + num + "��");
					}

					resultSet.close();
					// statement.close();
					// connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.err.println("��������Ϊ��");
			}
		} else {
			System.err.println("���ݿ�����ʧ��");
		}

		return false;
	}

}
