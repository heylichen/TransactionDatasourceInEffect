package org.lab.config.ds2;

import org.apache.ibatis.session.SqlSessionFactory;
import org.lab.config.base.AbstractMyBatisConfig;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MyBatisConfig2 extends AbstractMyBatisConfig {

  private static final String DATA_SOURCE_NAME = DataSource2Config.DATASOURCE_NAME;
  private static final String SQL_SESSION_FACTORY_NAME = DATA_SOURCE_NAME + "SqlSessionFactory";
  private static final String MAPPER_SCANNER_CONFIGURER = DATA_SOURCE_NAME + "MapperScannerConfigurer";

  @Bean(name = MAPPER_SCANNER_CONFIGURER)
  public MapperScannerConfigurer mapperScannerConfigurer() {
    return mapperScannerConfigurer(SQL_SESSION_FACTORY_NAME, "org.lab.dao.mapper.ds2");
  }

  @Bean(name = SQL_SESSION_FACTORY_NAME)
  public SqlSessionFactory sqlSessionFactoryBean(@Autowired @Qualifier(DATA_SOURCE_NAME) DataSource dataSource) throws Exception {
    return getSqlSessionFactory(dataSource, "classpath*:mybatis/mapper/ds2/**/*.xml");
  }
}
