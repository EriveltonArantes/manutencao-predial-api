package com.manutencaopredialapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ordemmanutencoes")
public class OrdemManutencao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "equipamento_id")
    private Equipamento equipamento;
    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;
    @Column(nullable = false)
    private String tipo;
    @Column(nullable = false)
    private String prioridade;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String descricao;
    @Column(nullable = false)
    private String status;
    private java.time.LocalDateTime dataAbertura;
    private java.time.LocalDateTime dataConclusao;
    private java.math.BigDecimal custo;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Equipamento getEquipamento() { return equipamento; }
    public void setEquipamento(Equipamento equipamento) { this.equipamento = equipamento; }
    public Tecnico getTecnico() { return tecnico; }
    public void setTecnico(Tecnico tecnico) { this.tecnico = tecnico; }
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
