package org.lab.config.base;

import org.apache.ibatis.logging.slf4j.Slf4jImpl;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

public abstract class AbstractMyBatisConfig {

  public MapperScannerConfigurer mapperScannerConfigurer(String sqlSessionFactoryBeanName, String basePackage) {
    MapperScannerConfigurer mapperScannerConfigurer = getMapperScannerConfigurer();
    mapperScannerConfigurer.setSqlSessionFactoryBeanName(sqlSessionFactoryBeanName);
    mapperScannerConfigurer.setBasePackage(basePackage);
    return mapperScannerConfigurer;
  }

  public SqlSessionFactory getSqlSessionFactory(DataSource dataSource, String mapperLocationPattern) throws Exception {
    SqlSessionFactoryBean sqlSessionFactoryBean = getSqlSessionFactoryBean(dataSource);
    ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    sqlSessionFactoryBean.setMapperLocations(resolver.getResources(mapperLocationPattern));
    return sqlSessionFactoryBean.getObject();
  }

  protected SqlSessionFactoryBean getSqlSessionFactoryBean(DataSource dataSource) {
    SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
    factory.setDataSource(dataSource);

    org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration();
    config.setDefaultStatementTimeout(2);
    config.setDefaultFetchSize(10000);
    config.setDefaultExecutorType(ExecutorType.REUSE);
    config.setLogImpl(Slf4jImpl.class);
    config.setLogPrefix("dao.");
    factory.setConfiguration(config);
    return factory;
  }

  protected static MapperScannerConfigurer getMapperScannerConfigurer() {
    MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
    return mapperScannerConfigurer;
  }
}
