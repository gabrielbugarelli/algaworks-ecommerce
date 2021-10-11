package com.algaworks.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {

  @Id
  private Integer id;

  @Column
  private String nome;
  @Column(name = "categoria_pai_id")
  private Integer categoriaPaiId;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Integer getCategoriaPaiId() {
    return categoriaPaiId;
  }

  public void setCategoriaPaiId(Integer categoriaPaiId) {
    this.categoriaPaiId = categoriaPaiId;
  }
}