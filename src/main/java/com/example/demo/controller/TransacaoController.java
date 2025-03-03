package com.example.demo.controller;

import com.example.demo.service.impl.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;
import com.example.demo.domain.TransacaoRequest;

import java.util.List;

@RestController
@RequestMapping("v1/transacao")
public class TransacaoController {

    private final TransacaoService _transacaoService;

    public TransacaoController(TransacaoService transacaoService){
        this._transacaoService = transacaoService;
    }

    @PostMapping("/salvar")
    public  ResponseEntity<Void> AddTransacoes(@Valid  @RequestBody TransacaoRequest transacaoRequest){
        try {
            boolean salva = _transacaoService.AddTransacao(transacaoRequest);
            return ResponseEntity.status(HttpStatus.CREATED).build();

        } catch (HttpMessageNotReadableException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/listar")
    public List<TransacaoRequest> ObterTransacoes(){
        return _transacaoService.ObterTransacoes();
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<Void> DeletarTransacoes(){
        _transacaoService.LimparTransacoes();
        return  ResponseEntity.ok().build();
    }
}
