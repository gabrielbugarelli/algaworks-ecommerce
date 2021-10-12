package com.algaworks.ecommerce.model;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column
  private String nome;

  @Enumerated(EnumType.STRING)
  private SexoCliente sexo;

  /**
   * parâmetros obrigatórios
   * @param id
   * @param nome
   */

  public Cliente (int id, String nome) {
    this.id = id;
    this.nome = nome;
  }

  public Cliente () {

  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
