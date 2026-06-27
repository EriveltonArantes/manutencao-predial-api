package com.manutencaopredialapi.dto;

import jakarta.validation.constraints.*;

public class OrdemManutencaoRequestDTO {

    @NotNull(message = "EquipamentoId é obrigatório")
    @Positive(message = "EquipamentoId deve ser um ID válido (positivo)")
    private Long equipamentoId;
    @NotNull(message = "TecnicoId é obrigatório")
    @Positive(message = "TecnicoId deve ser um ID válido (positivo)")
    private Long tecnicoId;
    @NotBlank(message = "tipo não pode estar em branco")
    private String tipo;
    @NotBlank(message = "prioridade não pode estar em branco")
    private String prioridade;
    @NotBlank(message = "descricao não pode estar em branco")
    private String descricao;
    @NotBlank(message = "status não pode estar em branco")
    private String status;
    @NotNull(message = "data abertura não pode ser nulo")
    private java.time.LocalDateTime dataAbertura;
    @NotNull(message = "data conclusao não pode ser nulo")
    private java.time.LocalDateTime dataConclusao;
    @DecimalMin(value = "0.0", message = "custo não pode ser negativo")
    @NotNull(message = "custo não pode ser nulo")
    private java.math.BigDecimal custo;

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
