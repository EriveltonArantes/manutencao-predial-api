package com.manutencaopredialapi.dto;

import jakarta.validation.constraints.*;

public class EquipamentoRequestDTO {

    @NotNull(message = "PredioId é obrigatório")
    @Positive(message = "PredioId deve ser um ID válido (positivo)")
    private Long predioId;
    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "tipo não pode estar em branco")
    private String tipo;
    @NotBlank(message = "fabricante não pode estar em branco")
    private String fabricante;
    @NotBlank(message = "modelo não pode estar em branco")
    private String modelo;
    @NotBlank(message = "numero serie não pode estar em branco")
    private String numeroSerie;
    @NotNull(message = "data instalacao não pode ser nulo")
    private java.time.LocalDateTime dataInstalacao;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

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
