package utilities;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariCPDataSource {
	    final static String configFile = "src/main/resources/db.properties";

	    private static HikariConfig config = new HikariConfig(configFile);
	    private static HikariDataSource ds;

	    static {
	        System.out.println("here");
	        ds = new HikariDataSource(config);
	    }

	    public static Connection getConnection() throws SQLException {
	        return ds.getConnection();
	    }

	    private HikariCPDataSource(){}
	}

