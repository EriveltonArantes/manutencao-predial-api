package com.manutencaopredialapi.dto;

import jakarta.validation.constraints.*;

public class PredioRequestDTO {

    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "endereco não pode estar em branco")
    private String endereco;
    @NotBlank(message = "cidade não pode estar em branco")
    private String cidade;
    @NotNull(message = "andares não pode ser nulo")
    private Integer andares;
    @NotNull(message = "area não pode ser nulo")
    private Double area;
    @NotBlank(message = "tipo não pode estar em branco")
    private String tipo;
    @NotBlank(message = "responsavel não pode estar em branco")
    private String responsavel;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    public Integer getAndares() { return andares; }
    public void setAndares(Integer andares) { this.andares = andares; }
    public Double getArea() { return area; }
    public void setArea(Double area) { this.area = area; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getResponsavel() { return responsavel; }
    public void setResponsavel(String responsavel) { this.responsavel = responsavel; }
}
