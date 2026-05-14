# DLQ Auditor Service

Este trabalho trata-se de uma atividade da disciplina de Arquitetura de Software, do 5º período de Engenharia de Software da Faculdade Assis Gurgacz - FAG.

## Objetivo

O objetivo do projeto é desenvolver um serviço responsável por consumir mensagens com falha presentes na fila DLQ (Dead Letter Queue) da AWS SQS.

Após consumir a mensagem, o sistema realiza uma triagem simples para definir a severidade do erro com base na quantidade total de itens do pedido, persistindo posteriormente os dados em um banco de auditoria para futuras análises.

---

## Arquitetura Escolhida

A arquitetura escolhida foi a Arquitetura Hexagonal.

Ela foi escolhida pela sua modularidade e baixo acoplamento, permitindo a troca de serviços externos sem impactar diretamente nas regras de negócio da aplicação.

Com essa abordagem, o núcleo do sistema permanece independente de tecnologias específicas, facilitando futuras alterações na infraestrutura quando comparado com arquiteturas mais tradicionais, como o MVC, permitindo:

- implementação de mecanismos de backup ou redundância;
- troca do banco de dados;
- substituição do serviço de mensageria;
- criação de novos métodos de entrada e saída de dados;

---

14/05/2026
