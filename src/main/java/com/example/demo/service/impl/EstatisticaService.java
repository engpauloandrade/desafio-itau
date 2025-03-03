package com.example.demo.service.impl;

import com.example.demo.domain.EstatisticaResponse;
import com.example.demo.domain.TransacaoRequest;
import com.example.demo.repository.TransacaoRepository;
import com.example.demo.service.interfaces.IEstatisticaService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Service
public class EstatisticaService implements IEstatisticaService {

    private final TransacaoRepository _transacaoRepository;

    public EstatisticaService(TransacaoRepository transacaoRepository) {
        this._transacaoRepository = transacaoRepository;
    }

    @Override
    public EstatisticaResponse CalcularEstatisticas() {
        Instant limiteInstant = Instant.now().minusSeconds(60);
        OffsetDateTime limite = OffsetDateTime.ofInstant(limiteInstant, ZoneOffset.UTC); // Convertendo para OffsetDateTime

        List<TransacaoRequest> ultimasTransacoes = _transacaoRepository.obterTransacoes().stream()
                .filter(t -> t.getDataHora().isAfter(limite)) // Agora ambos são OffsetDateTime
                .toList();

        if (ultimasTransacoes.isEmpty()) {
            return new EstatisticaResponse(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, 0);
        }

        BigDecimal sum = ultimasTransacoes.stream()
                .map(TransacaoRequest::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal avg = sum.divide(BigDecimal.valueOf(ultimasTransacoes.size()), BigDecimal.ROUND_HALF_UP);
        BigDecimal max = ultimasTransacoes.stream().map(TransacaoRequest::getValor).max(BigDecimal::compareTo).orElse(BigDecimal.ZERO);
        BigDecimal min = ultimasTransacoes.stream().map(TransacaoRequest::getValor).min(BigDecimal::compareTo).orElse(BigDecimal.ZERO);

        return new EstatisticaResponse(sum, avg, max, min, ultimasTransacoes.size());
    }
}
