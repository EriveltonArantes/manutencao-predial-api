package com.manutencaopredialapi.dto;

public class TecnicoResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private String especialidade;
    private Boolean disponivel;
    private String telefone;
    private String crea;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }
    public Boolean getDisponivel() { return disponivel; }
    public void setDisponivel(Boolean disponivel) { this.disponivel = disponivel; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getCrea() { return crea; }
    public void setCrea(String crea) { this.crea = crea; }
}
