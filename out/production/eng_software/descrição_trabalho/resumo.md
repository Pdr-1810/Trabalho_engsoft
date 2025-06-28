# Resumo do Trabalho de Biblioteca

## Objetivo
Projetar e implementar um sistema orientado a objetos para gerenciar uma Biblioteca acadêmica, aplicando princípios e padrões de projeto.

## Visão Geral
O sistema gerencia livros e três tipos de usuários (alunos de graduação, pós-graduação e professores), permitindo:
- Empréstimo
- Devolução
- Biblioteca.Reserva
- Observação de livros

Cada tipo de usuário tem regras e prazos específicos para empréstimos.

## Funcionalidades Principais
- **Empréstimo:** Usuários podem pegar livros emprestados, seguindo regras específicas para cada tipo.
- **Devolução:** Permite devolver livros.
- **Biblioteca.Reserva:** Usuários podem reservar livros, com prioridade entre alunos.
- **Observação:** Professores podem ser notificados quando um livro tem mais de duas reservas.
- **Consultas:** Permite consultar informações de livros, usuários e notificações.
- **Sair:** Comando para encerrar o sistema.

## Regras Importantes
- Cada tipo de usuário tem limites e prazos diferentes para empréstimos.
- Professores não têm limite de empréstimos e não são afetados por reservas.
- O sistema deve ser flexível para adicionar novos tipos de usuários e regras no futuro.

## Exigências Técnicas
- Não usar banco de dados; dados são instanciados na memória.
- Usar padrão Singleton para a classe `Biblioteca.Repositorio`.
- Não implementar cadastro de livros, usuários ou exemplares.
- Interface apenas via linha de comando.
- Usar padrão Command para processar comandos.
- Evitar condicionais para distinguir tipos de usuários; usar padrão de projeto adequado para regras de




--- 


