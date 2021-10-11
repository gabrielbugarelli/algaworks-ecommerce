package com.algaworks.ecommerce.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedido")
public class Pedido {

  @Id
  private Integer id;

  @Column(name = "data_pedido")
  private LocalDateTime dataPedido;

  @Column(name = "data_conclusao")
  private LocalDateTime dataConclusao;

  @Column(name = "nota_fiscal_id")
  private Integer notaFiscalId;

  @Enumerated(EnumType.STRING)
  private StatusPedido status;

  private BigDecimal total;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public LocalDateTime getDataPedido() {
    return dataPedido;
  }

  public void setDataPedido(LocalDateTime dataPedido) {
    this.dataPedido = dataPedido;
  }

  public LocalDateTime getDataConclusao() {
    return dataConclusao;
  }

  public void setDataConclusao(LocalDateTime dataConclusao) {
    this.dataConclusao = dataConclusao;
  }

  public Integer getNotaFiscalId() {
    return notaFiscalId;
  }

  public void setNotaFiscalId(Integer notaFiscalId) {
    this.notaFiscalId = notaFiscalId;
  }

  public StatusPedido getStatus() {
    return status;
  }

  public void setStatus(StatusPedido status) {
    this.status = status;
  }

  public BigDecimal getTotal() {
    return total;
  }

  public void setTotal(BigDecimal total) {
    this.total = total;
  }
}
