package com.algaworks.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "item_pedido")
public class ItemPedido {

  @Id
  private Integer Id;

  @Column(name = "pedido_id")
  private Integer pedidoId;

  @Column(name = "produto_id")
  private Integer produtoId;

  @Column(name = "preco_produto")
  private BigDecimal precoProduto;

  private Integer quandidade;

  public Integer getId() {
    return Id;
  }

  public void setId(Integer id) {
    Id = id;
  }

  public Integer getPedidoId() {
    return pedidoId;
  }

  public void setPedidoId(Integer pedidoId) {
    this.pedidoId = pedidoId;
  }

  public Integer getProdutoId() {
    return produtoId;
  }

  public void setProdutoId(Integer produtoId) {
    this.produtoId = produtoId;
  }

  public BigDecimal getPrecoProduto() {
    return precoProduto;
  }

  public void setPrecoProduto(BigDecimal precoProduto) {
    this.precoProduto = precoProduto;
  }

  public Integer getQuandidade() {
    return quandidade;
  }

  public void setQuandidade(Integer quandidade) {
    this.quandidade = quandidade;
  }
}
