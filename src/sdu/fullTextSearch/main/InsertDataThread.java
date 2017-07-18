package sdu.fullTextSearch.main;

import java.sql.ResultSet;

import sdu.fullTextSearch.connetionDb.ConnectionDbFrom;
import sdu.fullTextSearch.connetionDb.ConnectionDbTo;
import sdu.fullTextSearch.insertFromDb.InsertNewData;

public class InsertDataThread extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		long insertTime = 60000;
		long noConnet = 300000;
		while (true) {
			ConnectionDbTo connectionDbTo = new ConnectionDbTo();
			ConnectionDbFrom connectionDbFrom = new ConnectionDbFrom();
			InsertNewData insertNewData = new InsertNewData();
			if (connectionDbFrom.getconnection()!=null&&connectionDbTo.getconnection()!=null) {
				ResultSet resultSet = insertNewData.SelectNewDate(connectionDbFrom.getconnection(),
						connectionDbTo.getconnection(), "website", "website");
				System.out.println("取出数据");
				if (resultSet != null) {
					insertNewData.Insert(connectionDbTo.getconnection(), resultSet, "website");
					System.out.println("插入完成");
				} else {
					System.out.println("暂无数据");
				}
				try {
					Thread.sleep(insertTime);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				try {
					
					Thread.sleep(noConnet);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread insertDataThread = new InsertDataThread();
//		long insertTime = 3000;
		insertDataThread.start();
		while (true) {

		}
	}

}
