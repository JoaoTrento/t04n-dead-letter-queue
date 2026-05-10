package com.arquitetura_fag_t04n.dlq.infrastructure.adapters.out.persistence.h2.repository;

import org.springframework.stereotype.Repository;

import com.arquitetura_fag_t04n.dlq.application.ports.out.persistence.PedidoErroRepositoryPort;
import com.arquitetura_fag_t04n.dlq.core.domain.bo.PedidoErroBO;
import com.arquitetura_fag_t04n.dlq.infrastructure.adapters.out.persistence.h2.entity.PedidoErroEntity;
import com.arquitetura_fag_t04n.dlq.infrastructure.adapters.out.persistence.h2.jpa.PedidoErroJpaRepository;
import com.arquitetura_fag_t04n.dlq.infrastructure.adapters.out.persistence.h2.mapper.PedidoErroMapper;

@Repository
public class PedidoErroRepositoryAdapter implements PedidoErroRepositoryPort{
    private final PedidoErroJpaRepository pedidoErroJpaRepository;

    public PedidoErroRepositoryAdapter(PedidoErroJpaRepository pedidoErroJpaRepository) {
        this.pedidoErroJpaRepository = pedidoErroJpaRepository;
    }

    @Override
    public PedidoErroBO salvar (PedidoErroBO bo) {
        final PedidoErroEntity entity = PedidoErroMapper.toEntity(bo);

        final PedidoErroEntity pedidoErroSalvo = pedidoErroJpaRepository.save(entity);
        return PedidoErroMapper.toBo(pedidoErroSalvo);
    }
}
