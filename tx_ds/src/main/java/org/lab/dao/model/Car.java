package org.lab.dao.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * car
 */
@Data
@NoArgsConstructor
public class Car implements Serializable {
    private BigInteger id;

    private String carNo;

    public Car(String carNo) {
        this.carNo = carNo;
    }
    private static final long serialVersionUID = 1L;
}