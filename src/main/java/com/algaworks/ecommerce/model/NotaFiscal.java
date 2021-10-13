package com.algaworks.ecommerce.model;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "nota_fiscal")
public class NotaFiscal {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(optional = false)
    @JoinColumn(name = "pedido_id")
//    @JoinTable(name = "pedido_nota_fiscal",
//            joinColumns = @JoinColumn(name = "nota_fiscal_id", unique = true),
//            inverseJoinColumns = @JoinColumn(name = "pedido_id", unique = true))
    private Pedido pedido;

    private String xml;

    @Column(name = "data_emissao")
    private Date dataEmissao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }
}
