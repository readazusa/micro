package club.lovety.xy.log;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by 念梓  on 2016/11/23.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public class DbLoggerFactory {

    private static interface Singleton {
        final DbLoggerFactory INSTANCE = new DbLoggerFactory();
    }

    private DruidDataSource druidDataSource = new DruidDataSource();

    private DbLoggerFactory() {
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setPassword("tang123");
        druidDataSource.setUsername("root");
        druidDataSource.setUrl("jdbc:mysql://1551sp9557.imwork.net:3306/wx?useUnicode=true&characterEncoding=utf8&useSSL=true");
    }

    public static Connection getDatabaseConnection() throws SQLException {
        return Singleton.INSTANCE.druidDataSource.getConnection();
    }

}
