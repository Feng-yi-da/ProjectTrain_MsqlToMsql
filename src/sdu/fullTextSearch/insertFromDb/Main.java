package sdu.fullTextSearch.insertFromDb;

import java.sql.ResultSet;
import java.sql.SQLException;

import sdu.fullTextSearch.connetionDb.ConnectionDbFrom;
import sdu.fullTextSearch.connetionDb.ConnectionDbTo;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		ConnectionDbTo connectionDbTo = new ConnectionDbTo();
		ConnectionDbFrom connectionDbFrom = new ConnectionDbFrom();
		InsertNewData insertNewData = new InsertNewData();
		if (connectionDbFrom.getconnection() != null && connectionDbTo.getconnection() != null) {
			ResultSet resultSet = insertNewData.SelectNewDate(connectionDbFrom.getconnection(),
					connectionDbTo.getconnection(), "website", "website");
			System.out.println("ȡ������");
			if (resultSet != null) {
				insertNewData.Insert(connectionDbTo.getconnection(), resultSet, "website");
				System.out.println("�������");
			} else {
				System.out.println("��������");
			}
		}else {
			System.err.println("���ݿ�����ʧ��");
		}

	}
}
