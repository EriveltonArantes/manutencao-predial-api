package com.manutencaopredialapi.controller;

import com.manutencaopredialapi.dto.PredioRequestDTO;
import com.manutencaopredialapi.dto.PredioResponseDTO;
import com.manutencaopredialapi.service.PredioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Predio", description = "Gerenciamento de predios")
@RestController
@RequestMapping("/api/predios")
public class PredioController {

    @Autowired
    private PredioService service;

    @Operation(summary = "Listar todos os Predio")
    @GetMapping
    public List<PredioResponseDTO> listar(@RequestParam(required = false) String nome) {
        List<PredioResponseDTO> resultado = service.listar();
        if (nome != null && !nome.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getNome() != null &&
                item.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Predio por ID")
    @GetMapping("/{id}")
    public PredioResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Predio")
    @PostMapping
    public ResponseEntity<PredioResponseDTO> criar(@Valid @RequestBody PredioRequestDTO predio) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(predio));
    }

    @Operation(summary = "Atualizar Predio")
    @PutMapping("/{id}")
    public PredioResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody PredioRequestDTO predio) {
        return service.atualizar(id, predio);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Predio")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
