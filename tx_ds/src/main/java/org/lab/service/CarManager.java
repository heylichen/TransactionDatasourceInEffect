package org.lab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * @author lichen
 * @date 2024-7-27 17:30
 */
@Component
public class CarManager {
    @Autowired
    private CarService1 carService1;
    @Autowired
    private CarService2 carService2;

    @Transactional
    public void deleteByCarNos(Collection<String> carNos) {
        carService1.deleteByCarNos(carNos);
    }

    //outer transaction
    @Transactional
    public void testUsingDefaultTxManager() {
        try {
            carService1.addCar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        carService2.addCarUsingDefaultTxManager();
        //expect:
        //carService1.addCar rollback
        //carService2.addCarUsingDefaultTxManager NOT rollback
    }

    @Transactional
    public void testUsingSeparateTxManager() {
        try {
            carService1.addCar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        carService2.addCarUsingTxManager2();
        //expect:
        //carService1.addCar rollback
        //carService2.addCarUsingDefaultTxManager rollback
    }


}
