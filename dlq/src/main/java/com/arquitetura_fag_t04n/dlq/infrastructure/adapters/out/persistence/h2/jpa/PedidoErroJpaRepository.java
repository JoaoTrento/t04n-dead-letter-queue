package com.arquitetura_fag_t04n.dlq.infrastructure.adapters.out.persistence.h2.jpa;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arquitetura_fag_t04n.dlq.infrastructure.adapters.out.persistence.h2.entity.PedidoErroEntity;

public interface PedidoErroJpaRepository extends JpaRepository<PedidoErroEntity, UUID> {
}
