package com.algaworks.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente {
  @Id
  private int id;

  @Column
  private String nome;

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
