package com.manutencaopredialapi.dto;

public class PredioResponseDTO {

    private Long id;
    private String nome;
    private String endereco;
    private String cidade;
    private Integer andares;
    private Double area;
    private String tipo;
    private String responsavel;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
