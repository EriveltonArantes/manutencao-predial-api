package com.manutencaopredialapi.controller;

import com.manutencaopredialapi.model.Tecnico;
import com.manutencaopredialapi.model.Predio;
import com.manutencaopredialapi.model.Equipamento;
import com.manutencaopredialapi.model.OrdemManutencao;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Tag(name = "Dashboard", description = "KPIs e totais do sistema")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private com.manutencaopredialapi.repository.TecnicoRepository tecnicoRepository;

    @Autowired
    private com.manutencaopredialapi.repository.PredioRepository predioRepository;

    @Autowired
    private com.manutencaopredialapi.repository.EquipamentoRepository equipamentoRepository;

    @Autowired
    private com.manutencaopredialapi.repository.OrdemManutencaoRepository ordemManutencaoRepository;

    @Operation(summary = "Resumo com totais, somas e gráficos de status")
    @Transactional(readOnly = true)
    @GetMapping("/resumo")
    public Map<String, Object> resumo() {
        Map<String, Object> resumo = new LinkedHashMap<>();
        resumo.put("totalTecnico", tecnicoRepository.count());
        resumo.put("totalPredio", predioRepository.count());
        resumo.put("somaAreaPredio", predioRepository.findAll().stream().filter(e -> e.getArea() != null).mapToDouble(e -> e.getArea()).sum());
        resumo.put("totalEquipamento", equipamentoRepository.count());
        resumo.put("graficoEquipamento", equipamentoRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalOrdemManutencao", ordemManutencaoRepository.count());
        resumo.put("somaCustoOrdemManutencao", ordemManutencaoRepository.findAll().stream().map(e -> e.getCusto()).filter(v -> v != null).reduce(java.math.BigDecimal.ZERO, java.math.BigDecimal::add));
        resumo.put("graficoOrdemManutencao", ordemManutencaoRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        return resumo;
    }
}
