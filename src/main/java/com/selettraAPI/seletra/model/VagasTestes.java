
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
@Table(name ="vagas_testes")
public class VagasTestes {
    
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
    @Column(name = "idcandidatura", nullable = true, updatable = true)
    @JsonProperty("")
    private Long idcandidatura;
    @Column(name = "idteste", nullable = true, updatable = true)
    @JsonProperty("")
    private Long idteste;
    @Column(name = "idcandidato", nullable = true, updatable = true)
    @JsonProperty("")
    private Long idcandidato;
    @Column(name = "descricao", nullable = true, updatable = true)
    @JsonProperty("")
    private String descricao;
    @Column(name = "valor", nullable = true, updatable = true)
    @JsonProperty("")
    private String valor;
    @Column(name = "valorcandidato", nullable = true, updatable = true)
    @JsonProperty("")
    private String valorcandidato;
    
    
    public Long getIdcandidato() {
        return idcandidato;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getValorcandidato() {
        return valorcandidato;
    }

    public void setValorcandidato(String valorcandidato) {
        this.valorcandidato = valorcandidato;
    }

    public void setIdcandidato(Long idcandidato) {
        this.idcandidato = idcandidato;
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

    public Long getIdcandidatura() {
        return idcandidatura;
    }

    public void setIdcandidatura(Long idcandidatura) {
        this.idcandidatura = idcandidatura;
    }

    public Long getIdteste() {
        return idteste;
    }

    public void setIdteste(Long idteste) {
        this.idteste = idteste;
    }
    
}
