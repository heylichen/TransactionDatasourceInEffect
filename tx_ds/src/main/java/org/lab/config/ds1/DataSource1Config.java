package org.lab.config.ds1;

import lombok.Getter;
import org.lab.config.base.AbstractDatasourceConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Getter
@Configuration
public class DataSource1Config extends AbstractDatasourceConfig {
  @Value("${spring.datasource.springLab.url}")
  private String url;
  @Value("${spring.datasource.springLab.driver}")
  private String driver;
  @Value("${spring.datasource.springLab.username}")
  private String username;
  @Value("${spring.datasource.springLab.password}")
  private String password;

  public static final String DATASOURCE_NAME = "dataSource";
  public static final String TRANSACTION_MANAGER = DATASOURCE_NAME + "Tm";

  @Bean(name=DATASOURCE_NAME)
  @Primary
  public DataSource dataSource() {
    return getDataSource();
  }

  // 创建事务管理器的对象
  @Bean(name = TRANSACTION_MANAGER)
  @Primary
  public DataSourceTransactionManager transactionManager(@Qualifier(DATASOURCE_NAME) DataSource dataSource) {
    return getDataSourceTm(dataSource);
  }

}
