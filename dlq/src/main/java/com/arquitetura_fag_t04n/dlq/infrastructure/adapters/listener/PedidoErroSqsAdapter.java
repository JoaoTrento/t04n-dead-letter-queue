package com.arquitetura_fag_t04n.dlq.infrastructure.adapters.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arquitetura_fag_t04n.dlq.application.ports.in.PedidoErroServicePort;
import com.arquitetura_fag_t04n.dlq.core.domain.bo.PedidoErroBO;
import com.arquitetura_fag_t04n.dlq.infrastructure.adapters.in.massaging.pedido.dto.PedidoEventDTO;
import com.arquitetura_fag_t04n.dlq.infrastructure.adapters.in.massaging.pedido.mapper.PedidoDTOMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.awspring.cloud.sqs.annotation.SqsListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class PedidoErroSqsAdapter {
    private static final Logger log = LoggerFactory.getLogger(PedidoErroSqsAdapter.class);

    private final ObjectMapper objectMapper;

    public PedidoErroSqsAdapter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Autowired
    private PedidoErroServicePort orderService;

    @SqsListener("${queue.order-events}")
    public void listen(String message) {

        try {

            PedidoEventDTO dto = objectMapper.readValue(message, PedidoEventDTO.class);

            log.info("Mensagem com erro recebida: {}", dto.getCustomerId());

            PedidoErroBO bo = PedidoDTOMapper.toBo(dto, message);

            orderService.criarPedidoErro(bo);

        } catch (Exception e) {

            log.error("Erro ao processar mensagem da DLQ: {}", message, e);

            throw new RuntimeException(e);
        }
    }
}
