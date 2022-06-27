package com.shashank.vrms.utilities;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariCPDataSource {
	    final static String configFile = "C:\\Users\\DELL\\eclipse-workspace\\Vehicle-Rental-Management-System\\src\\main\\resources\\db.properties";

	    private static HikariConfig config = new HikariConfig(configFile);
	    private static HikariDataSource ds;

	    static {
	    	try {
	    		 ds = new HikariDataSource(config);
			} catch (Exception e) {
				e.printStackTrace();
			}
	       
	    }

	    public static Connection getConnection() throws SQLException {
	        return ds.getConnection();
	    }

	    private HikariCPDataSource(){}
	}

