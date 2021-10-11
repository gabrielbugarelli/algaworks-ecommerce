package com.algaworks.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Gabriel Fonseca Mendes
 */

@Entity
@Table(name = "pagamento_boleto")
public class PagamentoBoleto {

  @Id
  private Integer id;

  @Column(name = "pedido_id")
  private Integer pedidoId;

  @Column(name = "codigo_barras")
  private String codigoBarras;

  private StatusPagamento status;

  private String numero;
}
