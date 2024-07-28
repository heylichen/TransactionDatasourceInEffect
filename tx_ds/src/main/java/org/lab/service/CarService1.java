package org.lab.service;

import org.lab.dao.mapper.ds1.CarMapper;
import org.lab.dao.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;

/**
 * @author lichen
 * @date 2024-7-27 17:27
 */
@Component
public class CarService1 {
    @Autowired
    private CarMapper carMapper;

    // inner transaction
    // transactionManager not specified, will use @Primary TransactionManager instance: dataSourceTm.
    // tx enabled on Connections from dataSource.
    @Transactional
    public void addCar() {
        Car c1 = new Car();
        c1.setCarNo("Car11");

        ////use connections from dataSource, tx enabled. Connection AutoCommit is false
        carMapper.insert(Collections.singletonList(c1));

        Car c2 = new Car();
        c2.setCarNo("Car12");
        carMapper.insert(Collections.singletonList(c2));
        if (1 == 1) {
            throw new IllegalArgumentException("测试异常");
        }
    }

    @Transactional
    public void deleteByCarNos(Collection<String> carNos) {
        carMapper.deleteByCarNos(carNos);
    }
}
