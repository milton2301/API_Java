
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
@Table(name ="contatos")
public class Contato {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "idcandidato", nullable = true, updatable = true)
    @JsonProperty("")
    private Long idcandidato;
    @Column(name = "tipo", nullable = true, updatable = true)
    @JsonProperty("")
    private String tipo;
    @Column(name = "valor", nullable = true, updatable = true)
    @JsonProperty("")
    private String valor;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdcandidato() {
        return idcandidato;
    }

    public void setIdcandidato(Long idcandidato) {
        this.idcandidato = idcandidato;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
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
