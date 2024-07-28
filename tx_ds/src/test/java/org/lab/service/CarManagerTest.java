package org.lab.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.lab.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@Slf4j
public class CarManagerTest {
  private AnnotationConfigApplicationContext appContext;
  private CarManager carManager;

  @Before
  public void setUp() {
    appContext = new AnnotationConfigApplicationContext(AppConfig.class);
    carManager = appContext.getBean(CarManager.class);
    carManager.deleteByCarNos(Arrays.asList("Car11","Car12","Car21","Car22"));
  }

  @Test
  public void testUsingDefaultTxManager() {
    carManager.testUsingDefaultTxManager();
  }

  @Test
  public void testUsingSeparateTxManager() {
    carManager.testUsingSeparateTxManager();
  }
}