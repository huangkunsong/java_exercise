package com.hks.exercise.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * JDBC事务通过数据资源库（数据库）提供,依赖底层的数据库。
 * 只适用于单个数据源的操作。
 */
public class JDBC {

    private final static String USERNAME = "rookie";
    private final static String PASSWORD = "rookie";
    private final static String URL  = "jdbc:oracle:thin:@(DESCRIPTION =(ADDRESS = (PROTOCOL = TCP)(HOST = localhost)(PORT = 1521))(CONNECT_DATA =(SERVER = DEDICATED)(SERVICE_NAME = rookie)))";

    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            con.setAutoCommit(false);
            PreparedStatement  preparedStatement = con.prepareStatement(
                "insert into users (ID, USERNAME, PASSWORD) VALUES (2,2,2)");
            preparedStatement.executeUpdate();
            con.commit();
            preparedStatement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
