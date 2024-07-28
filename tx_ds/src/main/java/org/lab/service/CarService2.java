package org.lab.service;

import org.lab.config.ds2.DataSource2Config;
import org.lab.dao.mapper.ds2.CarMapper2;
import org.lab.dao.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

/**
 * @author lichen
 * @date 2024-7-27 17:27
 */
@Component
public class CarService2 {

  //CarMapper2 use dataSource2 to get Connection
  @Autowired
  private CarMapper2 carMapper;

  // inner transaction
  // transactionManager not specified, will use @Primary TransactionManager instance: dataSourceTm.
  // tx enabled on Connections from dataSource.
  @Transactional
  public void addCarUsingDefaultTxManager() {
    Car c1 = new Car();
    c1.setCarNo("Car21");
    //use connections from dataSource2, tx not enabled. Connection AutoCommit is true
    carMapper.insert(Collections.singletonList(c1));

    Car c2 = new Car();
    c2.setCarNo("Car22");
    carMapper.insert(Collections.singletonList(c2));
    if (1 == 1) {
      throw new IllegalArgumentException("测试异常");
    }
  }

  // inner transaction
  // will use specified transactionManager specified: dataSource2Tm.
  // tx enabled on Connections from dataSource2.
  @Transactional(transactionManager = DataSource2Config.TRANSACTION_MANAGER)
  public void addCarUsingTxManager2() {
    Car c1 = new Car();
    c1.setCarNo("Car31");

    //use connections from dataSource2, tx enabled. Connection AutoCommit is false
    carMapper.insert(Collections.singletonList(c1));

    Car c2 = new Car();
    c2.setCarNo("Car32");
    carMapper.insert(Collections.singletonList(c2));
    if (1 == 1) {
      throw new IllegalArgumentException("测试异常");
    }
  }
}
