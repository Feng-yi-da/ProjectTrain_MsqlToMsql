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
			System.out.println("取出数据");
			if (resultSet != null) {
				insertNewData.Insert(connectionDbTo.getconnection(), resultSet, "website");
				System.out.println("插入完成");
			} else {
				System.out.println("暂无数据");
			}
		}else {
			System.err.println("数据库连接失败");
		}

	}
}
