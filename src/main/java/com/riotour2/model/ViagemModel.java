package com.riotour2.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="tb_viagem")
public class ViagemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String foto;

    @NotBlank
    private String titulo;

    @NotNull
    @Digits(integer=9, fraction=2)
    private BigDecimal preco;

    @NotBlank
    private String descricao;

    @NotNull
    private int tamMaxGrupo;

    @NotBlank
    private String duracaoExpedicao;

    @NotNull
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataChegada;

    @ManyToOne
    @JsonIgnoreProperties("viagem")
    private CategoriaModel categoria;

    @ManyToMany(mappedBy = "viagem", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("viagem")
    private List<UsuarioModel> usuario;

    public ViagemModel() {}

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getTamMaxGrupo() {
        return tamMaxGrupo;
    }
    public void setTamMaxGrupo(int tamMaxGrupo) {
        this.tamMaxGrupo = tamMaxGrupo;
    }
    public String getDuracaoExpedicao() {
        return duracaoExpedicao;
    }
    public void setDuracaoExpedicao(String duracaoExpedicao) {
        this.duracaoExpedicao = duracaoExpedicao;
    }

    public LocalDate getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(LocalDate dataChegada) {
        this.dataChegada = dataChegada;
    }

    public CategoriaModel getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaModel categoria) {
        this.categoria = categoria;
    }

    public List<UsuarioModel> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<UsuarioModel> usuario) {
        this.usuario = usuario;
    }
}
