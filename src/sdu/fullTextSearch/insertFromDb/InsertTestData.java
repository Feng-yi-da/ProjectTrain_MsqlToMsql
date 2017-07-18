package sdu.fullTextSearch.insertFromDb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import sdu.fullTextSearch.connetionDb.ConnectionDbTo;

public class InsertTestData {

	public ResultSet SelectDate(Connection connection, String website_name) {

		if (connection != null) {
			String sql = "SELECT * FROM webcrawler.website where website_name = \"" + website_name + "\";";
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);
				int tatollnum = 0;
				int min = 0;
				int max = 0;
				if (resultSet.last()) {
					tatollnum = resultSet.getRow();
					System.out.println(resultSet.getRow());
					System.out.println(resultSet.getRow() / 16);
					min = (int) (resultSet.getRow() / 16 - resultSet.getRow() / 16 * 0.4);
					max = (int) (resultSet.getRow() / 16 + resultSet.getRow() / 16 * 0.4);
					resultSet.beforeFirst();
				}
				int number[] = new int[16];
				for (int i = 0; i < 16 - 1; i++) {
					int temp = (int) (Math.random() * (tatollnum / (15 - i)));
					if (temp < min || temp > max) {
						i = i - 1;
						// System.out.println("QWEQWE"+temp);
						continue;
					} else {
						// System.out.println("123qweqe"+temp);
					}
					tatollnum = tatollnum - temp;
					number[i] = temp;
					// System.out.println(temp);
					if (i == 14) {
						// System.out.println(tatollnum);
						number[15] = tatollnum;
					}
				}

				int minnumber = 0;
				for (int i = 0; i < number.length; i++) {
					minnumber += number[i];
					// System.out.println(number[i]);
					resultSet.beforeFirst();
					int tempid = 0;
					while (resultSet.next()) {
						tempid++;
						if (i == 0) {
							if (tempid <= minnumber) {
								if (tempid == minnumber) {
									// System.out.println(min - number[i] + " "
									// + tempid);
								}
								String time = "2017-07-06 11:11:11";
								switch (i) {
								case 0:
									time = "2017-07-06 11:11:11";
									break;
								case 1:
									time = "2017-07-07 11:11:11";
									break;
								case 2:
									time = "2017-07-08 11:11:11";
									break;
								case 3:
									time = "2017-07-09 11:11:11";
									break;
								case 4:
									time = "2017-07-10 11:11:11";
									break;
								case 5:
									time = "2017-07-11 11:11:11";
									break;
								case 6:
									time = "2017-07-12 11:11:11";
									break;
								case 7:
									time = "2017-07-13 11:11:11";
									break;
								case 8:
									time = "2017-07-14 11:11:11";
									break;
								case 9:
									time = "2017-07-15 11:11:11";
									break;
								case 10:
									time = "2017-07-16 11:11:11";
									break;
								case 11:
									time = "2017-07-17 11:11:11";
									break;
								case 12:
									time = "2017-07-18 11:11:11";
									break;
								case 13:
									time = "2017-07-19 11:11:11";
									break;
								case 14:
									time = "2017-07-20 11:11:11";
									break;
								default:
									time = "2017-07-21 11:11:11";
									break;
								}
								String id = resultSet.getString(1);
								// System.out.println(resultSet.getString(1) +
								// "|||||||||" + time);
								String sqlInsert = "insert into website_insert (  time  ,   id  , website_name  ) value( \""
										+ time + "\" ," + id + " , \"" + website_name + "\" );";
								System.out.println(sqlInsert);
								Statement statementInsert = connection.createStatement();
								statementInsert.executeUpdate(sqlInsert);

							}
						} else {
							if (tempid > minnumber - number[i - 1] && tempid <= minnumber) {
								if (tempid == minnumber) {
									// System.out.println(min - number[i] + " "
									// + tempid);
								}
								String time = "2017-07-06 11:11:11";
								switch (i) {
								case 0:
									time = "2017-07-06 11:11:11";
									break;
								case 1:
									time = "2017-07-07 11:11:11";
									break;
								case 2:
									time = "2017-07-08 11:11:11";
									break;
								case 3:
									time = "2017-07-09 11:11:11";
									break;
								case 4:
									time = "2017-07-10 11:11:11";
									break;
								case 5:
									time = "2017-07-11 11:11:11";
									break;
								case 6:
									time = "2017-07-12 11:11:11";
									break;
								case 7:
									time = "2017-07-13 11:11:11";
									break;
								case 8:
									time = "2017-07-14 11:11:11";
									break;
								case 9:
									time = "2017-07-15 11:11:11";
									break;
								case 10:
									time = "2017-07-16 11:11:11";
									break;
								case 11:
									time = "2017-07-17 11:11:11";
									break;
								case 12:
									time = "2017-07-18 11:11:11";
									break;
								case 13:
									time = "2017-07-19 11:11:11";
									break;
								case 14:
									time = "2017-07-20 11:11:11";
									break;
								default:
									time = "2017-07-21 11:11:11";
									break;
								}
								String id = resultSet.getString(1);
								// System.out.println(resultSet.getString(1) +
								// "|||||||||" + time);
								String sqlInsert = "insert into website_insert (  time  ,   id  , website_name  ) value( \""
										+ time + "\" ," + id + " , \"" + website_name + "\" );";
								System.out.println(sqlInsert);
								Statement statementInsert = connection.createStatement();
								statementInsert.executeUpdate(sqlInsert);

							}
						}

					}

				}

				// while (resultSet.next()) {
				// id++;
				// if (id+ ) {
				//
				// }
				// }
				// SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd
				// HH:mm:ss");//设置日期格式
				// String time=df.format(new Date());
				// System.out.print(df.format(new Date())+"\t");// new
				// Date()为获取当前系统时间
				//
				//
				// insert into website_insert (time,id,website_name)
				// value(now(),new.id,new.website_name);
				//
				// String str = "2017-01-14 00:00:00";
				// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd
				// HH:mm:ss");
				// Date date = null; //初始化date
				// try {
				// date = sdf.parse(str); //Mon Jan 14 00:00:00 CST 2013
				// } catch (ParseException e) {
				// e.printStackTrace();
				// }
				//
				//
				// Statement statementInsert = connection.createStatement();
				// ResultSet resultSetInsert = statementFrom.executeQuery(sql);
				// if (resultSetFrom.last()) {
				// resultSetFrom.beforeFirst();
				// }

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.err.println("数据库连接失败");
		}

		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectionDbTo connectionDbTo = new ConnectionDbTo();
		InsertTestData insertTestData = new InsertTestData();
		insertTestData.SelectDate(connectionDbTo.getconnection(), "新浪网");
	}

}
