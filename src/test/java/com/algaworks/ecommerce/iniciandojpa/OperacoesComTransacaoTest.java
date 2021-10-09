package com.algaworks.ecommerce.iniciandojpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Produto;
import org.junit.Test;

public class OperacoesComTransacaoTest extends EntityManagerTest{

  @Test
  public void abrirEFecharATransacao () {
    Produto produto = new Produto();

    //inicia a transação
    entityManager.getTransaction().begin();

    entityManager.persist(produto);
    entityManager.merge(produto);
    entityManager.remove(produto);

    //finaliza a transação
    entityManager.getTransaction().commit();
  }
}
