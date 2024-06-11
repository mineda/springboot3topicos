package br.gov.sp.fatec.springboot3topicos.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springboot3topicos.entity.Medicao;

public interface MedicaoRepository extends JpaRepository<Medicao, Long>{

    public List<Medicao> findByDataHoraGreaterThanAndValorGreaterThan(LocalDateTime dataHora, BigDecimal valor);
    
}
