
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
@Table(name ="usuarios")
public class Usuarios {
    
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
    @Column(name = "nome", nullable = true, updatable = true)
    @JsonProperty("")
    private String nome;
    @Column(name = "suspenso", nullable = true, updatable = true)
    @JsonProperty("")
    private Boolean suspenso;
    @Column(name = "senha", nullable = true, updatable = true)
    @JsonProperty("")
    private String senha;
    @Column(name = "usuario", nullable = true, updatable = true)
    @JsonProperty("")
    private String usuario;
    @Column(name = "email", nullable = true, updatable = true)
    @JsonProperty("")
    private String email;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getSuspenso() {
        return suspenso;
    }

    public void setSuspenso(Boolean suspenso) {
        this.suspenso = suspenso;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}