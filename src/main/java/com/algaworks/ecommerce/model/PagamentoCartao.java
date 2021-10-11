package com.algaworks.ecommerce.model;

import javax.persistence.*;

@Entity
@Table(name = "pagamento_cartao")
public class PagamentoCartao {

  @Id
  private Integer id;

  @Column(name = "pedido_id")
  private Integer pedidoId;

  @Enumerated(EnumType.STRING)
  private StatusPagamento status;
  private String numero;
}
