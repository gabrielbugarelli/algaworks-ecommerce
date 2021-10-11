package com.algaworks.ecommerce.model;

import javax.persistence.*;

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

  @Enumerated(EnumType.STRING)
  private StatusPagamento status;

  private String numero;
}
