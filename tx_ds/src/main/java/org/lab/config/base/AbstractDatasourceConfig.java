package org.lab.config.base;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

public abstract class AbstractDatasourceConfig {

  protected DataSource getDataSource() {
    HikariConfig config = new HikariConfig();
    config.setJdbcUrl(getUrl());
    config.setUsername(getUsername());
    config.setPassword(getPassword());
    HikariDataSource ds = new HikariDataSource(config);
    return ds;
  }

  public DataSourceTransactionManager getDataSourceTm(DataSource dataSource) {
    DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
    transactionManager.setDataSource(dataSource);
    return transactionManager;
  }


  public abstract String getUrl() ;

  public abstract String getDriver();

  public abstract String getUsername() ;

  public abstract String getPassword() ;
}
