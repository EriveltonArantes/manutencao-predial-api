package com.manutencaopredialapi.repository;

import com.manutencaopredialapi.model.Predio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PredioRepository extends JpaRepository<Predio, Long> {
}
