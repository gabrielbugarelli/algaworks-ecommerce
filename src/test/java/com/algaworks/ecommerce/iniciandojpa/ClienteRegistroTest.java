package com.algaworks.ecommerce.iniciandojpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Cliente;
import org.junit.Assert;
import org.junit.Test;

public class ClienteRegistroTest extends EntityManagerTest {

  @Test
  public void criarCliente () {
    Cliente gabriel = new Cliente(1, "Gabriel");
    Cliente pedro = new Cliente(2, "Pedro");

    /**
     * @author Gabriel
     * Cria gabriel no banco
     */
    entityManager.getTransaction().begin();
    entityManager.persist(gabriel);
    entityManager.getTransaction().commit();

    /**
     * @author Gabriel
     * Cria pedro no banco
     */
    entityManager.getTransaction().begin();
    entityManager.persist(pedro);
    entityManager.getTransaction().commit();

    //entityManager.clear();

    //testa se os Ids estão diferentes de null no banco de dados
    Assert.assertNotNull(gabriel.getId());
    Assert.assertNotNull(pedro.getId());

    //testa se os dados no banco são estritamente iguais as do banco de dados
    Assert.assertEquals("Gabriel", gabriel.getNome());
    Assert.assertEquals("Pedro", pedro.getNome());
  }

  @Test
  public void editarCliente () {
    Cliente toka = entityManager.find(Cliente.class, 1);
    Cliente nelcael = entityManager.find(Cliente.class, 2);

    //Edita nome Gabriel para Tokashiki no banco de dados
    entityManager.getTransaction().begin();
    toka.setNome("Tokashiki");
    entityManager.merge(toka);
    entityManager.getTransaction().commit();

    //Edita Pedro para Nelcael no banco de dados
    entityManager.getTransaction().begin();
    nelcael.setNome("Nelcael");
    entityManager.merge(nelcael);
    entityManager.getTransaction().commit();

    //teste para validar que Gabriel alterou para Tokashiki no banco de dados
    Cliente tokaVerificado = entityManager.find(Cliente.class, toka.getId());
    Assert.assertEquals("Tokashiki", toka.getNome());

    //teste para validar que Gabriel alterou para Tokashiki no banco de dados
    Cliente nelcaelVerificado = entityManager.find(Cliente.class, nelcael.getId());
    Assert.assertEquals("Nelcael", nelcael.getNome());
  }

  @Test
  public void deletarCliente () {
    Cliente cliente = entityManager.find(Cliente.class, 2);

    entityManager.getTransaction().begin();
    entityManager.remove(cliente);
    entityManager.getTransaction().commit();

    Cliente clienteExcluido = entityManager.find(Cliente.class, 2);
    Assert.assertNull(clienteExcluido);
  }
}
