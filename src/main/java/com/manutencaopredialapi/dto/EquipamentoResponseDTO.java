package com.manutencaopredialapi.dto;

public class EquipamentoResponseDTO {

    private Long id;
    private Long predioId;
    private String nome;
    private String tipo;
    private String fabricante;
    private String modelo;
    private String numeroSerie;
    private java.time.LocalDateTime dataInstalacao;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getPredioId() { return predioId; }
    public void setPredioId(Long predioId) { this.predioId = predioId; }
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
