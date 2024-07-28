package org.lab.config.ds2;

import lombok.Getter;
import org.lab.config.base.AbstractDatasourceConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Getter
@Configuration
public class DataSource2Config extends AbstractDatasourceConfig {
  @Value("${spring.datasource.springLab.url}")
  private String url;
  @Value("${spring.datasource.springLab.driver}")
  private String driver;
  @Value("${spring.datasource.springLab.username}")
  private String username;
  @Value("${spring.datasource.springLab.password}")
  private String password;
  public static final String DATASOURCE_NAME = "dataSource2";
  public static final String TRANSACTION_MANAGER = DATASOURCE_NAME + "Tm";

  @Bean(name = DATASOURCE_NAME)
  public DataSource dataSource2() {
    return getDataSource();
  }

  // 创建事务管理器的对象
  @Bean(name = TRANSACTION_MANAGER)
  public DataSourceTransactionManager transactionManager(@Qualifier(DATASOURCE_NAME) DataSource dataSource) {
    return getDataSourceTm(dataSource);
  }

}
