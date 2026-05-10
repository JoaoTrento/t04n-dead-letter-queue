package com.arquitetura_fag_t04n.dlq.infrastructure.adapters.out.persistence.h2.mapper;

import com.arquitetura_fag_t04n.dlq.core.domain.bo.PedidoErroBO;
import com.arquitetura_fag_t04n.dlq.core.domain.enums.Severity;
import com.arquitetura_fag_t04n.dlq.infrastructure.adapters.out.persistence.h2.entity.PedidoErroEntity;

public class PedidoErroMapper {
    private PedidoErroMapper() {
    }

    public static PedidoErroEntity toEntity(PedidoErroBO bo) {
        PedidoErroEntity entity = new PedidoErroEntity();

        entity.setQueueName(bo.getQueueName());
        entity.setPayload(bo.getPayload());
        entity.setTimestamp(bo.getTimestamp());
        entity.setSeverity(bo.getSeverity());
        entity.setStatus(bo.getStatus());

        return entity;
    }

    public static PedidoErroBO toBo(PedidoErroEntity entity) {
        PedidoErroBO bo = new PedidoErroBO();

        bo.setQueueName(entity.getQueueName());
        bo.setPayload(entity.getPayload());
        bo.setTimestamp(entity.getTimestamp());
        bo.setSeverity(entity.getSeverity());
        bo.setStatus(entity.getStatus());

        return bo;
    }
}
