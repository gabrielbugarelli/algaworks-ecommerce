package com.algaworks.ecommerce.iniciandojpa;

import com.algaworks.ecommerce.model.Produto;
import org.junit.*;

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

  @Test
  public void buscarPorIdentificador () {
    Produto produto = entityManager.find(Produto.class, 1);

    System.out.println("Produto: " + produto.getNome());

    Assert.assertNotNull(produto);
  }

  @Test
  public void atualizarReferencia () {
    Produto produto = entityManager.find(Produto.class, 1);
    produto.setNome("Kindle Paperwhite");

    entityManager.refresh(produto);

    Assert.assertEquals("Kindle", produto.getNome());
  }
}
