package com.algaworks.ecommerce.iniciandojpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OperacoesComTransacaoTest extends EntityManagerTest{

  @Test
  public void inserirOPrimeiroObjeto () {

    /*
     * @author Gabriel Fonseca Mendes
     * @description teste implementado para validar a persistência dos dados no banco MYSQL
     */
    Produto produto = new Produto();

    produto.setId(2);
    produto.setNome("Camera Tekpix");
    produto.setDescricao("A câmera mais vendida do Brasil");
    produto.setPreco(new BigDecimal(50000));

    entityManager.getTransaction().begin();
    entityManager.persist(produto);
    entityManager.getTransaction().commit();

    //limpa os registros do banco de dados
    entityManager.clear();

     // Teste para validar que o id está sendo preenchido corretamente, diferente de Null
    Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
    Assert.assertNotNull(produtoVerificacao);

    System.out.println("Tekpix: " + produto.getNome());
  }

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
