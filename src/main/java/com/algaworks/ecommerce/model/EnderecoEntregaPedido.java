package com.algaworks.ecommerce.model;

import javax.persistence.Embeddable;

/**
 * @see Embeddable basicamente serve para mapearmos uma classe como object em outra classe
 * Exemplo: uso de composição
 */

@Embeddable
public class EnderecoEntregaPedido {

  private String cep, logradouro, numero, bairro, complemento, cidade, estado;
}
