package com.example.demo.service.impl;

import com.example.demo.domain.TransacaoRequest;
import com.example.demo.repository.TransacaoRepository;
import com.example.demo.service.interfaces.ITransacaoService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransacaoService implements ITransacaoService {

    private final TransacaoRepository _transacaoRepository;

    public TransacaoService(TransacaoRepository transacaoRepository) {
        this._transacaoRepository = transacaoRepository;
    }

    @Override
    public boolean  AddTransacao(TransacaoRequest transacaoRequest) {
        _transacaoRepository.adicionarTransacao(transacaoRequest);
        return true;
    }

    @Override
    public List<TransacaoRequest> ObterTransacoes() {
        return _transacaoRepository.obterTransacoes();
    }

    @Override
    public void LimparTransacoes() {
        _transacaoRepository.limparTransacoes();
    }
}