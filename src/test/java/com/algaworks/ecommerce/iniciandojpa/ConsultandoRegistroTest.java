package com.algaworks.ecommerce.iniciandojpa;

import com.algaworks.ecommerce.model.Produto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConsultandoRegistroTest {
  private static EntityManagerFactory entityManagerFactory;
  private EntityManager entityManager;

  @BeforeClass
  public static void setUpBefore() {
    entityManagerFactory = Persistence.createEntityManagerFactory("Ecommerce-PU");
  }

  @AfterClass
  public static void tearAfterDown() {
    entityManagerFactory.close();
  }

  @Before
  public void setUp () {
    entityManager = entityManagerFactory.createEntityManager();
  }

  @After
  public void tearDown() {
    entityManager.close();
  }
}
