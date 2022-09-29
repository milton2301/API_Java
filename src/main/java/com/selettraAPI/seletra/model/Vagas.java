
package com.selettraAPI.seletra.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author amilt
 */

@Entity
@Table(name ="vagas")
public class Vagas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "ativo", nullable = true, updatable = true)
    @JsonProperty("")
    private Boolean ativo;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "dtcad", nullable = true, updatable = true)
    @JsonProperty("")
    private Date dtcad;
    @Column(name = "usercad", nullable = true, updatable = true)
    @JsonProperty("")
    private String usercad;
    @Column(name = "descricao", nullable = true, updatable = true)
    @JsonProperty("")
    private String descricao;
    @Column(name = "nome", nullable = true, updatable = true)
    @JsonProperty("")
    private String nome;
    @Column(name = "setor", nullable = true, updatable = true)
    @JsonProperty("")
    private String setor;
    @Column(name = "salario", nullable = true, updatable = true)
    @JsonProperty("")
    private Long salario;
    @Column(name = "dtabertura", nullable = true, updatable = true)
    @JsonProperty("")
    private String dtabertura;
    @Column(name = "dtfechamento", nullable = true, updatable = true)
    @JsonProperty("")
    private String dtfechamento;

    public String getDtabertura() {
        return dtabertura;
    }

    public void setDtabertura(String dtabertura) {
        this.dtabertura = dtabertura;
    }

    public String getDtfechamento() {
        return dtfechamento;
    }

    public void setDtfechamento(String dtfechamento) {
        this.dtfechamento = dtfechamento;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Long getSalario() {
        return salario;
    }

    public void setSalario(Long salario) {
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Date getDtcad() {
        return dtcad;
    }

    public void setDtcad(Date dtcad) {
        this.dtcad = dtcad;
    }

    public String getUsercad() {
        return usercad;
    }

    public void setUsercad(String usercad) {
        this.usercad = usercad;
    }

         
}
