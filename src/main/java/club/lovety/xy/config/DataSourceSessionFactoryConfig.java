package club.lovety.xy.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;



/**
 * Created by 念梓  on 2016/11/21.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@Configuration
@EnableTransactionManagement
public class DataSourceSessionFactoryConfig {

//    @Resource
//    private DruidDataSource dataSource;

    @Bean
    public DruidDataSource getDruidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setPassword("tang123");
        druidDataSource.setUsername("root");
        druidDataSource.setUrl("jdbc:mysql://1551sp9557.imwork.net:3306/wx?useUnicode=true&characterEncoding=utf8&useSSL=true");
        return druidDataSource;
    }

    @Bean
    public SqlSessionFactoryBean loadSqlSessionFactoryBean(){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(getDruidDataSource());
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis/sql-map-config-mysql.xml"));
        return sqlSessionFactoryBean;
    }

    @Bean
    public PlatformTransactionManager loadPlatformTransactionManager(){
        return new DataSourceTransactionManager(getDruidDataSource());
    }

}
