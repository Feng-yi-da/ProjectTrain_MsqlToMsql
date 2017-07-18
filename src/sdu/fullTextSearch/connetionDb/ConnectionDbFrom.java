package sdu.fullTextSearch.connetionDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConnectionDbFrom {
	private String ip = "123.56.165.238:3306";
	private String databaseName = "crawler";
	private String address = "jdbc:mysql://" + ip + "/" + databaseName
			+ "?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	private String name = "*****";
	private String password = "****";
	private Connection connection = null;

	public ConnectionDbFrom() {
		// TODO Auto-generated constructor stub
	}

	public Connection getconnection() {
		// TODO Auto-generated method stub
		try {
			connection = DriverManager.getConnection(address, name, password);
			// ����URLΪ jdbc:mysql//��������ַ/���ݿ��� �������2�������ֱ��ǵ�½�û���������
			System.out.println("�ɹ����ӵ����ݿ�");
			System.out.println("###########################");
			System.out.println();
			return connection;
		} catch (Exception e) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
//			String time=df.format(new Date());
			System.err.print(df.format(new Date())+"\t");// new Date()Ϊ��ȡ��ǰϵͳʱ��
			System.err.println("���ݿ�����ʧ�ܣ�ip="+ip);
//			e.printStackTrace();
		}
		return null;
	}

	public ResultSet getAll(String tableName) {
		connection = getconnection();
		String sql = "select * " + "from  " + tableName + " where id <100;";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.last()) {
				resultSet.beforeFirst();
				return resultSet;
			}
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return null;
	}
}
