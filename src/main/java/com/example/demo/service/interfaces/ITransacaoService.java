package com.example.demo.service.interfaces;

import com.example.demo.domain.TransacaoRequest;

import java.util.List;

public interface ITransacaoService {

    boolean AddTransacao(TransacaoRequest transacaoRequest);

    List<TransacaoRequest> ObterTransacoes();

    void LimparTransacoes();

}
