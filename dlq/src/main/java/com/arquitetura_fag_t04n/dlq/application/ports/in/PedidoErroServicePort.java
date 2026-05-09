package com.arquitetura_fag_t04n.dlq.application.ports.in;

import com.arquitetura_fag_t04n.dlq.core.domain.bo.PedidoErroBO;

public interface PedidoErroServicePort {
    PedidoErroBO criarPedidoErro(PedidoErroBO pedidoBO);
}
