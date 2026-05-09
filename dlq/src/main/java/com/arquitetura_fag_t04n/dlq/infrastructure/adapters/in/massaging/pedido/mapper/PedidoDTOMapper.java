package com.arquitetura_fag_t04n.dlq.infrastructure.adapters.in.massaging.pedido.mapper;

import java.util.Date;
import java.util.List;

import com.arquitetura_fag_t04n.dlq.core.domain.bo.PedidoErroBO;
import com.arquitetura_fag_t04n.dlq.core.domain.enums.Status;
import com.arquitetura_fag_t04n.dlq.infrastructure.adapters.in.massaging.pedido.dto.OrderItemsDTO;
import com.arquitetura_fag_t04n.dlq.infrastructure.adapters.in.massaging.pedido.dto.PedidoEventDTO;

public class PedidoDTOMapper {

    private PedidoDTOMapper() {
    }

    public static PedidoErroBO toBo(PedidoEventDTO dto, String message) {
        final PedidoErroBO bo = new PedidoErroBO(); 

        bo.setQueueName("T04N_JOAO_PEDRO_CORDASSO_TRENTO");
        bo.setPayload(message);
        bo.setTimestamp(new Date());
        bo.setStatus(Status.PENDING_ANALYSIS);

        bo.setSeverity(defineQuantidadeItems(dto.getOrderItems()));

        return bo;
    }

    public static int defineQuantidadeItems(List<OrderItemsDTO> orderItemsDTO) {
        int quantidadeItems = 0;
        for (OrderItemsDTO orderItem : orderItemsDTO) {
            quantidadeItems += orderItem.getAmount();
        }

        return quantidadeItems;
    }
}
