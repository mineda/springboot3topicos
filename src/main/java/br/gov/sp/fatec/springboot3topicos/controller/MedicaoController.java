package br.gov.sp.fatec.springboot3topicos.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springboot3topicos.entity.Medicao;
import br.gov.sp.fatec.springboot3topicos.service.MedicaoService;

@RestController
@RequestMapping(value = "/medicao")
@CrossOrigin
public class MedicaoController {

    @Autowired
    private MedicaoService service;

    @GetMapping
    public List<Medicao> buscarTodas() {
        return service.todas();
    }

    @PostMapping
    public Medicao nova(@RequestBody Medicao medicao) {
        return service.nova(medicao);
    }

    @GetMapping(value = "/{dataHora}/{valor}")
    public List<Medicao> buscarPorConteudoOuDataHoraPrevista(@PathVariable("dataHora") LocalDateTime dataHora, @PathVariable("valor") BigDecimal valor) {
        return service.buscarPorDataHoraEValor(dataHora, valor);
    }
    

}

