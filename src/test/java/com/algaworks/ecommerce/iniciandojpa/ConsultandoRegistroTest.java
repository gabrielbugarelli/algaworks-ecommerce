package com.algaworks.ecommerce.iniciandojpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Produto;
import org.junit.*;

public class ConsultandoRegistroTest extends EntityManagerTest {

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
