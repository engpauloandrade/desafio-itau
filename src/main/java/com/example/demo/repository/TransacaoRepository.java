package com.example.demo.repository;

import com.example.demo.domain.TransacaoRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class TransacaoRepository {
    private final List<TransacaoRequest> transacoes = new CopyOnWriteArrayList<>();

    public void adicionarTransacao(TransacaoRequest transacaoRequest) {
        transacoes.add(transacaoRequest);
    }

    public List<TransacaoRequest> obterTransacoes() {
        return transacoes;
    }

    public void limparTransacoes() {
        transacoes.clear();
    }
}