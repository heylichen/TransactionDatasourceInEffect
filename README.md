# TransactionDatasourceInEffect
Use Spring Transaction abstract for tx management and mybatis as DAO layer.

What happens if dataSource instance used in Transaction Manager and mybatis does not match?

carService1 and carService2 both access the same database and table, while using 
different dataSource instances.

DataSource passed to Mybatis SqlSessionFactory determines the dataSource in use for Mappers.

DataSource passed to Spring DataSourceTransactionManager determines the dataSource in use for
transaction management.

If the dataSource instances are not the same in SqlSessionFactory and DataSourceTransactionManager,
transaction management is just not enabled for Mapper methods. This is a project used for verification.
See CarManagerTest.
