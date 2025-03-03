package com.example.demo.controller;

import com.example.demo.domain.EstatisticaResponse;
import com.example.demo.service.impl.EstatisticaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    private final EstatisticaService _estatisticaService;

    public EstatisticaController(EstatisticaService estatisticaService){
        this._estatisticaService = estatisticaService;
    }

    @GetMapping("/calcular")
    public EstatisticaResponse ObterTransacoes(){
        return _estatisticaService.CalcularEstatisticas();
    }
}
