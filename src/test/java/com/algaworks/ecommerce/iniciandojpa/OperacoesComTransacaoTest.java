package com.algaworks.ecommerce.iniciandojpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OperacoesComTransacaoTest extends EntityManagerTest{

  @Test
  public void inserirObjetoComMerge () {
    Produto produto = new Produto();
    produto.setId(4);
    produto.setPreco(new BigDecimal(7000.00));
    produto.setDescricao("A câmera mais vendida do Brasil");
    produto.setNome("Tekpix");

    entityManager.getTransaction().begin();
    entityManager.merge(produto);
    entityManager.getTransaction().commit();

    // teste se o produto existe no banco de dados
    Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
    Assert.assertNotNull(produtoVerificacao);

    //teste se o produto é o possui o mesmo conteúdo do banco de dados
    Assert.assertEquals("Tekpix", produtoVerificacao.getNome());

  }

  @Test
  public void atualizarObjetoGerenciado () {
    Produto produto = entityManager.find(Produto.class, 1);

    entityManager.getTransaction().begin();
    produto.setNome("Kindle Paperwhite 2021");
    produto.setPreco(new BigDecimal("870.00"));
    entityManager.getTransaction().commit();

    // teste se o produto existe no banco de dados
    Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
    Assert.assertNotNull(produtoVerificacao);

    //teste se o produto é o possui o mesmo conteúdo do banco de dados
    Assert.assertEquals("Kindle Paperwhite 2021", produtoVerificacao.getNome());

  }

  @Test
  public void atualizarObjeto () {
    Produto produto = new Produto();
    produto.setId(1);
    produto.setNome("Kindle OASIS");
    produto.setDescricao("O Kindle mais top de linha da Amazon");
    produto.setPreco(new BigDecimal(50000));

    entityManager.getTransaction().begin();
    entityManager.merge(produto);
    entityManager.getTransaction().commit();

    entityManager.clear();

    // teste se o produto existe no banco de dados
    Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
    Assert.assertNotNull(produtoVerificacao);

    //teste se o produto é o possui o mesmo conteúdo do banco de dados
    Assert.assertEquals("Kindle OASIS", produtoVerificacao.getNome());

  }

  @Test
  public void removerObjeto () {
    Produto produto = entityManager.find(Produto.class, 3);

    entityManager.getTransaction().begin();
    entityManager.remove(produto);
    entityManager.getTransaction().commit();

    // entityManager.clear(); não é necessário para operações de remoção

    //Teste para validar que a linha do id 3 não existe no banco
    Produto produtoVerificacao = entityManager.find(Produto.class, 3);
    Assert.assertNull(produtoVerificacao);
  }

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

    produto.setId(4);
    produto.setNome("Tekpix");
    produto.setDescricao("A câmera mais vendida do Brasil");
    produto.setPreco(new BigDecimal(1300));

    //inicia a transação
    entityManager.getTransaction().begin();
    entityManager.persist(produto);
    entityManager.remove(produto);

    //finaliza a transação
    entityManager.getTransaction().commit();
  }
}
