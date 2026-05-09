package com.arquitetura_fag_t04n.dlq.application.ports.out.persistence;

import com.arquitetura_fag_t04n.dlq.core.domain.bo.PedidoErroBO;

public interface PedidoErroRepositoryPort {
    PedidoErroBO salvar(PedidoErroBO pedidoBO);
}
