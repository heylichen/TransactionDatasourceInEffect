package org.lab.config.ds1;

import org.apache.ibatis.session.SqlSessionFactory;
import org.lab.config.base.AbstractMyBatisConfig;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MyBatisConfig1 extends AbstractMyBatisConfig {

  private static final String DATA_SOURCE_NAME = DataSource1Config.DATASOURCE_NAME;
  private static final String SQL_SESSION_FACTORY_NAME = DATA_SOURCE_NAME + "SqlSessionFactory";
  private static final String MAPPER_SCANNER_CONFIGURER = DATA_SOURCE_NAME + "MapperScannerConfigurer";

  @Bean(name = MAPPER_SCANNER_CONFIGURER)
  public MapperScannerConfigurer mapperScannerConfigurer() {
    return mapperScannerConfigurer(SQL_SESSION_FACTORY_NAME, "org.lab.dao.mapper.ds1");
  }

  @Bean(name = SQL_SESSION_FACTORY_NAME)
  public SqlSessionFactory sqlSessionFactoryBean(@Autowired @Qualifier(DATA_SOURCE_NAME) DataSource dataSource) throws Exception {
    return getSqlSessionFactory(dataSource, "classpath*:mybatis/mapper/ds1/**/*.xml");
  }
}
