package com.manutencaopredialapi.controller;

import com.manutencaopredialapi.dto.OrdemManutencaoRequestDTO;
import com.manutencaopredialapi.dto.OrdemManutencaoResponseDTO;
import com.manutencaopredialapi.service.OrdemManutencaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "OrdemManutencao", description = "Gerenciamento de ordemmanutencaos")
@RestController
@RequestMapping("/api/ordemmanutencaos")
public class OrdemManutencaoController {

    @Autowired
    private OrdemManutencaoService service;

    @Operation(summary = "Listar todos os OrdemManutencao")
    @GetMapping
    public List<OrdemManutencaoResponseDTO> listar(@RequestParam(required = false) String descricao, @RequestParam(required = false) Long equipamentoId, @RequestParam(required = false) Long tecnicoId) {
        List<OrdemManutencaoResponseDTO> resultado = service.listar();
        if (descricao != null && !descricao.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getDescricao() != null &&
                item.getDescricao().toLowerCase().contains(descricao.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (equipamentoId != null) {
            resultado = resultado.stream().filter(item -> equipamentoId.equals(item.getEquipamentoId())).collect(java.util.stream.Collectors.toList());
        }
        if (tecnicoId != null) {
            resultado = resultado.stream().filter(item -> tecnicoId.equals(item.getTecnicoId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar OrdemManutencao por ID")
    @GetMapping("/{id}")
    public OrdemManutencaoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar OrdemManutencao")
    @PostMapping
    public ResponseEntity<OrdemManutencaoResponseDTO> criar(@Valid @RequestBody OrdemManutencaoRequestDTO ordemManutencao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(ordemManutencao));
    }

    @Operation(summary = "Atualizar OrdemManutencao")
    @PutMapping("/{id}")
    public OrdemManutencaoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody OrdemManutencaoRequestDTO ordemManutencao) {
        return service.atualizar(id, ordemManutencao);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir OrdemManutencao")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
