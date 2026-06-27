package com.manutencaopredialapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "equipamentos")
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "predio_id")
    private Predio predio;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String tipo;
    @Column(nullable = false)
    private String fabricante;
    @Column(nullable = false)
    private String modelo;
    @Column(nullable = false)
    private String numeroSerie;
    private java.time.LocalDateTime dataInstalacao;
    @Column(nullable = false)
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Predio getPredio() { return predio; }
    public void setPredio(Predio predio) { this.predio = predio; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getFabricante() { return fabricante; }
    public void setFabricante(String fabricante) { this.fabricante = fabricante; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public String getNumeroSerie() { return numeroSerie; }
    public void setNumeroSerie(String numeroSerie) { this.numeroSerie = numeroSerie; }
    public java.time.LocalDateTime getDataInstalacao() { return dataInstalacao; }
    public void setDataInstalacao(java.time.LocalDateTime dataInstalacao) { this.dataInstalacao = dataInstalacao; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
