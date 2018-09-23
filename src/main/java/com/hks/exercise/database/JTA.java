package com.hks.exercise.database;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import oracle.jdbc.xa.client.OracleXADataSource;

import javax.sql.XADataSource;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 分布式事务（Distributed Transaction）,主要由以下2项构成：
 *  1、事务管理器（Transaction Manager,开发人员使用）,担着所有事务参与单元的协调与控制
 *      JTA 事务有效的屏蔽了底层事务资源,使应用可以以透明的方式参入到事务处理中;
 *  2、支持 XA 协议的资源管理器 (Resource Manager,服务提供商实现 )如：Oracle、JMS
 *
 * Java通过2个接口支持分布式事务：
 *      JTA：Java Transaction API
 *      JTS：Java Transaction Service
 */
public class JTA {

    private final static String USERNAME_1 = "rookie";
    private final static String PASSWORD_1 = "rookie";
    private final static String URL_1  = "jdbc:oracle:thin:@(DESCRIPTION =(ADDRESS = (PROTOCOL = TCP)(HOST = localhost)(PORT = 1521))(CONNECT_DATA =(SERVER = DEDICATED)(SERVICE_NAME = rookie)))";

    private final static String USERNAME_2 = "rookie";
    private final static String PASSWORD_2 = "rookie";
    private final static String URL_2  = "jdbc:oracle:thin:@(DESCRIPTION =(ADDRESS = (PROTOCOL = TCP)(HOST = localhost)(PORT = 1521))(CONNECT_DATA =(SERVER = DEDICATED)(SERVICE_NAME = rookie_two)))";


    public static void main(String[] args) {
        try {
            XADataSource xaDataSource_1 = createXADataSource(URL_1, USERNAME_1, PASSWORD_1);
            XADataSource xaDataSource_2 = createXADataSource(URL_2, USERNAME_2, PASSWORD_2);

            // 获得 Transaction 管理对象
            UserTransactionImp userTransactionImp = new UserTransactionImp();
            AtomikosDataSourceBean atomikosDataSourceBean1 = new AtomikosDataSourceBean();
            atomikosDataSourceBean1.setXaDataSource(xaDataSource_1);
            atomikosDataSourceBean1.setUniqueResourceName("rookie");

            AtomikosDataSourceBean atomikosDataSourceBean2 = new AtomikosDataSourceBean();
            atomikosDataSourceBean2.setXaDataSource(xaDataSource_2);
            atomikosDataSourceBean2.setUniqueResourceName("rookie_two");
            boolean rollback = false;
            try {
                //开启事务
                userTransactionImp.begin();
                Connection conn1 = atomikosDataSourceBean1.getConnection();
                PreparedStatement statement = conn1.prepareStatement("insert into users (ID, USERNAME, PASSWORD) VALUES (3,3,3)");
                statement.executeUpdate();

                Connection conn2 = atomikosDataSourceBean2.getConnection();
                PreparedStatement statement2 = conn2.prepareStatement("insert into users (ID, USERNAME, PASSWORD) VALUES (1,1,1)");
                statement2.executeUpdate();

                statement.close();
                statement2.close();
                conn1.close();
                conn2.close();

                rollback = true;
            } catch (Exception e) {
                rollback = true;
                e.printStackTrace();
            } finally {
                try {
                    if (rollback) {
                        userTransactionImp.rollback();
                    } else {
                        userTransactionImp.commit();
                    }
                } catch (SystemException e) {
                    e.printStackTrace();
                } catch (HeuristicMixedException e) {
                    e.printStackTrace();
                } catch (HeuristicRollbackException e) {
                    e.printStackTrace();
                } catch (RollbackException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static XADataSource createXADataSource(String url, String userName, String password) throws SQLException {
        OracleXADataSource dataSource = new OracleXADataSource();
        dataSource.setURL(url);
        dataSource.setUser(userName);
        dataSource.setPassword(password);
        return dataSource;
    }
}
