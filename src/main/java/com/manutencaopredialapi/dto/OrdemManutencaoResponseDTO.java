package com.manutencaopredialapi.dto;

public class OrdemManutencaoResponseDTO {

    private Long id;
    private Long equipamentoId;
    private Long tecnicoId;
    private String tipo;
    private String prioridade;
    private String descricao;
    private String status;
    private java.time.LocalDateTime dataAbertura;
    private java.time.LocalDateTime dataConclusao;
    private java.math.BigDecimal custo;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getEquipamentoId() { return equipamentoId; }
    public void setEquipamentoId(Long equipamentoId) { this.equipamentoId = equipamentoId; }
    public Long getTecnicoId() { return tecnicoId; }
    public void setTecnicoId(Long tecnicoId) { this.tecnicoId = tecnicoId; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getPrioridade() { return prioridade; }
    public void setPrioridade(String prioridade) { this.prioridade = prioridade; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public java.time.LocalDateTime getDataAbertura() { return dataAbertura; }
    public void setDataAbertura(java.time.LocalDateTime dataAbertura) { this.dataAbertura = dataAbertura; }
    public java.time.LocalDateTime getDataConclusao() { return dataConclusao; }
    public void setDataConclusao(java.time.LocalDateTime dataConclusao) { this.dataConclusao = dataConclusao; }
    public java.math.BigDecimal getCusto() { return custo; }
    public void setCusto(java.math.BigDecimal custo) { this.custo = custo; }
}
