package com.arquitetura_fag_t04n.dlq.application.Services;

import org.springframework.stereotype.Service;

import com.arquitetura_fag_t04n.dlq.application.ports.in.PedidoErroServicePort;
import com.arquitetura_fag_t04n.dlq.application.ports.out.persistence.PedidoErroRepositoryPort;

@Service
public class PedidoErroService implements PedidoErroServicePort{
    private final PedidoErroRepositoryPort pedidoErroRepositoryPort;
}
