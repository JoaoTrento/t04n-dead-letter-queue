package com.arquitetura_fag_t04n.dlq.core.domain.bo;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.data.annotation.Id;

import com.arquitetura_fag_t04n.dlq.core.domain.enums.Severity;
import com.arquitetura_fag_t04n.dlq.core.domain.enums.Status;

public class PedidoErroBO {
    @Id
    private UUID errorId;

    private String queueName;

    @Column(columnDefinition = "TEXT")
    private String payload;

    private Date timestamp;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Severity severity;

    public UUID getErrorId() {
        return errorId;
    }

    public void setErrorId(UUID errorId) {
        this.errorId = errorId;
    }

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

    public void setSeverity(int quantidadeItems) {
        this.severity = defineSeveridade(quantidadeItems);
    }

    public Severity defineSeveridade(int quantidadeItems) {
        Severity severidade = null;
        if (quantidadeItems > 100) {
            severidade = Severity.HIGH;
        } 
        else if (quantidadeItems < 50) {
            severidade = Severity.LOW;
        } 
        else {
            severidade = Severity.MEDIUM;
        }

        return severidade;
    }
}