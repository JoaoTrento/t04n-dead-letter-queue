package com.arquitetura_fag_t04n.dlq.infrastructure.adapters.out.persistence.h2.entity;

import java.util.Date;

import javax.persistence.*;

import com.arquitetura_fag_t04n.dlq.core.domain.enums.Severity;
import com.arquitetura_fag_t04n.dlq.core.domain.enums.Status;

@Entity
@Table(name = "tb_pedido_erro")
public class PedidoErroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String queueName;

    @Column(columnDefinition = "TEXT")
    private String payload;

    private Date timestamp;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Severity severity;

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    
}
