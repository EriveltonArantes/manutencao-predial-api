package com.manutencaopredialapi.dto;

import jakarta.validation.constraints.*;

public class TecnicoRequestDTO {

    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "email não pode estar em branco")
    @Email(message = "email precisa ser um e-mail válido")
    private String email;
    @NotBlank(message = "especialidade não pode estar em branco")
    private String especialidade;
    @NotNull(message = "disponivel não pode ser nulo")
    private Boolean disponivel;
    @NotBlank(message = "telefone não pode estar em branco")
    private String telefone;
    @NotBlank(message = "crea não pode estar em branco")
    @Size(min = 4, max = 20, message = "crea inválido")
    private String crea;

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
