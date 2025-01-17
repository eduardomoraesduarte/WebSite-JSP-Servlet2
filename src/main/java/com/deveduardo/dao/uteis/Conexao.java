package com.deveduardo.dao.uteis;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	public Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbprod", "root", "123456");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

}