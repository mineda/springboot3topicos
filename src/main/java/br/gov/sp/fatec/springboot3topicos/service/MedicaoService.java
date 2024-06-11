package br.gov.sp.fatec.springboot3topicos.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springboot3topicos.entity.Medicao;
import br.gov.sp.fatec.springboot3topicos.repository.MedicaoRepository;

@Service
public class MedicaoService {

    @Autowired
    private MedicaoRepository repo;

    public List<Medicao> todas() {
        return repo.findAll();
    }

    public Medicao nova(Medicao medicao) {
        if(medicao == null ||
                medicao.getTipo() == null ||
                medicao.getTipo().isBlank() ||
                medicao.getDataHora() == null ||
                medicao.getValor() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos!");
        }
        
        return repo.save(medicao);
    }

    public List<Medicao> buscarPorDataHoraEValor(LocalDateTime dataHora, BigDecimal valor) {
        return repo.findByDataHoraGreaterThanAndValorGreaterThan(dataHora, valor);
    }
    
}