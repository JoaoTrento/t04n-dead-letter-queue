package com.arquitetura_fag_t04n.dlq.application.Services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.arquitetura_fag_t04n.dlq.application.ports.in.PedidoErroServicePort;
import com.arquitetura_fag_t04n.dlq.application.ports.out.persistence.PedidoErroRepositoryPort;
import com.arquitetura_fag_t04n.dlq.core.domain.bo.PedidoErroBO;

@Service
public class PedidoErroService implements PedidoErroServicePort{
    private final PedidoErroRepositoryPort pedidoErroRepositoryPort;

    public PedidoErroService(PedidoErroRepositoryPort pedidoErroRepositoryPort) {
        this.pedidoErroRepositoryPort = pedidoErroRepositoryPort;
    }

    @Override
    @Transactional
    public PedidoErroBO criarPedidoErro(PedidoErroBO pedidoErroBO) {
        return pedidoErroRepositoryPort.salvar(pedidoErroBO);
    }
}
